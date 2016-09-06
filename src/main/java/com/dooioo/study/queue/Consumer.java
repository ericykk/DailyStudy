package com.dooioo.study.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * description:
 * author:yangkang
 * Date:16/6/17
 * Time:14:17
 * version 1.0.0
 */
public class Consumer implements Runnable{

    private BlockingQueue<String> queue;

    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    public void run(){


        System.out.println("启动消费者线程!");
        Random r = new Random();

        boolean isRunning = true;

        try{
            while(isRunning){

                System.out.println("正从队列获取数据....");
                String data = queue.poll(2, TimeUnit.SECONDS);

                if(data != null){
                    System.out.println("正在消费数据:"+data);
                    Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                }else {
                    isRunning = false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            System.out.println("退出消费者线程!");
        }
    }
}
