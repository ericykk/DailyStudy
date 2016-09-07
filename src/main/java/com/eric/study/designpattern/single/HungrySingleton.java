package com.eric.study.designpattern.single;

/**
 * description:饿汉单例模式 线程安全
 * author:Eric
 * Date:16/9/6
 * Time:16:25
 * version 1.0.0
 */
public class HungrySingleton {

    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return singleton;
    }
}
