package com.briup.ch08;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author briup-adam
 * @Date 2023/10/17 上午10:16
 * @Description
 **/

public class MapForWordPrint {
    static String s="1.两岸猿声啼不住,3.轻舟已过万重山,4.天生我材必有用,2.千金散尽还复来,5.白云千载空悠悠,7.芳草萋萋鹦鹉洲,6.烟花三月下扬州";
    //字符串 分割一句一句的句子  eg: 2.千金散尽还复来
    //字符分割成序号与诗句     eg:  [2,千金散尽还复来]
    //将序号与 诗句存入Map
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        //字符串 分割一句一句的句子  eg: 2.千金散尽还复来
        String[] words = s.split("[,]");
        //遍历所有的分割好的句子
        for (String word : words) {
            //字符分割成序号与诗句 eg:[2,千金散尽还复来]
            String[] numAndWord = word.split("[.]");
            //将分割之后的序号与古诗放入集合
            Integer key = Integer.valueOf(numAndWord[0]);
            String value = numAndWord[1];
            map.put(key,value);
        }
        //遍历map
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }

    }


}
