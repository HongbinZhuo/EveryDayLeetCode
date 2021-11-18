package com.zhb.juc.JUC.single;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 22:22
 */


//不安全
public class Holder {
    private Holder(){

    }
    public static Holder getInstance(){
        return InnerClass.holder;
    }


    public static class InnerClass{
        private static final Holder holder = new Holder();
    }


}
