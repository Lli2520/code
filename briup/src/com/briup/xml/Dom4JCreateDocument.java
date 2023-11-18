package com.briup.xml;

import com.briup.ch07.Stu;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 使用 Dom4j 创建新文档
 */
public class Dom4JCreateDocument {
    public static void main(String[] args) {
        //使用帮助类构建文档对象
        Document document = DocumentHelper.createDocument();
        //也可以使用帮助类创建其他元素
        Element school = DocumentHelper.createElement("school");
        Element name = DocumentHelper.createElement("name");
        Comment comment = DocumentHelper.createComment("包头师范始建于2003年 前身是包头师范专科学院 简称包师专");
        Attribute code = DocumentHelper.createAttribute(school, "code", "54006");
        Text nameText = DocumentHelper.createText("包头师范学院");
        //设置school为根元素
        document.setRootElement(school);
        //关联元素
        school.add(comment);
        school.add(name);
        name.add(nameText);
        //使用元素本身 创建子元素并指定关联关系
        Element address = school.addElement("address");
        address.setText("内蒙包头市青山区自由路");
        Element students = school.addElement("students");
        List<Student> stus = Arrays.asList(
                new Student("211030052", "闫昊", 18)
                , new Student("211030053", "杨硕", 30)
                , new Student("211030054", "王凯", 22)
                , new Student("211030055", "阿木", 19)
                , new Student("211030056", "李丹", 18)
                , new Student("211030057", "李想", 18)
                , new Student("211030058", "郭琴", 18));
        for (Student student : stus) {
            Element studentNode = students.addElement("student");
            studentNode.addComment(student.toString());
            studentNode.addAttribute("id",student.getId());
            studentNode.addElement("name").setText(student.getName());
            studentNode.addElement("age").setText(String.valueOf(student.getAge()));
        }
        try {
            FileWriter fr = new FileWriter("C:\\Users\\sxx\\IdeaProjects\\bttc-java-basic-code\\01code\\src\\com\\briup\\xml\\file\\school.xml");
//            document.write(fr);
////            fr.close();
            //指定要包装的流 和输出的格式
            //优雅
//            XMLWriter xmlWriter = new XMLWriter(fr, OutputFormat.createPrettyPrint());
            XMLWriter xmlWriter = new XMLWriter(fr, OutputFormat.createCompactFormat());
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
