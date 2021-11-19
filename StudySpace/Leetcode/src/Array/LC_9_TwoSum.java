package Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 15:34
 */
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

public class LC_9_TwoSum {
    public static void main(String[] args) {

        int[] nums= new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum2(nums, 9)));

    }


    public static  int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == (target - nums[i])) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


    public static  int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i]))
                return  new int[]{hashMap.get(target-nums[i]),i};
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }


}
