package com.zhb.juc.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyCollector<String> implements Collector<String, List<String>, List<String>> {
    @Override
    public Supplier<List<String>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<String>, String> accumulator() {
        return (List<String> l, String s) -> {
            l.add(s);
        };
    }

    @Override
    public BinaryOperator<List<String>> combiner() {
        return (List<String> l, List<String> r) -> {
            List<String> list = new ArrayList<>(l);
            list.addAll(r);
            return list;
        };
    }

    @Override
    public Function<List<String>, List<String>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(java.util.stream.Collector.Characteristics.IDENTITY_FINISH));
    }

}



