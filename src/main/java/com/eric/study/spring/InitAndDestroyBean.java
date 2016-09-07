package com.eric.study.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * description:模拟Bean初始化 Bean销毁 @PostConstruct  @PreDestroy 执行的顺序
 * author:Eric
 * Date:16/9/7
 * Time:11:32
 * version 1.0.0
 */
public class InitAndDestroyBean implements InitializingBean,DisposableBean{

    public InitAndDestroyBean() {
        System.out.println("执行InitAndDestroyBean的构造方法");
    }


    @PostConstruct
    public void postConstruct(){
        System.out.println("执行InitializingBean的postConstruct方法");
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("执行InitializingBean的preDestroy方法");
    }


    public void init(){
        System.out.println("执行InitializingBean的init方法");
    }

    public void destroyMethod(){
        System.out.println("执行InitializingBean的destroyMethod方法");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("执行InitializingBean的afterPropertiesSet方法");
    }


    public void destroy() throws Exception {
        System.out.println("执行InitializingBean的destroy方法");
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        applicationContext.close();
    }
}
