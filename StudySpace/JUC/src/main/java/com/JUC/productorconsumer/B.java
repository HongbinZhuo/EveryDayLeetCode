package com.JUC.productorconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 14:46
 */
public class B {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(()->{for(int i=0;i<10;i++) {
            data.increment();
        }
        },"A").start();

        new Thread(()->{for(int i=0;i<10;i++) {
            data.decrement();
        }},"B").start();

        new Thread(()->{for(int i=0;i<10;i++) {
            data.increment();
        }
        },"C").start();

        new Thread(()->{for(int i=0;i<10;i++) {
            data.decrement();
        }
        },"D").start();
    }
}


class Data2{
    //数字  资源类
    private int number = 0;

    //lock锁
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //+1
    public void increment()  {

        lock.lock();
        try{

            //业务
            while (number!=0){
                //等待操作
                condition.await();//相当于wait（）
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知其他线程 我+1完毕了
            condition.signalAll();//相当于synchronize的notifyAll()
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //-1
    public void decrement()  {
        lock.lock();
        try{
            //业务
            while (number==0){
                //等待操作
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知其他线程 我+1完毕了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}