package com.eric.study.designpattern.proxy;

/**
 * description:动态代理具体目标类
 * author:Eric
 * Date:16/9/6
 * Time:17:08
 * version 1.0.0
 */
public class RealSubject implements Subject {

    public void doAction() {
        System.out.println("real doAction!");
    }
}
