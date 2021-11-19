package PaiXu;

import java.util.Arrays;

public class QuickSort {

//快速排序
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        quickSort(array);

        System.out.println(Arrays.toString(array));
    }


    public static void quickSort(int array[]){
        quickSort(array,0,array.length-1);
    }

   //递归分治   mid 由每一次快排后 返回的分治点  即为left =right 相交*（相等）的点的
    private static void quickSort(int[] array, int left, int right) {
        //停止条件 空 左右指针相交 数组长度小于等于1
        if (array == null || left >= right || array.length <= 1) {
            return;
        }

        int mid = partition(array, left, right);
        quickSort(array,left,mid);
        quickSort(array,mid+1,right);
    }

//一次快排
    static int partition(int[] array, int left, int right){
        //每次归并 默认点为 第一个点   temp用来记录被覆盖点的值，其为 每次快排的第一个值left【0】；
        int temp=array[left];
        //--right ++left 因为while先判断 才会执行循环体 因此在归并中使用 --right ++left
        //先从右边 然后从左边 向中间逼近

         while (left<right) {

            //从右边向中间逼近 如果碰到 右边小于左边的将其值赋值给左边 并且左边开始移动
             while (temp < array[right] && left < right) {
                 --right;
             }//while 结束时找到右边小于左边的点

             //左边的将其值赋值给左边
             if (left < right) {
                 array[left] = array[right];//右边值赋值给左边
                 ++left;//左边开始移动到下一个
             }

            ///////////

             //从左边向 中间逼近 如果碰到  左边大于右边的 将其值赋值给右边  右边开始移动
             //temp扮演的为右边的的值
             while (temp>= array[left] && left<right) {
                 ++left;
             }//while 结束时 找到右边大于右边的点

             if (right > left){
                 array[right]=array[left];//左边值赋值给右边
                 --right;//右边开始移动到下一个

             }
         }
         //记录的temp值
         array[left] =temp; //将第一个点的值 赋值给left=right 相交的处

        return left;//返回相互点的下标
    }
}
