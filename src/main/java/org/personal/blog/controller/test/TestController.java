package org.personal.blog.controller.test;

import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by zs on 2019/8/1
 * 测试接口
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private WxMpService wxMpService;

    /**
     * @Param []
     * @Return java.lang.Object
     * @Author zs
     * @Date 2019/10/23 15:09
     * 功能描述：测试微信对接接口
     */
    @RequestMapping("/weChatTest")
    public void test1(HttpServletRequest request, HttpServletResponse response)throws Exception{
        /*String timestamp = request.getParameter("timestamp");
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
        }*/
        /*String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ?
                "raw" :
                request.getParameter("encrypt_type");

        WxMpXmlMessage inMessage = null;

        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
        } else if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            String msgSignature = request.getParameter("msg_signature");
            inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), wxMpConfigStorage, timestamp, nonce, msgSignature);
        } else {
            response.getWriter().println("不可识别的加密类型");
            return;
        }

        WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);

        if (outMessage != null) {
            if ("raw".equals(encryptType)) {
                response.getWriter().write(outMessage.toXml());
            } else if ("aes".equals(encryptType)) {
                response.getWriter().write(outMessage.toEncryptedXml(wxMpConfigStorage));
            }
            return;
        }*/
        return;
    }
}
