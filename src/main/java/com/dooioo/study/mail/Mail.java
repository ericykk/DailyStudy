package com.dooioo.study.mail;

import java.util.*;

/**
 * description:邮件信息类
 * author:yangkang
 * Date:16/8/12
 * Time:11:20
 * version 1.0.0
 */
public class Mail {

    //定义发件人、收件人、SMTP服务器、用户名、密码、主题、内容等
    private String displayName;
    private String sendTo;
    private String sendFrom;
    private String smtpServer;
    private String userName;
    private String password;
    private String subject;
    private String content;
    //服务器是否要身份认证
    private boolean isAuth;
    private String fileName;
    //用于保存发送附件的文件名的集合
    private Vector file = new Vector();


    /**
     * 该方法用于收集附件名
     */
    public void addAttachFile(String fileName){
        file.addElement(fileName);
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public void setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Vector getFile() {
        return file;
    }

    public void setFile(Vector file) {
        this.file = file;
    }

    public boolean getIsAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    public Mail(){

    }

    /**
     * 初始化SMTP服务器地址、发送者E-mail地址、用户名、密码、接收者、主题、内容
     */
    public Mail(String smtpServer,String sendFrom,String displayName,String userName,String password,String sendTo,String subject,String content){
        this.smtpServer=smtpServer;
        this.sendFrom=sendFrom;
        this.displayName=displayName;
        this.isAuth=true;
        this.userName=userName;
        this.password=password;
        this.sendTo=sendTo;
        this.subject=subject;
        this.content=content;
    }

    /**
     * 初始化SMTP服务器地址、发送者E-mail地址、接收者、主题、内容
     */
    public Mail(String smtpServer,String sendFrom,String displayName,String sendTo,String subject,String content){
        this.smtpServer=smtpServer;
        this.sendFrom=sendFrom;
        this.displayName=displayName;
        this.isAuth=false;
        this.sendTo=sendTo;
        this.subject=subject;
        this.content=content;
    }
}
