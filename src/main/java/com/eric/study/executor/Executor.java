package com.eric.study.executor;

/**
 * description:Executor接口类
 * author:yangkang
 * Date:16/6/10
 * Time:13:11
 * version 1.0.0
 */
public interface Executor {
    /**
     * 执行单一的提交任务方法
     * @param command 需要执行的任务
     */
    void execute(Runnable command);
}
