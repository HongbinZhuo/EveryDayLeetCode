package com.zhb.leetcodebasic.src.Total.Hash;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/6 16:25
 */

//给定一个Excel表格中的列名称，返回其相应的列序号。
//
//例如，
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...

public class TitleToNumber {

    public static void main(String[] args) {
        String s="BA";
        titleToNumber(s);
    }
    public static int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }



}
