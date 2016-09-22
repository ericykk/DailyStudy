package com.eric.daily.cache.redis.dao;

import com.eric.daily.cache.redis.model.User;
import org.springframework.stereotype.Repository;


/**
 * description:
 * author:Eric
 * Date:16/9/22
 * Time:13:45
 * version 1.0.0
 */
@Repository
public interface UserDao {
    public User getUser(String userName);
}
