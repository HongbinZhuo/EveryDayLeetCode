package Array;

import java.util.Arrays;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 9:55
 */


//给定一个整数数组，判断是否存在重复元素。
//
//如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
public class LC_4_ExceptTwiceAppear {
    public static void main(String[] args) {

        int[] nums= new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(Arrays.toString(nums));
        System.out.println( containsDuplicate(nums));

    }

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length<=1 || nums==null) return false;
        Arrays.sort(nums);

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]) return true;
        }
        return false;
    }
}
