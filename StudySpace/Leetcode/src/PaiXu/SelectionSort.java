package PaiXu;

import java.util.Arrays;

public class SelectionSort {

//选择排序
    public static void main(String[] args) {
        int[] array = {1, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        selectionSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array){
        //判断是否为空 或者空串或者只有一个元素
        if(array==null||array.length<=1){
            return;
        }

        int length=array.length;

        for (int i = 0; i < length - 1; i++) {
            //保存第i的下标   最小数索引
            int minIdex=i;
            for (int j = i+1; j < length; j++) {
                //在i后面中 找到最小的数
                if (array[j]<array[minIdex]){
                    minIdex=j;
                }
            }

            //交换元素
            if(i!=minIdex){
                //swap交换i与minIndex
               int temp=array[i];
               array[i]=array[minIdex];
               array[minIdex]=temp;
            }

        }


    }
}
