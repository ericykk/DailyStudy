package com.eric.daily.cache.redis.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * description:单个redis服务
 * author:Eric
 * Date:16/9/21
 * Time:15:54
 * version 1.0.0
 */
@Service
public class RedisCacheService {

    private Logger logger = LogManager.getLogger(RedisCacheService.class);

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 批量删除key
     * @param keys
     */
    public void remove(final String ... keys){
        for (String key:keys) {
            remove(key);
        }
    }

    /**
     * 删除对应的key的值
     * @param key
     */
    public void remove(final String key){
        if(redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否存在对应的value
     * @param key
     * @return
     */
    public boolean hasKey(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key){
        Object value = null;
        ValueOperations operations = redisTemplate.opsForValue();
        value = operations.get(key);
        return value;
    }


    /**
     * 设置缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key,Object value){

        boolean isSuccess = false;
        try{
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(key,value);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("设置缓存失败",e);
        }

        return isSuccess;

    }

    /**
     * 设置缓存
     * @param key
     * @param value
     * @param expireTime 缓存时间
     * @return
     */
    public boolean set(final  String key,Object value,Long expireTime){

        boolean isSuccess = false;

        try{
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(key,value);
            //设置缓存时间
            redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

}
