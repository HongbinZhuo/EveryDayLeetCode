package sx0910;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Rectangular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x[][] = show(n);
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j <n ; j++) {
//                    System.out.print(x[i][j]);
//                }
//                System.out.println("\n");
//
        for (int[] link : x) {
            System.out.println(Arrays.toString(link));
        }

    }

    private static int[][] show(int n) {
        int[][] a = new int[n][n];
        // ceil向上取整
        for (int i = 0; i < Math.ceil(n / 2); i++) {

            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) a[i][j] = i + 1;
            }

            for (int j = 0; j < n; j++) {
                if (a[j][i] == 0) a[j][i] = i + 1;
            }

            for (int j = 0; j < n; j++) {
                if (a[n - 1 - i][j] == 0) a[n - 1 - i][j] = i + 1;
            }

            for (int j = 0; j < n; j++) {
                if (a[j][n - 1 - i] == 0) a[j][n - 1 - i] = i + 1;
            }

        }
        return a;
    }
}
