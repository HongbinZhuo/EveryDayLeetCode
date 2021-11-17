package com.zhb.leetcodebasic.src.other;


/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/30 15:47
 */
//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
public class OneNumber {
    public static void main(String[] args) {
    hammingWeight(-3);
    }
    // you need to treat n as an unsigned value

    public static int hammingWeight(int n) {
        int mask=1;
        int count=0;
        for (int i = 0; i < 32; i++) {
            if((n&mask)==mask){
                count++;
            }
            mask <<=1;
        }



        return  count;
    }


}
