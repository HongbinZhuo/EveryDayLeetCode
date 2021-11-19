package com.JUC2.secondStudy;

public class NotificationDemo {

    private volatile boolean go = false;

    public static void main(String[] args) throws InterruptedException {
        final NotificationDemo test = new NotificationDemo();
        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                try {
                    test.shouldGo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished Execution");
            }
        };

        Runnable notifyTask = new Runnable() {
            @Override
            public void run() {
                test.go();
                System.out.println(Thread.currentThread().getName() + " finished Execution");
            }
        };

        Thread t1 = new Thread(waitTask, "WT1"); // will wait
        Thread t2 = new Thread(waitTask, "WT2"); // will wait
        Thread t3 = new Thread(waitTask, "WT3"); // will wait
        Thread t4 = new Thread(notifyTask, "NT1"); // will notify

        // starting all waiting thread
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(2000);

        t4.start();
    }

    private synchronized void shouldGo() throws InterruptedException {

        while (go != true) {
            System.out.println(Thread.currentThread() + " is going to wait on this object ");
            wait();
            System.out.println(Thread.currentThread() + " is woken up");
        }
        go = false;
    }

    private synchronized void go() {
        while (go == false) {
            System.out.println(Thread.currentThread() + "is going to notify all or one thread wating on thread");
            go = true;
//            notify();
            notifyAll();
        }
    }
}
