package com.eric.daily.designpattern.single;

/**
 * description:类级内部类实现线程安全单例
 * author:Eric
 * Date:16/9/6
 * Time:16:05
 * version 1.0.0
 */
public class InnerClassSingleton {

    public InnerClassSingleton(){}

    /**
     *类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     *没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static class Single{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static InnerClassSingleton single = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return  Single.single;
    }
}
