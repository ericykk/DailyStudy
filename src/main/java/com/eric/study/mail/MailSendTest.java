package com.eric.study.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * description:
 * author:yangkang
 * Date:16/8/12
 * Time:10:03
 * version 1.0.0
 */
public class MailSendTest {

    public static void main(String[] args) throws Exception {
        Mail mail = new Mail("smtp.163.com","eric_ykk@163.com","eric","eric_ykk@163.com","ericauth163com","363784482@qq.com","邮件测试","邮件发送成功了吗!");
        mail.addAttachFile("/Users/yangkang/Desktop/7月上传表.xlsx");
        MailUtil.sendMail(mail);
    }



    public static void sendMailTest(){
        try{
            Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.host", "smtp.163.com");

            Session session = Session.getInstance(props,
                    new Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication("eric_ykk@163.com","ericauth163com");
                        }
                    });
            session.setDebug(true);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("eric_ykk@163.com"));
            msg.setSubject("JavaMail测试程序");
            msg.setContent("<span style='color:red'>这是我的第一个javaMail测试程序</span>", "text/html;charset=UTF8");
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("363784482@qq.com"));
            Transport.send(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
