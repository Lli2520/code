package com.briup.jdk8;

import java.util.stream.Stream;

/**
 * Stream  的中间操作
 *
 */

public class StreamMiddleOP {
    public static void main(String[] args) {
      Stream<String>  stream = Stream.of("B站小王子", "抖音小王子", "B站小公主", "蛋仔小公主", "撒哈拉小公主", "黑大帅", "健身达人", "花泽鑫","提问哥");
      //过滤
         stream.filter(s -> s.length() > 3)
                 //映射 将指定元素映射成任意元素
                .map(String::length )
                 .sorted((i1,i2)->((i1.intValue()&1)==1)?-1:1)
                .forEach(System.out::println);
        stream = Stream.of("B站小王子", "抖音小王子", "B站小公主", "蛋仔小公主", "撒哈拉小公主", "黑大帅", "健身达人", "花泽鑫","提问哥");
        stream.limit(6)
                .skip(2)
                .forEach(System.out::println);

        stream = Stream.of("B站小王子", "抖音小王子", "B站小公主", "蛋仔小公主", "撒哈拉小公主", "黑大帅", "健身达人", "花泽鑫","提问哥");


        long count = stream.map(String::length)
                .distinct()
                .count();
        System.out.println(count);
    }
}
