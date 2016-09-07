package com.eric.study.designpattern.single;

/**
 * description: 双重检查锁实现线程安全单例
 * author:Eric
 * Date:16/8/19
 * Time:10:08
 * version 1.0.0
 */
public class DoubleCheckSingleton {

    // volatile 关键字会屏蔽虚拟机必要的代码优化 可能影响性能
    private static volatile DoubleCheckSingleton singleton = null;

    private DoubleCheckSingleton(){
    }

    /**
     * 获取单例
     * 实例为空的时候才会执行同步
     * 最多执行一次同步代码 节约了资源
     * @return
     */
    public static DoubleCheckSingleton getInstance(){
            if(singleton == null){
                synchronized (DoubleCheckSingleton.class){
                    if(singleton == null){
                        singleton = new DoubleCheckSingleton();
                    }
                }
            }
        return singleton;
    }
}
