package com.dooioo.study.executor;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * description:Executor框架提供服务接口
 * author:yangkang
 * Date:16/6/10
 * Time:13:16
 * version 1.0.0
 */
public interface ExecutorService extends Executor {

    /**
     * 启动一个关闭命令，不再接受新任务，当所有已提交任务执行完后，就关闭
     */
    void shutdown();

    /**
     * 尝试停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表
     * @return 从未开始执行的任务的列表
     */
    List<Runnable> shutdownNow();


    /**
     * 判断执行器是否已经关闭
     * @return 如果此执行程序已关闭，则返回true
     */
    boolean isShutdown();

    /**
     * 关闭后所有任务是否都已完成 需要首先调用shutdown 或 shutdownNow，否则isTerminated永不为true
     * @return 如果关闭后所有任务都已完成，则返回true
     */
    boolean isTerminated();


    /**
     * 等待（阻塞）直到关闭或最长等待时间或发生中断
     * @param timeout 最长等待时间
     * @param unit 参数的时间单位
     * @return 如果此执行程序终止，则返回true；如果终止前超时期满，则返回false
     * @throws InterruptedException
     */
    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;


    /**
     * 提交一个可返回值的任务用于执行
     * @param task
     * @param <T>
     * @return
     */
    <T> Future<T> submit(Callable<T> task);

    /**
     * 提交一个Runnable任务用于执行，并返回一个表示该任务的Future 使用该Future的get方法在成功完成时将会返回给定的结果
     * @param task
     * @param result
     * @param <T>
     * @return
     */
    <T> Future<T> submit(Runnable task, T result);

    /**
     * 提交一个Runnable任务用于执行，并返回一个表示该任务的Future 使用该Future的get方法在成功完成时将会返回null
     * @param task
     * @return
     */
    Future<?> submit(Runnable task);

    /**
     * 执行给定的任务，当所有任务完成时，返回保持任务状态和结果的Future列表
     * @param tasks
     * @param <T>
     * @return 表示任务的Future列表,每个任务都已完成  该方法会一直阻塞直到所有任务完成
     * @throws InterruptedException
     */
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException;

    /**
     * 执行给定的任务，当所有任务完成或超时期满时，返回保持任务状态和结果的Future列表
     * @param tasks
     * @param timeout
     * @param unit
     * @param <T>
     * @return 任务的Future列表  如果未超时，则已完成所有任务。如果超时了，则某些任务尚未完成   该方法会一直阻塞直到所有任务完成或超时
     * @throws InterruptedException
     */
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException;


    /**
     * 执行给定的任务，如果某个任务已成功完成（也就是未抛出异常），则返回其结果。一旦正常或异常返回后，则取消尚未完成的任务。
     * @param tasks
     * @param <T>
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * 注意1：该方法会一直阻塞直到有一个任务完成。
     * 注意2：一旦正常或异常返回后，则取消尚未完成的任务
     */
    <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException;


    /**
     * 执行给定的任务，如果在给定的超时期满前某个任务已成功完成（也就是未抛出异常），则返回其结果。一旦正常或异常返回后，则取消尚未完成的任务。
     * @param tasks
     * @param timeout
     * @param unit
     * @param <T>
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     * 注意1：该方法会一直阻塞直到有一个任务完成。
     * 注意2:一旦正常或异常返回后，则取消尚未完成的任务
     */
    <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;

}
