package com.dooioo.study.memory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * description:锁内存语义的具体实现机制
 * author:yangkang
 * Date:16/5/23
 * Time:13:48
 * version 1.0.0
 */
public class ReentrantLockStudy {

    int a = 0;


    ReentrantLock lock = new ReentrantLock();


    public void writer() {

        //获取锁
        lock.lock();

        try {
            a++;
        } finally {
            //释放锁
            lock.unlock();
        }

    }


    public void reader () {
        //获取锁
        lock.lock();
        try {
            int i = a;
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
