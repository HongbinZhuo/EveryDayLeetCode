package com.zhb.othertechnology.src.streams;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/12 16:57
 */
public class ParalleArray {
    public static void main( String[] args ) {
        long[] arrayOfLong = new long [ 20000 ];
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊");
        Arrays.parallelSetAll( arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt( 1000000 ) );

        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();

        Arrays.parallelSort( arrayOfLong );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();
        //地板
        System.out.println(Math.floor(3.1));
        //天花板
        System.out.println(Math.ceil(3.2));
        System.out.println();
    }

}
