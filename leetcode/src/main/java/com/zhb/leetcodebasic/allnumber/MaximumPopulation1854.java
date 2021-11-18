package com.zhb.leetcodebasic.allnumber;

/**
 * @Classname MaximumPopulation1854
 * @Description TODO
 * @Date 2021/11/17 16:09
 * @Created by Zhuohongbin
 */
public class MaximumPopulation1854 {
    public int maximumPopulation(int[][] logs) {
        int[] d = new int[101];
        for(int[] log : logs) {     //遍历每个人的出生和死亡年份
            d[log[0] - 1950] += 1;  //出生年份人数+1
            d[log[1] - 1950] -= 1;  //死亡年份人数-1
        }
        int s = 0, res = 0, cnt = 0;
        for(int i = 0; i <= 100; i++){
            s += d[i];      //s是记录每一年的存活人数
            if(s > cnt){
                cnt = s;
                res = i;
            }
        }
        return res + 1950;
    }
}
