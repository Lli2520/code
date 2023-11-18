package com.briup.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * java  se提供的sax解析
 */
public class SaxParse {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse("C:\\Users\\sxx\\IdeaProjects\\bttc-java-basic-code\\01code\\src\\com\\briup\\xml\\file\\class.xml", new DefaultHandler() {
                @Override
                public void startDocument() throws SAXException {
                    System.out.println("开始标签");
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("结束标签");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    StringBuilder sb = new StringBuilder("\t" + qName);
                    if (attributes.getLength() > 0) {
                        sb.append("[");
                        for (int i = 0; i < attributes.getLength(); i++) {
                            String name = attributes.getLocalName(i);
                            String value = attributes.getValue(i);
                            sb.append(name+":"+value+",");
                        }
                        sb= new StringBuilder(sb.substring(0, sb.length() - 1));
                        sb.append("]") ;
                    }
                    System.out.println(sb);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("\t" + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String string = new String(ch, start, length);
                    //判断文件内容是否有值
                    String trim = string.trim();
                    if (trim.length() > 1) System.out.println("\t\t" + trim);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
