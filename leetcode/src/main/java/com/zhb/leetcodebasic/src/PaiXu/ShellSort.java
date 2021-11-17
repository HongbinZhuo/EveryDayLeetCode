package com.zhb.leetcodebasic.src.PaiXu;

import java.util.Arrays;
//希尔排序
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        shellSort(array);

        System.out.println(Arrays.toString(array));


    }

    public static void shellSort(int[] array){
         //判断是否为空 或者空串 或者只有一个元素
        if(array==null || array.length<=1){
            return;
        }

        int length=array.length;
        //gap初始为 长度的一半
        int temp,gap=length/2;

            //增量缩小到为1时 为整个数据段排序
        while (gap>0){

            //每次循环从gap开始     比较 下标 gap 到 length-1
            for (int i = gap; i < length; i++) {
                //临时变量记录 i时的数据
                temp=array[i];

                //将当前的数与减去增量之后位置的数进行比较，如果大于当前数，将它后移
                int perIndex = i-gap; //缩量为gap 比较前面的数据

            while (perIndex>=0 && array[perIndex]>temp){
                //对于前面大于后面的数进行互换
                array[perIndex+gap]=array[perIndex];
                //再以 缩量gap往前寻找比较
                perIndex -=gap;

            }
            //将当前数放到空 出来的位置
            array[perIndex+gap]=temp;

            }
            //缩小增量 采用/2递归
            gap /= 2;
        }

    }

}
