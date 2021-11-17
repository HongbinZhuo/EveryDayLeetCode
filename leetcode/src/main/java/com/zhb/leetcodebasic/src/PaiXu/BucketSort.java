package com.zhb.leetcodebasic.src.PaiXu;

import java.util.*;

public class BucketSort {


    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        bucketSort(array);

        System.out.println(Arrays.toString(array));
    }
    /**
     * Description: 桶排序
     *
     * @param array
     * @return void
     * @author JourWon
     * @date 2019/7/11 23:43
     */
    private static void bucketSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        // 建立桶，个数和待排序数组长度一样
        int length = array.length;

        LinkedList<Integer>[] bucket = (LinkedList<Integer>[]) new LinkedList[length];

        // 待排序数组中的最大值
        int maxValue = Arrays.stream(array).max().getAsInt();
        // 根据每个元素的值，分配到对应范围的桶中
        for (int i = 0; i < array.length; i++) {
            int index = toBucketIndex(array[i], maxValue, length);
            // 没有桶才建立桶(延时)
            if (bucket[index] == null) {
                bucket[index] = new LinkedList<>();
            }
            // 有桶直接使用
            bucket[index].add(array[i]);
        }

        // 对每个非空的桶排序，排序后顺便存入临时的List，则list中已经有序）
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                temp.addAll(bucket[i]);
            }
        }

        // 将temp中的数据写入原数组
        for (int i = 0; i < length; i++) {
            array[i] = temp.get(i);
        }
    }

    /**
     * Description: 映射函数，将值转换为应存放到的桶数组的索引
     *
     * @param value
     * @param maxValue
     * @param length
     * @return int
     * @author JourWon
     * @date 2019/7/11 23:44
     */
    private static int toBucketIndex(int value, int maxValue, int length) {
        return (value * length) / (maxValue + 1);
    }

}
