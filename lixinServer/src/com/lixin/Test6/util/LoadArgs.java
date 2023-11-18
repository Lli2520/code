package com.lixin.Test6.util;

import java.io.*;
import java.util.Properties;


public class LoadArgs {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("D:\\code\\idea_code\\xsyb_Server\\config\\mime.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key) {
        String value = (String) properties.get(key);
        return value;
    }

    public static void main(String[] args) {
        System.out.println(getValue("dcd"));
    }
}
