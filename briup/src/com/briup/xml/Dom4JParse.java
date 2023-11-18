package com.briup.xml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * 使用Dom4j 解析xml
 */
public class Dom4JParse {
    public static void main(String[] args) {
        //获取解析器对象
        SAXReader reader = new SAXReader();
        try {
            //开始解析
            Document document = reader.read("C:\\Users\\sxx\\IdeaProjects\\bttc-java-basic-code\\01code\\src\\com\\briup\\xml\\file\\class.xml");
            //获取根节点
            Element root = document.getRootElement();
            //获取根节点的子节点
            Iterator<Element> iterator = root.elementIterator();
            //迭代所有子元素
            while (iterator.hasNext()) {
                Element element = iterator.next();
                System.out.println(element.getName());
            }
            //fori
            for (int i = 0; i < root.nodeCount(); i++) {
                Node node = root.node(i);
                System.out.println(node.getName());
            }
            //获取指定名字的子元素
            List<Element> stus = root.elements("stu");
            stus.stream()
                    .map(i -> {
                        //根据属性名获取指定的属性节点
                        Attribute idNode = i.attribute("id");
                        //获取属性节点的值
                        String id = idNode.getValue();
                        //获取指定子元素
                        Element nameNode = i.element("name");
                        //获取元素的文本内容
                        String name = nameNode.getTextTrim();
                        int age = Integer.parseInt(i.element("age").getTextTrim());
                        return new Student(id, name, age);
                    }).forEach(System.out::println);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
