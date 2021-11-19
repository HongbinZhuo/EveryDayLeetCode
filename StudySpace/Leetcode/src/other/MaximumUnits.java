package other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/4 10:11
 */

//请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
//numberOfBoxesi 是类型 i 的箱子的数量。
//numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
//整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上

public class MaximumUnits {


    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int length=boxTypes.length;
        int result=0;

//        Arrays.sort(boxTypes, (o1, o2) -> o2[1]-o1[1]);
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        for (int i = 0; i < length; i++) {
            if(boxTypes[i][0]<=truckSize){
                result +=boxTypes[i][0]*boxTypes[i][1];
                truckSize -=boxTypes[i][0];
            }else{
                result+=truckSize*boxTypes[i][1];
                break;
            }
        }

        return  result;
    }
}
