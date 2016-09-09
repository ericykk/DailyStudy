package com.eric.daily.designpattern.single;

/**
 * description:懒汉线程安全单例
 * author:Eric
 * Date:16/9/6
 * Time:16:41
 * version 1.0.0
 */
public class LazySingleton {

    private static LazySingleton singleton = null;

    private LazySingleton(){

    }

    /**
     * 需要一直进行同步的操作
     * @return
     */
    public static synchronized  LazySingleton getInstance(){
        if(singleton == null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
