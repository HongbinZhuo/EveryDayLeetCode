package com.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream_filter {
    public static void main(String[] args) {
        Integer[] integers = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .filter(v -> v > 0)
                .toArray(Integer[]::new);
        System.out.println(Arrays.asList(integers));
        //limit/skip
        //distinct
        //limit返回Stream前面几个元素，skip扔掉前面几个元素。
        Stream.of("apple","apple","Aanana","orange","grapes", "melon","blueberry","blackberry").limit(3).distinct()
                .filter(v->v.toUpperCase().startsWith("A"))
                .forEach(System.out::println);


        Integer sum = Arrays.asList(integers).stream().reduce(0,(a,b)->a+b);
        Integer reduce = Arrays.asList(integers).stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println(reduce);

        String concat = Stream.of("A","B","C","D")
                .reduce("",String::concat);

        double minValue = Stream.of(-1.5,1.0,-3.0,-2.0)
                .reduce(Double.MAX_VALUE,Double::min);

        //有起始值
        int sumValue = Stream.of(1,2,3,4)
                .reduce(0,Integer::sum);

        //无起始值
        int sumValueNoStart = Stream.of(1,2,3,4)
                .reduce(Integer::sum).get();
    }


}
