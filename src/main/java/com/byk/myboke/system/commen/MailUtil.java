package com.byk.myboke.system.commen;

import com.byk.myboke.boke.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import sun.util.PreHashedMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: bianyakun
 * @Date: 2018/6/13 18:11
 * @Todo:
 */
@Component
public class MailUtil {

    @Autowired
    private  JavaMailSender javaMailSender;

    /**
     * @Author: bianyakun
     * @Date: 2018/6/13 18:02
     * @todo: 给管理员的邮箱发送邮件
     * @param:   * @param null
     */
    public   void sendEmailToMe(Message message1,String IP)  {
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("ykbian@qq.com");
            helper.setTo("ykbian@qq.com");
            String subject = "来自"+message1.getFullname()+"的留言";
            helper.setSubject(subject);
            String sb = MailUtil.toHtml2(message1,IP);
            helper.setText(sb, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }


    /**
     * @Author: bianyakun
     * @Date: 2018/6/14 11:56
     * @todo: 回复访客邮箱
     * @param:   * @param null
     */
    public   void sendEmailToVistor(Message message1)  {
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("ykbian@qq.com");
            helper.setTo(message1.getEmailaddress());
            helper.setSubject("留言回复");
            String sb = MailUtil.toHtml3(message1);
            helper.setText(sb, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }

    public static  String toHtml2(Message message1,String IP){
        String suject = message1.getSubject();
        String name = message1.getFullname();
        String msg = message1.getMessage();
        String from = message1.getEmailaddress();
        String phone = message1.getPhonenumber();
        StringBuffer sb = new StringBuffer();
        sb.append("<h3 style='color: #d9001f'>您有新的留言：</h3>");
        sb.append("<p><strong>访客：</strong>"+name+"</p>");
        sb.append("<p><strong>留言主题：</strong>"+suject+"</p>");
        sb.append("<p><strong>他的电话：</strong>"+phone+"</p>");
        sb.append("<p><strong>他的邮箱：</strong>"+from+"</p>");
        sb.append("<p><strong>他的IP：</strong>"+IP+"</p>");
        sb.append("<p><strong>正文：</strong>"+msg+"</p>");
        return sb.toString();
    }

    public static  String toHtml3(Message message1){
        String name = message1.getFullname();
        StringBuffer sb = new StringBuffer();
        sb.append("<p>您好!"+name+"，留言我已经收到了，我会尽快回复您的。</p>");
        sb.append("<p>    祝您工作愉快！</p>");
        sb.append("<p style='text-align:right'>稚子候门</p>");
        return sb.toString();
    }
}
