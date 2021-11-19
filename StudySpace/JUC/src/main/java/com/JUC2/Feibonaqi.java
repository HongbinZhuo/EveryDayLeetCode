package com.JUC2;

public class Feibonaqi {
    static  int feibo(int x){
        if (x==1 || x==2) return 1;
        else  return feibo(x-1)+feibo(x-2);
    }

    static private int computeFibonacci(int n) {
        // 假设n >= 0
        if (n <= 1) {
            return n;
        } else {
            int first = 1;
            int second = 1;
            int third = 0;
            for (int i = 3; i <= n; i ++) {
                // 第三个数是前两个数之和
                third = first + second;
                // 前两个数右移
                first = second;
                second = third;
            }
            return third;
        }
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        System.out.println(feibo(40));
        System.out.println(System.currentTimeMillis()-start+" 毫秒");



        long s=System.currentTimeMillis();
        System.out.println(computeFibonacci(40));
        System.out.println(System.currentTimeMillis()-s+" 毫秒");
    }
}
