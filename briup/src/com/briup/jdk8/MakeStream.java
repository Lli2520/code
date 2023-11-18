package com.briup.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 通过数据源以获取Stream
 */
public class MakeStream {
    public static void main(String[] args) {
        //可变长参数 创建 Stream  借助于数组工具类完成转换Stream的操作
        Stream<Integer> stream = Stream.of(12, 13, 23, 45, 56, 446);
        //使用数组工具类 将数组转置成stream
        String[] s = {"果渣", "果冻", "果干", "果树", "果皮", "果盘", "果汁", "果粒"};
        Stream<String> stream1 = Arrays.stream(s);
        //创建集合
        List<String> list = Arrays.asList(s);
        //集合转成Stream
        Stream<String> stream2 = list.stream();

        IntStream intStream = IntStream.of(1, 2, 3, 45, 64, 56);
    }
}
