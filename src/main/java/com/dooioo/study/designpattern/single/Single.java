package com.dooioo.study.designpattern.single;

/**
 * description:单例 懒汉 double_checked
 * author:yangkang
 * Date:16/8/19
 * Time:10:08
 * version 1.0.0
 */
public class Single {

    private static volatile Single single= null;
    private Single(){
    }

    public static Single getInstance(){
            if(single == null){
                synchronized (Single.class){
                    if(single == null){
                        single = new Single();
                    }
                }
            }
        return single;
    }
}
