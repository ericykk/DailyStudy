package com.dooioo.study.designpattern.observer;

import org.apache.commons.logging.Log;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

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
