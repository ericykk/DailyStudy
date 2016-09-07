package com.eric.study.memcached;

/**
 * description:
 * author:yangkang
 * Date:16/7/26
 * Time:16:33
 * version 1.0.0
 */
public class TestMemcached {

    public static void main(String [] args){
        UserBean user = (UserBean) MemcachedUtil.get("userOne");
        if(user !=  null){
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        }else {
            System.out.println("memacached缓存已经失效!");
        }

    }
}
