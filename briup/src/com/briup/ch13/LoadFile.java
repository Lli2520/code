package com.briup.ch13;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午3:44
 * @Description
 **/

public class LoadFile {
    public static void main(String[] args) {
        InputStream stream = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        Properties p = new Properties();
        try {
            p.load(stream);

            Set<Map.Entry<Object, Object>> entries = p.entrySet();
            for (Map.Entry<Object, Object> entry : entries) {
                System.out.println(entry.getKey() + "--------" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
