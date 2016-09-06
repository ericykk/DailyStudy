package com.dooioo.study.spring;

/**
 * description:
 * author:yangkang
 * Date:16/6/30
 * Time:09:33
 * version 1.0.0
 */
public class UserServiceImpl implements IUserService {

    public void printUserName(String userName) {
        System.out.println("My name is " +userName);
    }
}
