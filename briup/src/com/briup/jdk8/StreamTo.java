package com.briup.jdk8;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 将Stream  恢复成数据源的形式
 */
public class StreamTo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        //直接转置成Object类型的数组
        Object[] array = stream.toArray();
        System.out.println(Arrays.toString(array));
//        stream.toArray(i->new String[i]);
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        String[] arr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));

//将Stream 转置成集合
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set);
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
//        stream.collect(Collectors.toCollection(()->new ArrayList<>()));
//        stream.collect(Collectors.toCollection(()->new HashSet<>()));
//        stream.collect(Collectors.toCollection(ArrayList::new));
        HashSet<String> collect = stream.collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect);
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        ArrayList<String> list1 = stream.collect(ArrayList<String>::new, List::add, List::addAll);
        System.out.println(list1);
        //Stream转置成字符串

        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        String s = stream.collect(Collectors.joining());
        System.out.println(s);
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        String s1 = stream.collect(Collectors.joining("^_^"));
        System.out.println(s1);
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        String s2 = stream.collect(Collectors.joining("❤", "briup", "java"));
        System.out.println(s2);
    }
}
