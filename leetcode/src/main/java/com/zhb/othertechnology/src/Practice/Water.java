package com.zhb.othertechnology.src.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Water {
    public static void main(String[] args) {
        int n,m,time=0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int[] z=new int[n];
        for (int i = 0; i < n; i++) {
            z[i]=sc.nextInt();
        }
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < m; i++) {
        a.add(z[i]);
        }
//        for (Integer integer : a) {
//            System.out.println(integer);
//        }
        for (int i = m; i < n; i++) {
          a.set(a.indexOf(Collections.min(a)),Collections.min(a)+z[i]);
        }
        System.out.println(Collections.max(a));
    }

}
