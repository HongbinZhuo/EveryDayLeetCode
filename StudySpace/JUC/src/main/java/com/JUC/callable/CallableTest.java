package com.JUC.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 16:21
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 1; i < 10; i++) {
//            new Thread(new Runnable()).start();
//            new Thread(new FutureTask<>( Callable)).start();
            MyThread thread= new MyThread();
            //适配类：FutureTask
            FutureTask<String> futureTask = new FutureTask<>(thread);
            //放入Thread使用
            new Thread(futureTask,String.valueOf(i)).start();  //结果会被缓存
            //获取返回值
            String s = futureTask.get();
            //get可能会产生阻塞   放最后 或者使用异步通信

            System.out.println("返回值："+ s);
        }
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Call:"+Thread.currentThread().getName());
        return "String"+Thread.currentThread().getName();
    }
}
