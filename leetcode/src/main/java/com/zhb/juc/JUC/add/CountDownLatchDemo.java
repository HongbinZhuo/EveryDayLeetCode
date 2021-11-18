package com.zhb.juc.JUC.add;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 16:33
 */
//计数器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6 倒计时
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" Go out");
                countDownLatch.countDown(); //每个线程都数量-1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();  //等待计数器归零  然后向下执行

        System.out.println("close door");

    }

}
