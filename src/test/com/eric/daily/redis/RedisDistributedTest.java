package com.eric.daily.redis;

import com.eric.daily.BaseTest;
import com.eric.daily.cache.redis.service.RedisDistributedService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description:分布式redis设置
 * author:Eric
 * Date:16/9/26
 * Time:18:15
 * version 1.0.0
 */
public class RedisDistributedTest extends BaseTest {

    @Autowired
    private RedisDistributedService redisDistributedService;


    @Test
    public void testSetCache(){
        for(int i =0;i<20000;i++){
            redisDistributedService.set("daily"+i,"cache"+i);
        }
    }
}
