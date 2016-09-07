package com.eric.study.designpattern.single;

/**
 * description:使用枚举来实现单例
 * author:Eric
 * Date:16/9/6
 * Time:16:14
 * version 1.0.0
 */
public enum EnumSingleton {

    /**
     * 定义一个枚举的元素，它就代表了Singleton的一个实例。
     */
    singleInstance;


    /**
     * 枚举拥有自己的操作
     */
    public void singleAction(){
        System.out.println("枚举实现单例模式!");
    }
}
