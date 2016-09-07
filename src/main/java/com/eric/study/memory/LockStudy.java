package com.eric.study.memory;

/**
 * description:锁同步机制的学习
 * author:yangkang
 * Date:16/5/23
 * Time:10:13
 * version 1.0.0
 */
public class LockStudy {

    //普通变量
    int a =1;

    //写入变量值
    public synchronized void writer() {     //1
        a++;                                //2
        System.out.println(a);              //3
    }                                       //4

    //读取变量值
    public synchronized void reader() {     //5
        int i = a;                          //6
        System.out.println(i);              //7
    }                                       //8


    static class A extends  Thread{

        private LockStudy lockStudy;

        public A(LockStudy lockStudy){
            this.lockStudy = lockStudy;
        }
        @Override
        public void run() {
            lockStudy.writer();
        }
    }

    static class B extends  Thread{

        private LockStudy lockStudy;

        public B(LockStudy lockStudy){
            this.lockStudy = lockStudy;
        }
        @Override
        public void run() {
            lockStudy.reader();
        }
    }


    public static void main(String args[]){

        //锁对象
        LockStudy lockStudy = new LockStudy();

        A a  = new A(lockStudy);
        B b  = new B(lockStudy);
        //线程A先执行writer()方法,随后线程B执行reader()方法 则 2 happens before 6
        a.start();
        b.start();

    }
}
