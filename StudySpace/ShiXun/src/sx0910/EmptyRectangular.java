package sx0910;

import javax.swing.*;
import java.util.Scanner;

public class EmptyRectangular {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        show(n);
    }

    private static void show(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                if(i==0||i==n-1){
                    System.out.print("*");
                }else{
                    if(j==0||j == n-1){
                        System.out.print("*");
                    }
                    System.out.print(" ");
                }
            }
            System.out.println("\n");
        }
    }

}
