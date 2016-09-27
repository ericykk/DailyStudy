package com.eric.daily.cache.redis.service;

import com.eric.daily.cache.redis.repository.RedisDataSourceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

/**
 * description:分布式redis客户端
 * author:Eric
 * Date:16/9/23
 * Time:18:20
 * version 1.0.0
 */
@Service
public class RedisDistributedService {

    private Logger logger = LogManager.getLogger(RedisDistributedService.class);

    @Autowired
    private RedisDataSourceService redisDataSourceService;


    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    public String set(String key,String value){
        String result = null;
        ShardedJedis shardedJedis = redisDataSourceService.getRedisClient();
        if(shardedJedis != null){
            try{
                result = shardedJedis.set(key, value);
            }catch (Exception e){
                logger.error("set operation fail",e);
            }finally {
                shardedJedis.close();
            }
        }
        return result;
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public String get(String key){
        String result = null;
        ShardedJedis shardedJedis = redisDataSourceService.getRedisClient();
        if(shardedJedis != null){
            try{
                result = shardedJedis.get(key);
            }catch (Exception e){
                logger.error("get value fail",e);
            }finally {
                shardedJedis.close();
            }
        }
        return result;
    }

}
