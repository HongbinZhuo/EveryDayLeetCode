package com.zhb.leetcodebasic.src.Total.SearchAndSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/8 14:50
 */
public class CountSmaller {
    public static void main(String[] args) {
        int[] nums=new int[]{5,2,6,1};
        countSmaller(nums);
    }
    public static List<Integer> countSmaller(int[] nums) {
        if(nums ==null) return null;

     int len=nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =len-1; i>=0; i--) {
            int count=0;
            for (int j =len-1; j>=i; j--) {
              if(nums[j]<nums[i]){
                  count++;
              }
            }
            list.add(0,count);
        }


        return list;


    }
}
