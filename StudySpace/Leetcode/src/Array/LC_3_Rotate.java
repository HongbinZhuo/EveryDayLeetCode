package Array;

import java.util.Arrays;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 9:50
 */
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class LC_3_Rotate {
    public static void main(String[] args) {

        int[] nums= new int[]{1,2,3,4,5,6,7};
         rotate(nums,3);
        System.out.println(Arrays.toString(nums));

    }

    public  static  void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0 || nums.length == 1)
            return;

        int index = 0;
        int cache = nums[index];
        int start = 0;
        for(int i=0;i<nums.length;i++){

            int index2 = (index + k)%nums.length;

            //交换
            int tmp = nums[index2];
            nums[index2] = cache;
            cache = tmp;
            index = index2;

            if(index == start) {
                index++;
                start = index;
                cache= nums[index];
            }
        }

    }
}
