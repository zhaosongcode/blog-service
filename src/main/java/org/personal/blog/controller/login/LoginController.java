package org.personal.blog.controller.login;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.personal.blog.bean.BlogRecordLogin;
import org.personal.blog.bean.BlogUser;
import org.personal.blog.config.shiro.FreeSecret;
import org.personal.blog.consts.common.CommonConsts;
import org.personal.blog.consts.result.code.BaseCode;
import org.personal.blog.consts.result.msg.BaseMsg;
import org.personal.blog.service.LoginService;
import org.personal.blog.util.common.Tools;
import org.personal.blog.util.redis.RedisTools;
import org.personal.blog.util.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zs on 2019/8/1
 * 登录控制
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisTools redisTools;

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    /**
     * @Param []
     * @Return java.lang.Object
     * @Author zs
     * @Date 2019/8/1 18:23
     * 功能描述：执行登录
     */
    @RequestMapping(value = "/loginDo",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public Object loginDo(@RequestParam Map<String,Object> parMap){
        String info = null;
        if(parMap != null) {
            int action = Integer.parseInt((String) parMap.get("action"));
            if (action == 1) {
                //账号登录
                return accountLogin(parMap, info);
            }
            //邮箱登录
            return emailLogin(parMap);
        }
        return ResultUtil.error(BaseMsg.PARAM_NULL);
    }

    /**
     * @Param
     * @Return
     * @Author zs
     * @Date 2019/8/14 15:47
     * 功能描述：账号登录
     */
    public Object accountLogin(Map<String,Object> parMap, String info){
        String code = (String) parMap.get("code");//验证码
        String userName = (String) parMap.get("userName");//用户名
        String password = (String) parMap.get("password");//密码
        if(code != null && !"".equals(code)){
            Session session = Tools.getSession();
            String sessionId = (String) session.getId();
            String redisCode = (String) redisTools.get(sessionId);
            //判断验证码/不区分大小写
            if(code.equalsIgnoreCase(redisCode)){
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
                subject.logout();
                try {
                    subject.login(token);
                    //登录成功获取用户对象
                    BlogUser user = loginService.getUser(userName);
                    //登录成功删除验证码
                    redisTools.del(sessionId);
                    //登录成功存入记录
                    BlogRecordLogin recordLogin = new BlogRecordLogin();
                    recordLogin.setAddress((String) parMap.get("address"));
                    recordLogin.setBrowser((String) parMap.get("browser"));
                    recordLogin.setCreateTime(new Date());
                    recordLogin.setDevice((String) parMap.get("device"));
                    recordLogin.setIp((String) parMap.get("ip"));
                    recordLogin.setUserId(user.getUserId());
                    loginService.saveRecordLogin(recordLogin);
                    log.info("用户<"+userName+">登录系统");
                    return ResultUtil.success();
                } catch (UnknownAccountException e) {
                    //账号不存在
                    info = "账号不存在!";
                    log.info(info);
                    return ResultUtil.error(info);
                }catch (IncorrectCredentialsException e){
                    info = "密码错误!";
                    log.info(info);
                    return ResultUtil.error(info);
                }
            }
            return ResultUtil.error(BaseMsg.CODE_ERROR);
        }
        return ResultUtil.error("验证码为空");
    }

    /**
     * @Param []
     * @Return void
     * @Author zs
     * @Date 2019/8/14 17:36
     * 功能描述：邮箱登录
     */
    public Object emailLogin(Map<String,Object> parMap){
        //首先获验证码
        String code = (String) parMap.get("code");//验证码
        if(code != null && !"".equals(code)){
            Session session = Tools.getSession();
            String sessionId = (String) session.getId();
            String redisCode = (String) redisTools.get(sessionId);
            //判断验证码/不区分大小写
            if(redisCode != null){
                if(code.equalsIgnoreCase(redisCode)){
                    //验证码正确则根据邮箱查询用户
                    BlogUser user = loginService.getUserByEmail((String)parMap.get("email"));
                    if(user != null){
                        //免密登录并存入user信息
                        UsernamePasswordToken token = new UsernamePasswordToken(new FreeSecret().getUserName(), new FreeSecret().getPassword());
                        Subject subject = SecurityUtils.getSubject();
                        subject.login(token);
                        session.setAttribute(CommonConsts.SESSION_USER,user);
                        //删除验证码
                        redisTools.del(sessionId);
                        log.info("用户：["+user.getUserName()+"]通过邮箱登录系统!");
                        return ResultUtil.success();
                    }
                    return ResultUtil.error("对不起，此邮箱尚未注册!");
                }
                return ResultUtil.error("验证码错误");
            }
            return ResultUtil.error("验证码失效,请重新发送");
        }
        return ResultUtil.error("验证码为空");
    }
}
