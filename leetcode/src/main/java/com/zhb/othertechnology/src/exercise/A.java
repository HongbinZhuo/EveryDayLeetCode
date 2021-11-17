package com.zhb.othertechnology.src.exercise;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/3/5 15:28
 */
public class A {


    public static void main(String[] args) {
        B b = new B();
        A a=(A) b;

        a.methon();


        a.methons();


//        String name="a=1&b=2";
//        String[] values=name.split("&|=");
//        System.out.println();
//        System.out.println(Math.ceil(2.1));
    }
    public void methon(){
        System.out.println("a");


    }
    public static void methons(){
        System.out.println("as");

    }

}

class B extends A{
    public void methon(){
        System.out.println("b");

    }
    public static void methons(){
        System.out.println("bs");

    }
}