package com.zhb.leetcodebasic.src.other;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/1 15:28
 */
public class JiShuDanYuanGe {
    public static void main(String[] args) {
        int n=2,m=3;
        int[][] indices=new int[][]{{0,1},{1,1}};
        oddCells(n,m,indices);
    }
    public static int oddCells(int n, int m, int[][] indices) {
        int[][] s=new int[n][m];
        int count=0;
        for (int i = 0; i < indices.length; i++) {
            int x=indices[i][0];
            int y=indices[i][1];
            //行先加
            for (int i1 = 0; i1 < m; i1++) {
                s[x][i1]++;
            }
            //
            for (int i1 = 0; i1 < n; i1++) {
                s[i1][y]++;
            }
        }
        for (int i1 = 0; i1 < n; i1++) {
            for (int i2 = 0; i2 < m; i2++) {
                if(s[i1][i2]%2!=0) count++;
            }
        }

        return count;

    }
}
