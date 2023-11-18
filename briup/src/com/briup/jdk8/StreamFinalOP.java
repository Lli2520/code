package com.briup.jdk8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream的最终操作
 */
public class StreamFinalOP {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        //获取Stream的迭代器
        Iterator<String> iterator = stream.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //Foreach
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
//        stream.forEach(i -> System.out.println(i));
        stream.forEach(System.out::println);
        //统计元素个数
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        long count = stream.count();
        System.out.println(count);
        //找出最大元素
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
//        Optional<String> max = stream.max(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        Optional<String> max = stream.max((o1, o2) -> o1.compareTo(o2));

        Optional<String> max = stream.max(String::compareTo);
        System.out.println(max.get());
        //找出最小元素
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        Optional<String> min = stream.min(String::compareTo);
        System.out.println(min.get());
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(i -> i.length()));
        System.out.println(map);
        //条件匹配
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        //要求全部元素满足  返回true
        boolean b = stream.allMatch(s -> {
            char[] chars = s.toCharArray();
            int sum = 0;
            for (char c : chars) {
                sum += c;
            }
            return sum > 20480;
        });
        System.out.println(b);//true
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        //任意匹配 只要其中有一个元素 满足条件 返回true
        boolean b1 = stream.anyMatch(a -> a.contains("干"));
        System.out.println(b1);
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        //要求所有元素都不能满足指定条件
        boolean b2 = stream.noneMatch(String::isEmpty);
        System.out.println(b2);//true
        //计算
        IntStream intStream = IntStream.rangeClosed(1, 100);
        OptionalInt reduce = intStream.reduce((x, y) -> x + y);
        System.out.println(reduce.getAsInt());
        //查找stream中第一个元素
        stream = Stream.of("果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒");
        Optional<String> s = stream.findFirst();
        System.out.println(s.get());
    }
}
