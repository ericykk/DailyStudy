package com.eric.study.memory;

import java.util.Date;

/**
 * description:
 * volatile的特性
 * 可见性。对一个volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入。
 * 原子性：对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不具有原子性
 *
 * author:yangkang
 * Date:16/5/20
 * Time:10:46
 * version 1.0.0
 */
public class VolatileStudy {

    //使用volatile声明64位的long型变量
    volatile long vl = 0L;


    //单个volatile变量的写
    public void set(long value) {
        vl = value;
    }

    //复合（多个）volatile变量的读/写
    public void getAndIncrement () {
        vl++;
    }

    //单个volatile变量的读
    public long get() {
        return vl;
    }


    //负责修改volatile变量的值
    static class OneVolatile extends Thread{

        private VolatileStudy volatileStudy;

        public OneVolatile(VolatileStudy volatileStudy){
            this.volatileStudy = volatileStudy;
        }

        @Override
        public void run() {
            volatileStudy.set((long) (Math.random() * 1000) +1);
            System.out.println(new Date()+"FirstVolatile中vl值:"+volatileStudy.vl);
        }

    }


    static class TwoVolatile extends Thread{

        private VolatileStudy volatileStudy;

        public TwoVolatile(VolatileStudy volatileStudy){
            this.volatileStudy = volatileStudy;
        }

        @Override
        public void run() {
            volatileStudy.getAndIncrement();
            System.out.println(new Date()+"TwoVolatile中vl值:"+volatileStudy.vl);
        }

    }


    //负责读取volatile变量的值
    static class ThreeVolatile extends Thread{

        private VolatileStudy volatileStudy;

        public ThreeVolatile(VolatileStudy volatileStudy){
            this.volatileStudy = volatileStudy;
        }

        @Override
        public void run() {
            System.out.println(new Date()+"ThreeVolatile中vl值:"+volatileStudy.get()+"     ############");
        }

    }


    public static void main(String args[]){

        VolatileStudy volatileStudy =  new VolatileStudy();

        for(int i=0;i<50;i++){

            OneVolatile one = new OneVolatile(volatileStudy);
            TwoVolatile two =  new TwoVolatile(volatileStudy);
            ThreeVolatile three = new ThreeVolatile(volatileStudy);

            one.start();
            two.start();
            three.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
