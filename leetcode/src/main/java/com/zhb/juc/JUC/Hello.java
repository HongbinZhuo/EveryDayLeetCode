package com.zhb.juc.JUC;

import java.util.ArrayList;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/7 14:16
 */
public class Hello {
    byte[]  array=new byte[1024*1024];

    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList<>();
        int count=0;
        try {
        while(true){
         arrayList.add(new Hello());
         count++;
        }
        } catch (Error e) {
            System.out.println("count"+count   );
            e.printStackTrace();
        }

    }
}
