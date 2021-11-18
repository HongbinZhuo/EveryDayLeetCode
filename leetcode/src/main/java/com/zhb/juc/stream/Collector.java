package com.zhb.juc.stream;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/*

	T:流中要收集的对象的泛型
	A:累加器的类型，累加器是在收集过程中用于累加部分结果的对象
	R:收集操作得到的对象(通常但不一定是集合)的类型。
*/
public interface Collector<T,A,R> {

    //结果容器
    Supplier<A> supplier();

    //累加器执行累加的具体实现
    BiConsumer<A, T> accumulator();

    //合并2个结果的容器
    BinaryOperator<A> combiner();

    //对结果容器应用最终转换finisher
    Function<List<T>, List<T>> finisher();

    //characteristics
    Set<java.util.stream.Collector.Characteristics> characteristics();
}
