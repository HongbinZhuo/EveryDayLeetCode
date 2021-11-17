package com.zhb.othertechnology.src.LamdaEample;

public class Solution {
    public static void main(String[] args) {
        int s = 100, n = 10;
        System.out.println(getTotal(s, n));
        System.out.println(getIH(s, n));
    }


    private static double getTotal(double s,int n) {
        double total=0;
        s=s/2;
        for (int i=1;i<n;i++){
                total=total+s*2;
            s=s/2;
        }
        return  total+100;
    }
    private static double getIH(double s,int n) {
        if(n==1) return s/2;
        else  s=getIH(s,n-1)/2;
        return s;
    }
}
