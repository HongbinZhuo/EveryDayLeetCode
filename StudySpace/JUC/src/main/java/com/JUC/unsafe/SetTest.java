package com.JUC.unsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 16:07
 */
public class SetTest {

    public static void main(String[] args) {
//        Set<String> hashSet = Collections.synchronizedSet(new HashSet<>()); //解决方案1
        Set<String> hashSet = new CopyOnWriteArraySet<>();//解决方案2
        for (int i = 1; i < 100; i++) {
            new Thread(()->{
                hashSet.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(hashSet);
            },String.valueOf(i)).start();
        }
    }
}
