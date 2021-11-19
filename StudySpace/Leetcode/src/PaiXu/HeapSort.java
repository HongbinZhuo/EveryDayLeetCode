package PaiXu;

import java.util.Arrays;

//堆排序
public class HeapSort {
    public static void main(String[] args) {

        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        heapSort(array);

        System.out.println(Arrays.toString(array));
    }
    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;

        //1.构建大顶堆  数组下标为0开始  即根的下标为0 左子树为 2i+1 右子树为 2i +2  父亲节点为 （i-1）/2


        for (int i = length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(array, i, length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = length - 1; j > 0; j--) {
            //将堆顶元素与末尾元素进行交换
            swap(array, 0, j);
            //重新对堆进行调整
            adjustHeap(array, 0, j);
        }

    }
    private static void adjustHeap(int[] array, int i, int length) {
        //先取出当前元素i
        int temp = array[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        array[i] = temp;
    }

    /**
     * Description: 交换元素位置
     *
     * @param array
     * @param a
     * @param b
     * @return void
     * @author JourWon
     * @date 2019/7/11 17:57
     */
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
