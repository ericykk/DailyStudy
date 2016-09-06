package com.dooioo.study.designpattern.observer;

import java.util.Observable;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:11:12
 * version 1.0.0
 */
public class DataObservable extends Observable {

    private static volatile  DataObservable instance;

    private DataObservable(){

    }

    public static DataObservable getInstance(){
        if(instance == null){
            synchronized (DataObservable.class){
                if(instance == null){
                    instance = new DataObservable();
                }
            }
        }
        return instance;
    }

    public void notifyDataChanged(DataBean data){
        setChanged();
        notifyObservers(data);
    }

}
