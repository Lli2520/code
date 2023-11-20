package com.atguigu.day1;

/**
 * ClassName: ExceptionDemo
 * Package: com.atguigu.day1
 * Description:
 *
 * @Author lixin
 * @Create 2023/11/20/020 9:12
 * @Version 1.0
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        int[] arr = {34, 12, 67, 123, 124};
        int num = ArrayTools.getElement(arr, 4);
        System.out.println("num=" + num);
        System.out.println("over");
    }
}
