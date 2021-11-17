package com.zhb.leetcodebasic.src.Array;

import java.util.Arrays;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 14:20
 */
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//        你可以假设除了整数 0 之外，这个整数不会以零开头。

public class LC_7_AddOne {
    public static void main(String[] args) {

        int[] nums= new int[]{9,9,9,9};
        System.out.println( Arrays.toString(plusOne(nums)));

    }
    public static int[] plusOne(int[] digits) {
        if (digits == null) return null;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }
}
