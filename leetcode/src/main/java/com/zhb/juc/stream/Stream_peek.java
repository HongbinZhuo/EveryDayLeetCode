package com.zhb.juc.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_peek {
    public static void main(String[] args) {
        //对每一个元素进行一些副作用
        List<Integer> list = new ArrayList();
        List<Integer> result = Stream.of(1, 2, 3, 4)
                .peek(x -> list.add(x))
                .map(x -> x * 2)
                .collect(Collectors.toList());

//1
//2
//3
//[1, 2, 3]
        System.out.println(list);
        System.out.println(result);

    }

    //map()签名，返回值R
    <R, T> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return null;
    }

    //peek()签名，返回值void
    <T> Stream<T> peek(Consumer<? super T> action) {
        return null;
    }


}
