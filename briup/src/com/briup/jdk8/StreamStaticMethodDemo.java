package com.briup.jdk8;

import java.io.Serializable;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Stream的静态方法
 */
public class StreamStaticMethodDemo {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 21, 12, 13, 13, 1);
        Stream<String> stream2 = Stream.of("a","b","c");
        Stream<Object> stream = Stream.concat(stream1, stream2);
        stream.forEach(System.out::println);
        Stream.generate(Math::random)
                .limit(100)
                .map(i->(int)(i.doubleValue()*21+40))
                .forEach(System.out::println);
        //迭代生成
        Stream.iterate(1,i->i+3)
                .limit(50)
                .forEach(System.out::println);
    }
}
