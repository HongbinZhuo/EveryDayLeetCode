package com.zhb.leetcodebasic.src.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 14:15
 */

//给定两个数组，编写一个函数来计算它们的交集。
public class LC_6_TwoArrayItersection {
    public static void main(String[] args) {

        int[] nums1= new int[]{4,9,5};
        int[] nums2= new int[]{9,4,9,8,4};
        int[] nums11= new int[]{1,2,2,1};
        int[] nums22= new int[]{2,2};
         int[] nums=intersect(nums11,nums22);
       int k=0;
        for ( k = 0; k < 10; k++) {

        }
        System.out.println(k);
        System.out.println( Arrays.toString(nums));

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);

    }
}
