package com.zhb.juc.JUC.feature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 21:31
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        // 发起 一个 请求

        System.out.println(System.currentTimeMillis());
        System.out.println("---------------------");
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            //发起一个异步任务
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+".....");
        });
        System.out.println(System.currentTimeMillis());
        System.out.println("------------------------------");
        //输出执行结果
        System.out.println(future.get());  //获取执行结果
    }
}
