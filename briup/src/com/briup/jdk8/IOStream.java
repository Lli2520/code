package com.briup.jdk8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * IO结合Stream操作
 */
public class IOStream {
    public static void main(String[] args) {
        try(FileReader fr=new FileReader("C:\\Users\\sxx\\IdeaProjects\\bttc-java-basic-code\\01code\\src\\十年.txt"); BufferedReader br=new BufferedReader(fr)){
            Stream<String> lines = br.lines();
            Optional<String> max = lines.max((s1, s2) -> s1.length() - s2.length());
            System.out.println(max.get());
        }
        catch (Exception e){

        }
    }
}
