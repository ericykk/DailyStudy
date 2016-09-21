package com.eric.daily.cache.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * description:redis服务
 * author:Eric
 * Date:16/9/21
 * Time:11:36
 * version 1.0.0
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    public String redisCache(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("index","Hello World!");
        return jedis.get("index");
    }

}
