package Array;

import java.util.Arrays;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/27 14:38
 */
//给定一个 n × n 的二维矩阵表示一个图像。
//将图像顺时针旋转 90 度。
//说明：
//你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像

public class LC_11_RotateImage {
    public static void main(String[] args) {

        int[][] nums= new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
            };
        rotate(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
             swap(matrix[i]);
        }
    }
    public static  void  swap(int[] num){
        for (int i = 0; i < num.length; i++) {
            int j=num.length-1-i,temp;
            if (i<j) {
                temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }

    }
}
