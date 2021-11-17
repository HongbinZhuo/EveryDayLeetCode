package com.zhb.leetcodebasic.src.Array;

import java.util.Arrays;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 14:12
 */
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
public class LC_5_OnlyOneAppear {
    public static void main(String[] args) {

        int[] nums= new int[]{4,1,2,1,2};
        System.out.println(Arrays.toString(nums));
        System.out.println( singleNumber(nums));

    }
    public static  int singleNumber(int[] nums) {
        int sum=0;
        for (int i : nums) {
            sum =sum ^ i;
        }
        return sum;
    }
}
