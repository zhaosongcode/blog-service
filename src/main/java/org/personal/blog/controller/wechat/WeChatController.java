package org.personal.blog.controller.wechat;

import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zs on 2019/10/23
 * 微信接口
 */
@RestController
@RequestMapping("wechat")
public class WeChatController {

    @Autowired
    private WxMpService wxMpService;

    /**
     * @Param [request, response]
     * @Return void
     * @Author zs
     * @Date 2019/10/23 17:25
     * 功能描述：微信交互对接接口
     */
    @RequestMapping("/wechatDocking")
    public void test1(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String signature = request.getParameter("signature");
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            // 消息签名不正确，说明不是公众平台发过来的消息
            response.getWriter().println("非法请求");
            return;
        }
        String echostr = request.getParameter("echostr");
        if (StringUtils.isNotBlank(echostr)) {
            // 说明是一个仅仅用来验证的请求，回显echostr
            response.getWriter().println(echostr);
            return;
        }
    }
}
