package com.dooioo.study.queue;

import java.util.concurrent.*;

/**
 * description:
 * author:yangkang
 * Date:16/6/17
 * Time:14:43
 * version 1.0.0
 */
public class BlockingQueueTest {

    public static void main(String [] args){

        BlockingQueue<String> queue =  new LinkedBlockingDeque<String>(10);

        Producer one =  new Producer(queue);
        Producer two =  new Producer(queue);
        Producer three =  new Producer(queue);
        Consumer consumer =  new Consumer(queue);


        try {

            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(one);
            executorService.execute(two);
            executorService.execute(three);
            executorService.execute(consumer);

            Thread.sleep(10000);

            one.stop();
            two.stop();
            three.stop();

            Thread.sleep(2000);

            executorService.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
