package com.briup.test7.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ClassName : LoadArgs
 * Package : com.briup.test7.util
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/13 21:18
 * @Version : v1.0
 */
public class LoadArgs {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("E:\\soft\\IDEA\\IntelliJ IDEA 2023.2.2\\code\\lixin_Server\\config\\mime.properties")));
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
