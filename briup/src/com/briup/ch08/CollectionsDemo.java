package com.briup.ch08;

import java.lang.String;

import java.util.*;

/**
 * @Author briup-adam
 * @Date 2023/10/17 上午8:07
 * @Description
 **/

public class CollectionsDemo {
    public static void main(String[] args) {
//        数组转List
        List<Integer> list = Arrays.asList(3, 31, 21, 212, 23, 42, 15);
        Integer max = Collections.max(list);
        System.out.println(max);
        Integer min = Collections.min(list);
        System.out.println(min);
        //集合排序
//        使用自然排序
        Collections.sort(list);
        System.out.println(list);
//        使用比较器排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1%2==0?-1:1;
            }
        });
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        //洗牌  打乱集合中元素顺序
        Collections.shuffle(list);
        System.out.println(list);
        //填充
        Collections.fill(list,30);
        System.out.println(list);
        ArrayList list1 = new ArrayList();
        //直接填充元素
        Collections.addAll(list1,45,1243,1233);
        System.out.println(list1);

    }
}
