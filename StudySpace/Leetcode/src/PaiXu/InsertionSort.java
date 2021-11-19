package PaiXu;

import java.util.Arrays;

public class InsertionSort {

//插入排序
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array){
        //判断是否为空 或者空串 或者只有一个元素
        if(array==null||array.length<=1){
            return;
        }
        //记录数组长度
        int length=array.length;

        //用来记录插入的数 以及后面交换
        int insertNum;

        for (int i = 1; i < length; i++) {

            //第i次 需要插入的数 即为下标为i的数
            insertNum = array[i];

            //插入到数 第i个数 与前面的 下标小于 i-1（且要 >=0 )的数相比 碰到比自己大的数交换位置
            int j=i-1;
            //第i次时 说明 前面 i-1 的元素以及有序
            while (j>=0&& array[j]>insertNum){

               //从后往前循环，大于inserNumd的数向后移动和一格
                array[j+1]=array[j];
                //向前移动
                j--;
            }

            //while 循环后 j=为需要需要插入位置 的前面  将需要插入的数 插入到j的后面 即 j+1
            array[j+1]=insertNum;
        }

    }
}
