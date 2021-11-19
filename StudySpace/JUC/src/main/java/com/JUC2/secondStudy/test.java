package com.JUC2.secondStudy;

import org.junit.jupiter.api.Test;

public class test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {});
        thread.start(); // 第一次调用
//        thread.start(); // 第二次调用
        blockedTest();
    }


    @Test
    public static  void blockedTest() throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
                System.out.println('a');
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
                System.out.println('b');
            }
        }, "b");

        a.start();
        Thread.interrupted();
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private static synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
