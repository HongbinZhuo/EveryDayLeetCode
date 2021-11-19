package com.JUC2.secondStudy;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.stream.IntStream;

public class Demo {
    public static class T1 extends Thread {
        private  Student obj;
        private  String jobName;

        public T1(Student obj,String jobName) {
            this.obj = obj;
            this.jobName=jobName;
        }

        @Override
    public void run() {
            synchronized(this.obj) {
                try {
                    // 线程休眠
                    System.out.println(this.jobName+"进入休眠");
                    this.obj.wait(10 * 1000);
                } catch (InterruptedException e) {
                }
                obj.name=jobName;
                try {
                    System.out.println(this.jobName+"业务开始");
                    this.obj.wait(10 * 1000);
                    System.out.println(this.jobName+"业务结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
//    public static class T2 extends Thread {
//        private  Student obj;
//        private  String jobName;
//
//        public T2(Student obj,String jobName) {
//            this.obj = obj;
//            this.jobName=jobName;
//        }
//
//        @Override
//        public void run() {
//            synchronized(this.obj) {
//                try {
//                    // 线程休眠
//                    System.out.println(this.jobName+"进入休眠");
//                    this.obj.wait(10 * 1000);
//                } catch (InterruptedException e) {
//                }
//            }
//            try {
//                System.out.println(this.jobName+"业务");
//                Thread.sleep(5000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        Student stu = new Student("小明");
        new T1(stu,"任务一").start();
       new T1(stu,"任务二").start();
       Thread.sleep(1000L);
        synchronized (stu) {
            try {   // 唤醒子线程
                System.out.println("唤醒");
                stu.notifyAll();
            } catch (Exception e) {
            }
        }
        Thread.sleep(30000L);
        System.out.println(stu.name);
    }

}
class Student{
    String name;

    public Student(String name) {
        this.name = name;
    }
}