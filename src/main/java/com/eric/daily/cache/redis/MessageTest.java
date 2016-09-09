package com.eric.daily.cache.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:测试redis发布订阅模式消息队列
 * author:Eric
 * Date:16/9/9
 * Time:16:07
 * version 1.0.0
 */
public class MessageTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        SendMessage sendMessage = (SendMessage) context.getBean("sendMessage");
        for (int i = 0; i < 100; i++) {
            try{
                sendMessage.sendMessage("sms_queue_web_online","处理完成第"+i+"消息");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
