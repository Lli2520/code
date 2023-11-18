package com.briup.xml;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.PrintWriter;

/**
 * 基于dom解析构建xml文档  并输出文件
 */
public class CreateDocument {
    public static void main(String[] args) {
        //构建工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //构建解析器对象
            DocumentBuilder builder = factory.newDocumentBuilder();
            //构建文档对象
            Document document = builder.newDocument();
            //通过文档兑现构建元素节点
            Element game = document.createElement("game");
            Element name = document.createElement("name");
            Element player1 = document.createElement("player1");
            Element player2 = document.createElement("player2");
            //构建属性节点
            Attr slogan = document.createAttribute("slogan");
            slogan.setValue("5v5 公平竞技");
            //构建注释节点
            Comment comment = document.createComment("王者荣耀于23年托管到第三方公司 不再由腾讯天美工作室运营");
            //构建文本节点
            Text nameText = document.createTextNode("王者荣耀");
            Text player1Text = document.createTextNode("谁动了闫昊的野猪");
            Text player2Text = document.createTextNode("王凯爱偷野猪");
            //组装各个节点
            player1.appendChild(player1Text);
            player2.appendChild(player2Text);
            name.appendChild(nameText);
            game.setAttributeNode(slogan);
            game.appendChild(comment);
            game.appendChild(name);
            game.appendChild(player1);
            game.appendChild(player2);
            //为document对象设置根节点
            document.appendChild(game);
            //输出xml
            //创建转换工厂
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            //获取转换器
            Transformer transformer = transformerFactory.newTransformer();
            //转换器设置转换属性
//            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            transformer.setOutputProperty("encoding", "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //将Docuemnt对象转换成xml文档
            transformer.transform(new DOMSource(document), new StreamResult(new PrintWriter("C:\\Users\\sxx\\IdeaProjects\\bttc-java-basic-code\\01code\\src\\com\\briup\\xml\\file\\game.xml")));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
