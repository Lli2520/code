package com.briup.xml;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

/**
 * java se  提供的对xml文档进行dom document object  model解析
 */
public class DomParse {
    public static void main(String[] args) {
        //构建集合
        ArrayList<Student> list = new ArrayList<>();
        //构建 工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //通过工厂构建解析器对象
            DocumentBuilder builder = factory.newDocumentBuilder();
            //通过解析器 解析 xml文档  创建出 document对象
            Document document = builder.parse("C:\\Users\\sxx\\IdeaProjects\\bttc-java-basic-code\\01code\\src\\com\\briup\\xml\\file\\class.xml");
            //获取文档的根元素
            Element root = document.getDocumentElement();
//            System.out.println(root);
            //获取根节点的子节点 通过标签名获取
            NodeList stuNodeList = root.getElementsByTagName("stu");
            //遍历所有的子节点
            for (int i = 0; i < stuNodeList.getLength(); i++) {
                //获取子节点
                Node stuNode = stuNodeList.item(i);
//                System.out.println(stuNode);
                //获取stu节点的属性节点
                NamedNodeMap attributes = stuNode.getAttributes();
                //获取到名字叫id的属性节点
                Node idAtt = attributes.getNamedItem("id");
//              idAtt=  attributes.item(0);
                //获取属性值
                String id = idAtt.getNodeValue();
                //获取Stu的所有子节点
                NodeList childNodes = stuNode.getChildNodes();
                String name = "";
                int age = 0;
                //遍历stu的子节点
                for (int j = 0; j < childNodes.getLength(); j++) {
                    //获取其中子节点
                    Node node = childNodes.item(j);
                    String nodeName = node.getNodeName();
                    switch (nodeName) {
                        case "name":
                            //获取节点的文本内容
                            name = node.getTextContent();
                            break;
                        case "age":
                            age = Integer.parseInt(node.getTextContent());
                            break;
                    }
                }
                Student student = new Student(id, name, age);
                list.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            list.forEach(i -> System.out.println(i));
//            list.forEach(System.out::println);
        }
    }
}
