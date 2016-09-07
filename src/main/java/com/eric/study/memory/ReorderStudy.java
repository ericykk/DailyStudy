package com.eric.study.memory;

import java.util.concurrent.*;

/**
 * description:重排序
 * author:yangkang
 * Date:16/5/24
 * Time:10:50
 * version 1.0.0
 */
public class ReorderStudy {

    private int a = 0;

    private int b = 0;


    public void doTest() throws InterruptedException, ExecutionException {

        //设置特定的线程池，大小为2
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //可能出现的结果（关注ThreadATask，ThreadBTask取到的结果）
        int num00 = 0; //x=0，y=0
        int num10 = 0; //x=1，y=0
        int num02 = 0; //x=0，y=2
        int num12 = 0; //x=1，y=2

        int allNum = 100000;

        for (int i = 0; i < allNum; i++) {

            //CountDownLatch类是辅助类,构造时传入int参数,该参数就是计数器的初始值，每调用一次countDown()方法，计数器减1,计数器大于0 时，await()方法会阻塞程序继续执行
            CountDownLatch latch = new CountDownLatch(1);
            Future futureA = executor.submit(new A(latch));
            Future futureB = executor.submit(new B(latch));
            latch.countDown();

            int x = (Integer) futureB.get(); //取得a
            int y = (Integer) futureA.get(); //取得b

            if (x==0 && y==0) {num00++;}
            if (x==1 && y==0) {num10++;}
            if (x==0 && y==2) {num02++;}
            if (x==1 && y==2) {num12++;}

            //重置状态
            a = 0;
            b = 0;
        }

        System.out.println("");
        System.out.println("x=0，y=0出现次数：" + num00);
        System.out.println("x=1，y=0出现次数：" + num10);
        System.out.println("x=0，y=2出现次数：" + num02);
        System.out.println("x=1，y=2出现次数：" + num12);

        executor.shutdown();
    }

    //Callable 类似Runnable接口 但是Runnable不会返回结果,并且无法抛出返回结果的异常
    //Callable 可以返回值，这个返回值可以被Future拿到
    private class A implements Callable {

        private CountDownLatch barrier;

        public A(CountDownLatch barrier) {
            this.barrier = barrier;
        }

        public Integer call() throws InterruptedException,
                BrokenBarrierException {
            //计数器大于0时 await()方法会阻塞程序继续执行
            barrier.await();

            a = 1; // A1
            return b; // A2
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

            b = 2; // B1
            return a; // B2
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ReorderStudy rt = new ReorderStudy();
        rt.doTest();
    }
}
