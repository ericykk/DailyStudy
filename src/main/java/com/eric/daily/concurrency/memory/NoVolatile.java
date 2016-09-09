package com.eric.daily.concurrency.memory;

import java.util.concurrent.*;

/**
 * description:
 * author:Eric
 * Date:16/5/25
 * Time:14:07
 * version 1.0.0
 */
public class NoVolatile {

    int x = 0;

    volatile boolean v = false;


    public void test() throws InterruptedException, ExecutionException {

        //设置特定的线程池，大小为2
        ExecutorService executor = Executors.newFixedThreadPool(2);

        int allNum = 100000;
        int num00 = 0;
        int num42 = 0;
        for (int i = 0; i < allNum; i++) {

            //CountDownLatch类是辅助类,构造时传入int参数,该参数就是计数器的初始值，每调用一次countDown()方法，计数器减1,计数器大于0 时，await()方法会阻塞程序继续执行
            CountDownLatch latch = new CountDownLatch(1);
            Future futureA = executor.submit(new A(latch));
            Future futureB = executor.submit(new B(latch));
            latch.countDown();

            //取得y
            int y = (Integer) futureB.get();

            if(y==42){
                num42 ++;
            }
            if(y==0){
                num00++;
            }
            //重置状态
            x = 0;
            v = false;
        }

        System.out.println("num00:"+num00);
        System.out.println("num42:"+num42);

        executor.shutdown();

    }

    private class A implements Callable {

        private CountDownLatch barrier;

        public A(CountDownLatch barrier) {
            this.barrier = barrier;
        }

        public Integer call() throws InterruptedException,
                BrokenBarrierException {
            //计数器大于0时 await()方法会阻塞程序继续执行
            barrier.await();
            x = 42;
            v = true;
            return x;
        }
    }


    private class B implements Callable {

        private CountDownLatch barrier;

        public B(CountDownLatch barrier) {
            this.barrier = barrier;
        }

        public Integer call() throws InterruptedException,
                BrokenBarrierException {

            //计数器大于0时 await()方法会阻塞程序继续执行
            barrier.await();

            int y = 0;
            if (v) {
                y = x;
            }
            return y;
        }
    }

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        NoVolatile noVolatile =  new NoVolatile();
        noVolatile.test();
    }


}
