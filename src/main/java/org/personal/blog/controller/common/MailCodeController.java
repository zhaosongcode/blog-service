package org.personal.blog.controller.common;

import org.personal.blog.util.common.Tools;
import org.personal.blog.util.mail.MailUtil;
import org.personal.blog.util.number.NumberTools;
import org.personal.blog.util.redis.RedisTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by zs on 2019/8/14
 * 邮件发送验证码
 */
@RestController
@RequestMapping("/mail")
public class MailCodeController {

    @Autowired
    private RedisTools redisTools;

    /**
     * @Param []
     * @Return boolean
     * @Author zs
     * @Date 2019/8/14 18:28
     * 功能描述：发送登录密码
     */
    @RequestMapping("/getLoginCode")
    public boolean generaCode(String mail){
        String code = NumberTools.get4IntNum();
        String content = "您好，您正在申请登录博客，您的登录验证码是<h3 style=\"color: red\">"+code+"</h3>" +
                "如果您没有进行相关操作，请忽略此邮件。";
        MailUtil.sendMail(mail,"登录验证", content);
        //并将验证码存入redis
        String id = (String) Tools.getSession().getId();
        redisTools.set(id,code,60);
        return true;
    }
}
