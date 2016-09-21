package com.eric.daily.redis;

import com.eric.daily.BaseTest;
import com.eric.daily.cache.redis.SendMessage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description:消息队列测试
 * author:Eric
 * Date:16/9/13
 * Time:09:53
 * version 1.0.0
 */
public class MessageQueueTest extends BaseTest{

    @Autowired
    private SendMessage sendMessage;


    @Test
    public void testSendMessage(){
        for (int i = 0; i < 10; i++) {
            try{
                sendMessage.sendMessage("sms_queue_web_online","处理完成第"+i+"消息");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
