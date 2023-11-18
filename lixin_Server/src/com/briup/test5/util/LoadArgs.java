package com.briup.test5.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ClassName : LoadArgs
 * Package : com.briup.test5.util
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/9 15:33
 * 从配置文件中加载参数
 * @Version : v1.0
 * E:\renjr_Server\config\config.properties
 */
public class LoadArgs {
    //properties对象
    private static Properties properties;

    static {
        //初始化properties对象
        properties = new Properties();
        try {
            //加载配置文件
            properties.load(new FileInputStream(new File("E:\\soft\\IDEA\\IntelliJ IDEA 2023.2.2\\code\\lixin_Server\\config\\mime.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取值
     *
     * @param key 键
     * @return {@link String}
     */
    public static String getValue(String key) {
        //获取value转换成String类型
        String value = (String) properties.get(key);
        //返回
        return value;
    }
}
