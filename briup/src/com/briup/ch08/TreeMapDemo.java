package com.briup.ch08;

import java.lang.String;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author briup-adam
 * @Date 2023/10/16 下午3:47
 * @Description 比较器排序优先于自然排序
 **/

public class TreeMapDemo {
    public static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            /**
             * 偶数在前升序
             * 奇数在后降序
             */
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == 1 && o2 % 2 == 1)
                    return o2 - o1;
                else if (o1 % 2 == 0 && o2 % 2 == 0)
                    return o1 - o2;
                else if (o1 % 2 == 1 && o2 % 2 == 0)
                    return 1;
                else
                    return -1;
            }
        };
        TreeMap<Integer, String> map = new TreeMap<>(cmp);
        //39  1  3  2  40  20
        map.put(3, "杨家俊");
        map.put(1, "李欣");
        map.put(2, "徐洋");
        map.put(40, "李鑫");
        map.put(39, "赵佳伟");
        map.put(20, "赵佳乐");
//        Set<Integer> keySet = map.keySet();
//        for (Integer integer : keySet) {
//            String value = map.get(integer);
//            System.out.println(integer+"："+value);
//        }
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }
    }
}
