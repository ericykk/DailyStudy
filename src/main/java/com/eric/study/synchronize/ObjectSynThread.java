package com.eric.study.synchronize;

/**
 * description:
 * author:yangkang
 * Date:16/8/10
 * Time:16:16
 * version 1.0.0
 */
public class ObjectSynThread extends Thread{
    private String lock;
    private String name;

    public ObjectSynThread(String lock,String name){
        this.lock = lock;
        this.name =name;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"is run***");
        }
    }


    public static void main(String[] args){
        //对象锁
       String lock = "lockTest";
        for(int i=0;i<10;i++){
            new ObjectSynThread(lock,"ThreadTest_"+i).start();
        }
    }
}
