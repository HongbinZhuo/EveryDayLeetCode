package com.zhb.othertechnology.src.exercise;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/3/8 14:57
 */
public class Recurioin {
    public  static  void recur(int input){
        if(input >0){
            System.out.println( input);
            recur(input-1);
            System.out.println(input);
        }
    }

    public static void main(String[] args) {
         recur(10);
         String a="4544";
         a.length();
         new StringBuffer("ni");
        System.out.println(5+5+"10");
    }
}
