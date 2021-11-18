package com.zhb.juc.JUC.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 15:05
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        //并不是顺序执行！
        // 是因为synchronized 锁的对象是方法的调用！
        // 对于两个方法用的是同一个锁，谁先拿到谁先执行！另外一个则等待！
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();

    }
    static class Phone{
        public  synchronized  void sendSms(){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("发短信");
        }
        public  synchronized  void call(){
            System.out.println("打电话");
        }
    }

}

