package com.zhb.leetcodebasic.allnumber;

/**
 * @Classname GetMinDistance
 * @Description TODO
 * @Date 2021/11/17 15:43
 * @Created by Zhuohongbin
 */
public class GetMinDistance1848 {

    public int getMinDistance(int[] nums, int target, int start) {
        int reuslt=Integer.MAX_VALUE;
        for(int i=0; i< nums.length; i++){
            if(nums[i]==target && Math.abs(i-start)<reuslt){
              reuslt=Math.abs(i-start);
            }

        }
        return reuslt;
    }

    public int getMinDistance2(int[] nums, int target, int start) {
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){if(target==nums[i]){
            ans=Math.min(ans,Math.abs(i-start));
        }
        }
        return ans;
    }

}
