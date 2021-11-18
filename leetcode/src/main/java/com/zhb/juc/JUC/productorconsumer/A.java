package com.zhb.juc.JUC.productorconsumer;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 14:36
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{for(int i=0;i<11;i++) {
            try {
                data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"A").start();

        new Thread(()->{for(int i=0;i<11;i++) {
            try {
                data.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }},"B").start();
    }
}


class Data{
    //数字  资源类
    private int number = 0;

    //+1
    public synchronized void increment() throws InterruptedException {
        if(number!=0){
            //等待操作
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程 我+1完毕了
        this.notifyAll();
    }



    //-1
    public synchronized void decrement() throws InterruptedException {
        while (number==0){
            //等待操作
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程  我-1完毕了
        this.notifyAll();
    }

}
