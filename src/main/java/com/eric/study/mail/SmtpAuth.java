package com.eric.study.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * description:
 * author:yangkang
 * Date:16/8/12
 * Time:11:26
 * version 1.0.0
 */
public class SmtpAuth extends Authenticator {

    private String username;
    private String password;

    public SmtpAuth(String username,String password){
        this.username = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new javax.mail.PasswordAuthentication(username,password);
    }
}
