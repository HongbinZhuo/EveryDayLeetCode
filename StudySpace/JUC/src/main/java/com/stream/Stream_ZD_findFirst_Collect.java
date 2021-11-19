package com.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_ZD_findFirst_Collect {
    public static void main(String[] args) {
        //findFirst
        Optional<String> ops = Stream.of("apple","banana","orange","brange","blueberry","blackberry")
                .filter(s->s.startsWith("b"))
                .findFirst();
        System.out.println(ops);   //如果为空则返回apple


        //Collect
        // 也许很多人经常搞不清Collector、Collection、Collections、Collectors。
        // 1.Collection是Java集合祖先接口；
        // 2.Collections是java.util包下的一个工具，内含有各种处理集合的静态方法。
        // 3.java.util.stream.Stream#   collect(java.util.stream.Collector)是Stream的一个函数，负责收集流。
        // 4.java.util.stream.Collector是一个收集函数的接口，声明一个收集器功能。
        // 5.java.util.Collectors是一收集器的工具类，内置了一系列常用收集器的实现，如Collectors.toList()/toSet()，
        // 作为上述第3条的collect()参数。

        //toList/toMap
        //方式1
        List<String> list = Stream.of("I","love","you","too")
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        //方式2
//        List<String> list = stream.collect(Collections.toList());

        //toMap
        Map<Integer, Integer> collect1 = Stream.of(1, 3, 4)
                .collect(Collectors.toMap(x -> x, x -> x + 1));


        //数组转List
        List list2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Integer [] myArray = { 1, 2, 3 };
        List myList = Arrays.stream(myArray).collect(Collectors.toList());

        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray2 = { 1, 2, 3 };
        List myList2 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        ///partitioningBy()
        //Map<Boolean, List<Student>> passingFailing = students.stream()
        //         .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
        //
        ////groupingBy
        //Map<Department, List<Employee>> byDept = employees.stream()
        //            .collect(Collectors.groupingBy(Employee::getDepartment));
        //
        //
        ////mapping的下游
        ////按照部门对员工进行分组，并且只保留员工的名字
        //Map<Department,List<String>> byDept=employees.stream()
        //            .collect(Collectors.groupingBy(Employee::getDepartment,
        //                Collectors.mapping(Employee::getName,   //下游收集器
        //                    Collectors.toList())));

    }



}
