package com.eric.daily.cache.redis.service;

import com.eric.daily.cache.redis.dao.UserDao;
import com.eric.daily.cache.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 * author:Eric
 * Date:16/9/22
 * Time:13:57
 * version 1.0.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     *
     * @param userName
     * @return
     */
    public User getUser(String userName){
        return userDao.getUser(userName);
    }
}
