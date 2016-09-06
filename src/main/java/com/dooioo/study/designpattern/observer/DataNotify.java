package com.dooioo.study.designpattern.observer;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:11:25
 * version 1.0.0
 */
public class DataNotify {

    public static void notifyDataChanged(){
        DataBean bean = new DataBean();
        bean.temperature = (int) (Math.random()*40);
        DataObservable.getInstance().notifyDataChanged(bean);
    }

}
