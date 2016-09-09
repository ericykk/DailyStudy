package com.eric.daily.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:11:18
 * version 1.0.0
 */
public class DataObserver implements Observer{
    
    private static final  String TAG = "DataObserver";

    public void update(Observable observable, Object data) {
        if(observable instanceof DataObservable && data instanceof DataBean){
            System.out.println(((DataBean) data).temperature+"");
        }
    }
}
