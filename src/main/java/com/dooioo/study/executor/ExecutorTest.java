package com.dooioo.study.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * description:
 * author:yangkang
 * Date:16/6/11
 * Time:18:21
 * version 1.0.0
 */
public class ExecutorTest {

    public static void main(String [] args){

        Executor executor = Executors.newFixedThreadPool(40);
        executor.execute(new TaskA());
        executor.execute(new TaskB());
    }

    static class  TaskA implements Runnable{
        public void run() {
            System.out.println("开始执行任务A");
        }
    }

    static class  TaskB implements Runnable{
        public void run() {
            System.out.println("开始执行任务B");
        }
    }


}
