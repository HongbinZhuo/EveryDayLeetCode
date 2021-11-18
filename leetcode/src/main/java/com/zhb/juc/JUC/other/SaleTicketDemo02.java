package com.zhb.juc.JUC.other;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 14:25
 */
// LOCK锁
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        //多线程操作
        //并发：多线程操作同一个资源类，把资源类丢入线程
        Ticket2 ticket = new Ticket2();
        new Thread(()->{ for(int i=0;i<40;i++) ticket.sale(); },"A").start();
        new Thread(()->{ for(int i=0;i<40;i++) ticket.sale(); },"B").start();
        new Thread(()->{ for(int i=0;i<40;i++) ticket.sale(); },"C").start();

    }
}

//lock三部曲
//1、    Lock lock=new ReentrantLock();
//2、    lock.lock() 加锁
//3、    finally=> 解锁：lock.unlock();
class Ticket2{
    private int number=50;
//1.
    Lock lock=new ReentrantLock(false);

    //卖票的方式
    // 使用Lock 锁
    public void sale(){
        // 2. 加锁
        lock.lock();
        try {
            //业务代码
            if(number>0){
                System.out.println(Thread.currentThread().getName()+" 卖出了第"+number+" 张票,剩余："+(number-1)+" 张票");
                number--;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // 3. 解锁
            lock.unlock();
        }
    }
}