package com.byk.myboke.system.commen;

import com.byk.myboke.boke.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 18:11
 * @Todo:
 */

public class MailUtil {

    /**
     * @Author: bianyakun
     * @Date: 2018/6/13 18:07
     * @todo: 邮件样式
     * @param:   * @param null
     */
    private static String content = "<!DOCTYPE html>"
            + "<html>"
            + "<head>"
            + "<title>测试邮件2</title>"
            + "<meta name=\"content-type\" content=\"text/html; charset=UTF-8\">"
            + "</head>"
            + "<body>"
            + "<p style=\"color:#0FF\">这是一封测试邮件~</p>"
            + "</body>"
            + "</html>"; // 可以用HTMl语言写

    @Autowired
    private JavaMailSender mail;



    /**
     * @Author: bianyakun
     * @Date: 2018/6/13 18:02
     * @todo: 发送邮件
     * @param:   * @param null
     */
    public   void sendEmail(Message message1) {
        try {
            MimeMessage mimeMessage = this.mail.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            //设置发信人，发信人需要和spring.mail.username配置的一样否则报错
            message.setFrom("ykian@qq.com");
            //设置收信人
            message.setTo("ykbian@qq.com");
            //设置主题
            message.setSubject(message1.getSubject());
            //第二个参数true表示使用HTML语言来编写邮件
            message.setText(content,true);
            this.mail.send(mimeMessage);
            //return "sucesss";
        } catch (Exception ex) {
            ex.printStackTrace();
            //return "error";
        }
    }
}
