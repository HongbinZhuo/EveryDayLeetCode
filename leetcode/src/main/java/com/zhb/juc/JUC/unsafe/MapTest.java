package com.zhb.juc.JUC.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/2/6 16:12
 */
public class MapTest {
    //map 是这样用的吗？  不是，工作中不使用这个
    //默认等价什么？ new HashMap<>(16,0.75);
    public static void main(String[] args) {
        //<  16  0.75   1<<30   >
        //解决方法一
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
//      解决方法二  ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        //加载因子、初始化容量
        for(int i =1; i <100; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

}
