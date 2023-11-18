package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/11 上午9:26
 * @Description
 **/

public class IntegerTest {
    public static void main(String[] args) {
//        这里i是基本数据类型  不能面向对象
        int i=1;
//        System.out.println(i.toString);
//        类类型的i1  可以面向对象了
        Integer i1=1;
        System.out.println(i1.toString());
        //int  ->  integer
        i1=new Integer(1);
        i1=Integer.valueOf(1);
        //integer -> int
        i=i1.intValue();
        //自动装箱  int  ---> Integer
        i1=i;
        //自动拆箱  Integer --->  int
        i=i1;
//通过包装类型获取int的最小值 和最大值
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
//        将数字内容的字符串转成int 10进制  16进制  8进制 2进制
        int i2 = Integer.parseInt("1234");
        System.out.println("i2 = " + i2);
         i2 = Integer.parseInt("34",16);
        System.out.println("i2 = " + i2);

        i2 = Integer.parseInt("34",8);
        System.out.println("i2 = " + i2);

        i2 = Integer.parseInt("10010",2);
        System.out.println("i2 = " + i2);
//        将十进制转换成2进制  8进制   16进制
        System.out.println(Integer.toBinaryString(40));
        System.out.println(Integer.toString(40,2));
        System.out.println(Integer.toOctalString(40));
        System.out.println(Integer.toString(40,8));
        System.out.println(Integer.toHexString(40));
        System.out.println(Integer.toString(40,16));
        System.out.println(Integer.toString(40));

        long l1=1;
//        Long l=1;

    }
}
