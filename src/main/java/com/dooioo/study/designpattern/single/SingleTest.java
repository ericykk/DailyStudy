package com.dooioo.study.designpattern.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:10:15
 * version 1.0.0
 */
public class SingleTest {

    public static void main(String []args){
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for(int i=0;i<20;i++){
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Single.getInstance().toString());
                }
            });
        }
    }

}
