package com.zhb.othertechnology.src.LamdaEample;

public class demo {
    //定义一个方法，参数使用函数式接口
    public  static  void  show(MyFunctionalInterface myFunctionalInterface){
        myFunctionalInterface.method();
    }

    public static void main(String[] args) {

        //传递实现类方法实现
        show(new MyFunctionalInterfaceImpl());
        //匿名内部类重写接口中的抽象方法
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });


         // lambda表达式
        show(()-> System.out.println("使用Lambda重写接口中的抽象方法")
                );

    }
}
