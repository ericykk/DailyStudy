package com.dooioo.study.mail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.*;

/**
 * description:邮件工具类
 * author:yangkang
 * Date:16/8/12
 * Time:11:40
 * version 1.0.0
 */
public class MailUtil {

    /**
     * 发送邮件
     */
    public static void sendMail(Mail mail){

        Session session=null;
        Properties props = System.getProperties();
        props.put("mail.smtp.host", mail.getSmtpServer());
        if(mail.getIsAuth()){
            //服务器需要身份认证
            props.put("mail.smtp.auth","true");
            SmtpAuth smtpAuth=new SmtpAuth(mail.getUserName(),mail.getPassword());
            session=Session.getDefaultInstance(props, smtpAuth);
        }else{
            props.put("mail.smtp.auth","false");
            session=Session.getDefaultInstance(props, null);
        }
        session.setDebug(true);
        Transport trans = null;
        try {
            Message msg = new MimeMessage(session);
            try{
                Address from_address = new InternetAddress(mail.getSendFrom(), mail.getDisplayName());
                msg.setFrom(from_address);
            }catch(Exception e){
                e.printStackTrace();
            }
            InternetAddress[] address={new InternetAddress(mail.getSendTo())};
            msg.setRecipients(Message.RecipientType.TO,address);
            msg.setSubject(mail.getSubject());
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setContent(mail.getContent(), "text/html;charset=gb2312");
            mp.addBodyPart(mbp);
            Vector file = mail.getFile();
            if(!file.isEmpty()){//有附件
                Enumeration efile=file.elements();
                while(efile.hasMoreElements()){
                    mbp= new MimeBodyPart();
                    String filename=efile.nextElement().toString(); //选择出每一个附件名
                    FileDataSource fds=new FileDataSource(filename); //得到数据源
                    mbp.setDataHandler(new DataHandler(fds)); //得到附件本身并至入BodyPart
                    mbp.setFileName(fds.getName());  //得到文件名同样至入BodyPart
                    mp.addBodyPart(mbp);
                }
                file.removeAllElements();
            }
            msg.setContent(mp); //Multipart加入到信件
            msg.setSentDate(new Date()); //设置信件头的发送日期
            //发送信件
            msg.saveChanges();
            trans = session.getTransport("smtp");
            trans.connect(mail.getSmtpServer(), mail.getUserName(), mail.getPassword());
            trans.sendMessage(msg, msg.getAllRecipients());
            trans.close();

        }catch(AuthenticationFailedException e){
            e.printStackTrace();
        }catch (MessagingException e) {
            e.printStackTrace();
            Exception ex = null;
            if ((ex = e.getNextException()) != null) {
                ex.printStackTrace();
            }
        }
    }
}
