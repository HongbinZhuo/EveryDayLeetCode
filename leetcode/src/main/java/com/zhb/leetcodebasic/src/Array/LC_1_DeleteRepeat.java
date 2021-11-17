package com.zhb.leetcodebasic.src.Array;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 9:29
 */
//    给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//            不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
public class LC_1_DeleteRepeat {

    public static void main(String[] args) {
        int[] nums= new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println( removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
//
//        ArrayList<String> list=new ArrayList<String>();
//        String[] a= (String[]) list.toArray();
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length ==0 ||nums == null)  return 0;
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                nums[++i]=nums[j];
            }
        }

        return  i+1;
    }
}
