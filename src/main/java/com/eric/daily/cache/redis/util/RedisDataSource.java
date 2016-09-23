package com.eric.daily.cache.redis.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * description:
 * author:Eric
 * Date:16/9/23
 * Time:18:20
 * version 1.0.0
 */
public class RedisDataSource {

    private Logger logger = LogManager.getLogger(RedisDataSource.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;


    /**
     * 获取redis服务
     * @return
     */
    public ShardedJedis getRedisClient(){
        ShardedJedis shardedJedis = null;
        try{
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("get RedisClient fail,the reason is" + e);
        }
        return shardedJedis;
    }
}
