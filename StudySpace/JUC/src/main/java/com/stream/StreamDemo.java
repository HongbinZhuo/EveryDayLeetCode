package com.stream;

import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        long s= System.nanoTime();
        long x=System.currentTimeMillis();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .reduce((a, b) -> {
                    System.out.println(String.format("%s: %d + %d = %d",
                            Thread.currentThread().getName(), a, b, a + b));
                    return a + b;
                })
                .ifPresent(System.out::println);
        System.out.println(System.nanoTime()-s);
        System.out.println(System.currentTimeMillis()-x);

        long s2= System.nanoTime();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallel()
                .reduce((a, b) -> {
                    System.out.println(String.format("%s: %d + %d = %d",
                            Thread.currentThread().getName(), a, b, a + b));
                    return a + b;
                })
                .ifPresent(System.out::println);
        System.out.println(System.nanoTime()-s2);

    }
}
