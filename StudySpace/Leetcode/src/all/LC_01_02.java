package all;

import java.util.HashMap;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/6 8:53
 */
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。

public class LC_01_02 {
    public static void main(String[] args) {
        System.out.println(Math.round((3/2)));




    }

    public int majorityElement(int[] nums) {
        int len = nums.length;
        double count =len/2 ;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer it=nums[i];
            hashmap.put(it,hashmap.getOrDefault(it,0)+1);
        }
        for (Integer key: hashmap.keySet() ) {
            if (hashmap.get(key)>count){
                return key;
            }
            
        }
        return -1;
    }
}
