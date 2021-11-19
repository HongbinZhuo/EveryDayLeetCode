package Array;

import java.util.Arrays;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 15:00
 */
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class LC_8_MoveZeroLast {
    public static void main(String[] args) {

        int[] nums= new int[]{1,3,12,0,0};
          moveZeroes2(nums);
        int[] ints = new int[0];
        System.out.println(ints);
        System.out.println(ints.length);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        if (nums.length==1 ||nums ==null) return;
        int length= nums.length;
        for (int i = 0; i < length; i++) {

           if (nums[i] != 0 ){
               int count=0;

               for (int i1 = 0; i1 < i; i1++) {
                   if( nums[i1]==0) count++;
               }
               if (count!=0) {
                   nums[i - count] = nums[i];
                   nums[i] = 0;
               }
           }
        }
    }
    public static void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
