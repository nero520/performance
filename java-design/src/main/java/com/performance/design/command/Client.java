package com.performance.design.command;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xiaoxiong
 */
public class Client {

    public static void main(String[] args) {
        // 创建一个执行任务的服务
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            //1.Runnable通过Future返回结果为空
            //创建一个Runnable，来调度，等待任务执行完毕，取得返回结果
            Future<?> runnable1 = executor.submit(new Runnable() {
                public void run() {
                    System.out.println("runnable1 running.");
                }
            });
            System.out.println("Runnable1:" + runnable1.get());

            // 2.Callable通过Future能返回结果
            //提交并执行任务，任务启动时返回了一个 Future对象，
            // 如果想得到任务执行的结果或者是异常可对这个Future对象进行操作
            Future<String> future1 = executor.submit(new Callable<String>() {
                public String call() throws Exception {
                    return "result=task1";
                }
            });
            // 获得任务的结果，如果调用get方法，当前线程会等待任务执行完毕后才往下执行
            System.out.println("task1: " + future1.get());

            //3. 对Callable调用cancel可以对对该任务进行中断
            //提交并执行任务，任务启动时返回了一个 Future对象，
            // 如果想得到任务执行的结果或者是异常可对这个Future对象进行操作
            Future<String> future2 = executor.submit(new Callable<String>() {
                public String call() throws Exception {
                    try {
                        while (true) {
                            System.out.println("task2 running.");
                            Thread.sleep(50);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted task2.");
                    }
                    return "task2=false";
                }
            });

            // 等待5秒后，再停止第二个任务。因为第二个任务进行的是无限循环
            Thread.sleep(10);
            System.out.println("task2 cancel: " + future2.cancel(true));

            // 4.用Callable时抛出异常则Future什么也取不到了
            // 获取第三个任务的输出，因为执行第三个任务会引起异常
            // 所以下面的语句将引起异常的抛出
            Future<String> future3 = executor.submit(new Callable<String>() {
                public String call() throws Exception {
                    throw new Exception("task3 throw exception!");
                }

            });
            System.out.println("task3: " + future3.get());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        // 停止任务执行服务
        executor.shutdownNow();
    }
}

