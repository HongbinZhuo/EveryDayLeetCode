package com.zhb.othertechnology.src.Optional;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/3/4 16:19
 */
public class test {
    static {
        System.out.println("Main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {


        //System.out.println("==========不会发生类的初始化===============");
        //不会产生类的引用的方法
        //1.通过子类引用父类的静态变量，不会导致子类初始化  因为static在链接阶段的时候已经存在了
        System.out.println(Son.b);

        //2.只是一个数组 命了一个名和开辟了空间而已
        //Son [] array= new Son[5];
        //System.out.println(array.getClass());

        //3.常量不会引起父类与子类的初始化，因为所有的常量以及静态变量，都是在链接阶段都已经赋了一个值了，初始化的时候已经存在了
        System.out.println(Son.M);


    }
}

class Father{
    static int b=2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");

    }
    static  int m=100;
    static final int M =1;  //常量
}