package com.eric.daily.designpattern.observer;

import java.util.Random;

/**
 * description:
 * author:Eric
 * Date:16/8/19
 * Time:11:25
 * version 1.0.0
 */
public class DataNotify {

    public static void notifyDataChanged(){
        DataBean bean = new DataBean();
        bean.temperature = 10;
        DataObservable.getInstance().notifyDataChanged(bean);
    }

}
