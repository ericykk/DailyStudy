package com.eric.daily.cache.redis.model;

import java.io.Serializable;

/**
 * description:
 * author:Eric
 * Date:16/9/22
 * Time:13:34
 * version 1.0.0
 */
public class User implements Serializable{

    private int id;
    private String userName;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
