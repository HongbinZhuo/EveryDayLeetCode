package com.zhb.juc.JUC.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 20:24
 */
public class Demo01 {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
        ExecutorService threadPool2 = Executors.newFixedThreadPool(5); //创建一个固定的线程池的大小
        ExecutorService threadPool3 = Executors.newCachedThreadPool(); //可伸缩的

        //线程池用完必须要关闭线程池
        try {

            for (int i = 1; i <=100 ; i++) {
                //通过线程池创建线程
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread().getName()+ " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }


}
