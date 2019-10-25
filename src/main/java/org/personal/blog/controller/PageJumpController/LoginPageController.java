package org.personal.blog.controller.PageJumpController;

import org.personal.blog.consts.common.CommonConsts;
import org.personal.blog.util.common.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zs on 2019/8/8
 * 登录相关页面跳转
 */
@Controller
public class LoginPageController {

    private static final String VIEW = "login/";

    /**
     * @Param []
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/15 9:56
     * 功能描述：登录跳转页面
     */
    @RequestMapping("/login")
    public String login(){
        //判断是否已经登录
        Object object = Tools.getSession().getAttribute(CommonConsts.SESSION_USER);
        Boolean judge = false;
        if(object != null){
            judge = true;
        }
        if(judge){
            return "index";
        }
        return VIEW + "login";
    }

    /**
     * @Param []
     * @Return java.lang.String
     * @Author zs
     * @Date 2019/8/27 11:52
     * 功能描述：注册
     */
    @RequestMapping("/register")
    public String register(){
        return "register/register";
    }
}
