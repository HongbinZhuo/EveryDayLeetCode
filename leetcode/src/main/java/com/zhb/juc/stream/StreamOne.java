package com.zhb.juc.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOne {

    public static void main(String[] args) {
        //集合构造
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5).stream();
        //静态构造
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        //随机数构造
        IntStream.range(1,100);

            new Random(100).longs();
//        System.out.println(new Random(100).longs());
        System.out.println(new Random().doubles());


        //4.IntStream/LongStream/DoubleStream
        //也可以使用Stream<Integer>、Stream<Long>、Stream<Double>构造
        IntStream.of(new int[]{1,2,3});


        //5.文件输入构造
        //通常Stream不需要关闭，仅仅是需要关闭在IO通道上运行的流
        try(final Stream<String> lines= Files.lines(Paths.get("somePath"))){
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //下面两种等价的方式，完成将字符串转大写并排序
//1.函数式接口方式
        Stream.of("apple","banana","orange","grapes", "melon","blueberry","blackberry")
                .map(String::toUpperCase)
                .sorted();

//2.Lambda表达式方式
         Stream.of("apple","banana","orange","grapes", "melon","blueberry","blackberry")
                .map(v->v.toUpperCase())
                .sorted();



    }
}
