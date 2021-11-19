package com.JUC.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 15:56
 */
public class ListTest {
    public static void main(String[] args) {

        List<Object> arrayList = new CopyOnWriteArrayList<>();
//        List<Object> arrayList = Collections.synchronizedList(new ArrayList<>());


        for(int i=1;i<=10;i++){
            new Thread(()->{
                arrayList.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(arrayList);
            },String.valueOf(i)).start();
        }

    }
}