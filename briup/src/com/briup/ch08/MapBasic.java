package com.briup.ch08;

import java.lang.String;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author briup-adam
 * @Date 2023/10/16 下午2:57
 * @Description
 **/

public class MapBasic {
    public static void main(String[] args) {
        Map map=new HashMap();
        System.out.println(map.put("赵佳乐", "高博"));//null
        System.out.println(map.put("赵佳乐", "钱慧敏"));//高博
        System.out.println(map.size());//1
//        键不能重复  键重复 旧值换新值  返回旧值
        System.out.println(map);
        Map map1=new HashMap();
        map1.put("刘艺","赵益铎");
        map1.put("赵栋","果冻");
        map1.put("阿木","果干");
        map1.put("母志强","果树");
        map1.put("郭雅鑫","果皮");
        map1.put("闫昊","果渣");
        //将map1中的所有元素 添加到map
        map.putAll(map1);


        System.out.println(map.containsValue("果渣"));//true
        System.out.println(map.containsKey("赵佳乐"));//true
        //通过唯一key获取对应的value
        System.out.println(map.get("刘艺"));//赵益铎
        //获取所有的key  得到一个set集合
        Set set = map.keySet();
        System.out.println(set);
        //获取所有的value  得到一个Collection
        Collection collection = map.values();
        System.out.println(collection);
        System.out.println(collection.getClass());

        //获取map中所有的键值  然后打印
        Set entrySet = map.entrySet();
        for (Object o : entrySet) {
            System.out.println(o);
        }
        //map集合不能使用迭代器迭代 因为没有继承接口Iterable
        //先获取map中所有的key  根据key去取value
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Object value = map.get(key);
            System.out.println("key:"+key+",value:"+value);
        }

        for (Object o : entrySet) {
            Map.Entry entry= (Map.Entry) o;
            System.out.println("key:"+entry.getKey()+"，value:"+entry.getValue());
        }

    }
}
