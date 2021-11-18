package com.zhb.juc.JUC2.secondStudy;

// 资源类
class Resource {
    private int breadCount = 0;       // 资源编号
    private boolean flag = false;  // 资源类增加一个资源标志位，判断是否有资源

    // 生产资源
    public void produce() {
        synchronized (this) {
            // 添加循环判断，如果flag为true，也就是有资源了，生产者线程就暂停生产，进入冻结状态，等待唤醒。
            while (flag == true) {
                try {
                    this.wait();  // wait函数抛出的异常只能被截获
                    // 因为wait会让该线程等在这里，如果这里使用if判断，则当线程被唤醒后会直接往下执行，
                    // 不再进行flag判断了，则由于错误标记执行，这就可能造成多线程死锁。
                    //所以使用while循环判断，让线程再次判断是否标记正确
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //当可以生产的时候flag=false时，执行以下

            breadCount++;    // 资源编号递增，用来模拟资源递增
            System.out.println(Thread.currentThread().getName() + "...生产者生产bread.." + breadCount);
            //生产完成修改flag
            flag = true;
            //并唤醒其他所有线程，如果只唤醒一个，则可能唤醒一个同类线程，而我们要唤醒的是对方线程
            this.notifyAll();
        }
    }

    // 消费资源
    public void consume() {
        synchronized (this) {
            //判断如果没有资源则消费者等待
            while (flag == false) {
                try {
                    this.wait();  // wait函数抛出的异常只能被截获
                    // 因为wait会让该线程等在这里，如果这里使用if判断，则当线程被唤醒后会直接往下执行，
                    // 不再进行flag判断了，则由于错误标记执行，这就可能造成多线程死锁。
                    //所以使用while循环判断，让线程再次判断是否标记正确
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "...消费者消费bread......." + breadCount);
            //生产完成修改flag
//            flag = false;
            //并唤醒其他所有线程，如果只唤醒一个，则可能唤醒一个同类线程，而我们要唤醒的是对方线程
//            this.notifyAll();
        }
    }
}

// 生产者类线程
class Producer implements Runnable {
    private Resource res;

    //构造函数中生产者初始化分配资源
    public Producer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            res.produce();     // 每个线程生产5个
        }
    }

}

// 消费者类线程
class Comsumer implements Runnable {
    private Resource res;

    //构造函数中消费者一初始化也要分配资源
    public Comsumer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            res.consume();  // 每个线程消费5个
        }
    }
}

public class SynchronizedSample {
    public static void main(String[] args) {
        Resource resource = new Resource();  // 实例化资源

        Thread threadProducer = new Thread(new Producer(resource)); // 创建2个生产者线程
//        Thread threadProducer2 = new Thread(new Producer(resource)); // 创建2个生产者线程
        Thread threadComsumer = new Thread(new Comsumer(resource)); // 创建2个消费者线程
        Thread threadComsumer2 = new Thread(new Comsumer(resource)); // 创建2个消费者线程

        // 分别开启线程
        threadProducer.start();
//        threadProducer2.start();
        threadComsumer.start();
        threadComsumer2.start();
    }
}
/*
Thread-0...生产者生产bread..1
Thread-2...消费者消费bread.......1
Thread-1...生产者生产bread..2
Thread-3...消费者消费bread.......2
Thread-0...生产者生产bread..3
Thread-2...消费者消费bread.......3
Thread-1...生产者生产bread..4
Thread-3...消费者消费bread.......4
Thread-0...生产者生产bread..5
Thread-2...消费者消费bread.......5
Thread-1...生产者生产bread..6
Thread-3...消费者消费bread.......6
Thread-0...生产者生产bread..7
Thread-2...消费者消费bread.......7
Thread-1...生产者生产bread..8
Thread-2...消费者消费bread.......8
Thread-0...生产者生产bread..9
Thread-3...消费者消费bread.......9
Thread-1...生产者生产bread..10
Thread-3...消费者消费bread.......10
 */
