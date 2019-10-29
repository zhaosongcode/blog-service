package org.personal.blog.util;

import org.personal.blog.consts.MailConsts;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zs on 2019/8/13
 * 邮件工具类
 */
public class MailUtil {

    /**
     * @Param []
     * @Return void
     * @Author zs
     * @Date 2019/8/14 15:18
     * 功能描述：发送邮件
     */
    public static void sendMail(String toMail, String subject, String content){
        // 参数配置
        Properties props = new Properties();
        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", MailConsts.MAIL_TRAN_PROTO_VALUE);
        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.host", MailConsts.MAIL_HOST_VALUE);
        // 需要请求认证
        props.setProperty("mail.smtp.auth", MailConsts.MAIL_AUTH_VALUE);
        props.setProperty("mail.user", MailConsts.MAIL_USERNAME_VALUE);
        props.setProperty("mail.password", MailConsts.MAIL_PASSWORD_VALUE);
        //验证账号密码(授权码)
        Session session = Session.getInstance(props, new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(MailConsts.MAIL_USERNAME_VALUE, MailConsts.MAIL_PASSWORD_VALUE); //发件人邮件用户名、授权码
            }
        });
        //设置为debug详细查看发送
        //session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        //设置主题
        try {
            message.setSubject(subject);
            //设置邮件内容
            StringBuffer sb = new StringBuffer();
            sb.append(content);
            MimeBodyPart mbp1 = new MimeBodyPart(); // 正文
            mbp1.setContent(content.toString(), "text/html;charset=utf-8");
            Multipart mp = new MimeMultipart(); // 整个邮件：正文+附件
            mp.addBodyPart(mbp1);
            message.setContent(mp);
            message.setSentDate(new Date());
            message.saveChanges();
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toMail));
            Address address = new InternetAddress(MailConsts.MAIL_USERNAME_VALUE, "BLOG服务中心");
            //设置发件人
            message.setFrom(address);
            //发送
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
