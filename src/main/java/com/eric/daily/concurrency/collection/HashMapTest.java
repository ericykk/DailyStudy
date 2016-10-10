package com.eric.daily.concurrency.collection;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description:模拟HashMap在多线程环境下死循环现象
 * author:Eric
 * Date:16/10/9
 * Time:18:15
 * version 1.0.0
 */
public class HashMapTest {

    private static HashMap<String,String> testMap = new HashMap<>();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        testMap.put(UUID.randomUUID().toString(),"");
                    }
                    System.out.println(Thread.currentThread().getName()+"执行完毕!");
                }
            });
        }
    }
}