package com.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfWorking {
    public static void main(String[] args) {

        //把 Supplier 实例传递给 Stream.generate() 生成的 Stream，默认是串行（相对 parallel 而言）
        // 但无序的（相对 ordered 而言）。由于它是无限的，在管道中，
        // 必须利用 limit 之类的操作限制 Stream 大小。

        //随机无限流需要需要limit限制流的大小
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);

        //Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);



        //生成等差数列
        //步长为3
        Stream.iterate(0, n -> n + 3)
                .limit(10)
                .forEach(x -> System.out.print(x + " "));


    }
}
