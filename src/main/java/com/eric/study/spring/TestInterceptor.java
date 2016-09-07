package com.eric.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * description:
 * author:yangkang
 * Date:16/6/30
 * Time:09:49
 * version 1.0.0
 */
public class TestInterceptor {

    public static void  main(String args[]){

        ApplicationContext context =  new FileSystemXmlApplicationContext("classpath*:spring/applicationContext.xml");
        IUserService userService = (IUserService) context.getBean("userService");
        userService.printUserName("eric");


    }

}
