package PaiXu;


import java.util.Arrays;

//计数排序
public class CountingSort {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        countingSort(array);

        System.out.println(Arrays.toString(array));
    }

    private static void countingSort(int[] array) {

        if(array == null || array.length<=1)
            return;;

        int length=array.length;
        //寻找 待排序的的范围
        int max=array[0];

        int min=array[0];
        for (int i = 0; i < length; i++) {

            if(max<array[i]){
                max=array[i];
            }

            if ((array[i]<min)){
                min=array[i];
            }

        }

        // 最大最小元素之间范围[min, max]的长度
        int offset = max - min + 1;

        // 1. 计算频率，在需要的数组长度
        int[] count = new int[offset ];

        for (int i = 0; i < length; i++) {

            int dataInCountIndex= array[i]-min;
            // 有重复的该位置就自增
            count[dataInCountIndex]++;
        }

        int j=0;//有序数字回插入

        //遍历计数 数组  对原数组进行回写  i+min 为值   count[i] 为重复次数
        for (int i = 0; i < offset; i++) {

            int originalData=i+min;//还原为原来数字

            while ((count[i]>0)){
                array[j]=originalData;
                count[i]--;
                j++;
            }
        }






    }
}
