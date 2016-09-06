package com.dooioo.study.executor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;



/**
 * description:Callable接口测试
 * author:yangkang
 * Date:16/6/10
 * Time:13:50
 * version 1.0.0
 */
public class CallableExample {

    /**
     * 定义实现Callable接口的内部类
     */
    static class StringLengthCallable implements Callable {

        private String word;

        public StringLengthCallable(String word) {
            this.word = word;
        }

        /**
         * 实现Callable接口的call方法 返回字符串的长度
         * @return
         */
        public Integer call() {
            return Integer.valueOf(word.length());
        }
    }

    public static void main(String args[]) throws Exception {

        //创建固定线程池大小的执行器服务 Executors工具类
        ExecutorService pool = Executors.newFixedThreadPool(3);

        List<String> testString = new ArrayList<String>();
        testString.add("ABC");
        testString.add("ABCD");
        testString.add("ABCDE");

        Set<Future<Integer>> set = new HashSet<Future<Integer>>();

        for (String word: testString) {
            Callable<Integer> callable = new StringLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }

        int sum = 0;
        for (Future<Integer> future : set) {
            //对Future的get方法的调用会阻塞当前线程并等待任务结束，而不会阻塞其它的任务和线程。
            sum += future.get();
        }

        System.out.println("字符总长度为:"+sum);
    }
}
