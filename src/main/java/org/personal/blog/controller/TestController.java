package org.personal.blog.controller;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import org.apache.commons.lang3.StringUtils;
import org.personal.blog.mapper.BlogUserMapper;
import org.personal.blog.pojo.entity.BlogUser;
import org.personal.blog.util.QRCodeUtil;
import org.personal.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by zs on 2019/10/25
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    BlogUserMapper userMapper;

    @RequestMapping("/test4")
    public Object test4(){
        List<BlogUser> blogUsers = userMapper.selectAll();
        return ResultUtil.success();
    }
}
