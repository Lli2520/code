package com.briup.ch11;

import java.lang.String;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @Author briup-adam
 * @Date 2023/10/23 上午9:22
 * @Description
 **/

public class StandardStream {
    public static void main(String[] args) {
//        System.out.println(args[0]);
//        System.out.println(args[1]);


        System.out.println(System.in);
        //创建一个缓冲流对象
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("01code/src/十年.txt"));
            System.setIn(bis);

            Scanner sc = new Scanner(System.in);
            System.out.println(sc.next());

            PrintStream ps = new PrintStream("10-23.txt");
            System.setOut(ps);
            System.out.println("须知少时凌云志");
            System.err.println("南村群童欺我老无力");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
