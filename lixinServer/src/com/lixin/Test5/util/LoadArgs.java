package com.lixin.Test5.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ClassName:LoadArgs
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/9/009 15:20
 * @Version 1.0
 */
public class LoadArgs {
    //配置
    private static Properties properties;
    private static String configPath = "E:\\soft\\IDEA\\IntelliJ IDEA 2023.2.2\\code\\lixinServer\\config\\config.properties";


    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(configPath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key) {
        String value = (String) properties.get(key);
        return value;
    }
}