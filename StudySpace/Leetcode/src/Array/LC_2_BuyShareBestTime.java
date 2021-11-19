package Array;

import java.util.Arrays;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/26 9:46
 */

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
public class LC_2_BuyShareBestTime {
    public static void main(String[] args) {


            int[] nums= new int[]{7,1,5,3,6,4};
            System.out.println( maxProfit(nums));
            System.out.println(Arrays.toString(nums));

    }


    public static int maxProfit(int[] prices) {
        int  maxProfit=0;
        int profit=0;
        for(int i=0 ;i < prices.length-1;i++){
            int temp=prices[i+1]-prices[i];
            if(temp>0){
                profit=profit +prices[i+1]-prices[i];
            }
        }


        return profit;
    }
}
