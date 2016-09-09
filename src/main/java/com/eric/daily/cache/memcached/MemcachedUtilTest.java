package com.eric.daily.cache.memcached;

import com.danga.MemCached.MemCachedClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * description:
 * author:Eric
 * Date:16/7/26
 * Time:10:18
 * version 1.0.0
 */
public class MemcachedUtilTest {

    private MemCachedClient cachedClient;

    @Before
    public void init(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:*spring/memcached.xml");
        cachedClient = (MemCachedClient) context.getBean("memcachedClient");
    }

    @Test
    @Ignore
    public void testMemcached() {

        MemcachedUtil.put("hello", "world", 60);
        String hello = (String) MemcachedUtil.get("hello");
        Assert.assertEquals("world", hello);

        for(int i = 0; i < 10000; ++i) {
            UserBean userBean = new UserBean("Jason" + i, "123456-" + i);
            MemcachedUtil.put("user" + i, userBean, 60);
            Object obj = MemcachedUtil.get("user" + i);
            Assert.assertEquals(userBean, obj);
        }
    }

    @Test
    public void  testMemcachedSpring(){
        UserBean user = new UserBean("ericOne","打豆豆");
        cachedClient.set("userOne",user,new Date(new Date().getTime()+5000));
        UserBean cachedBean = (UserBean)cachedClient.get("userOne");
        Assert.assertEquals(user, cachedBean);
    }





}
