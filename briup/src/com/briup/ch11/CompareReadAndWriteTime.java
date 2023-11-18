package com.briup.ch11;

import java.lang.String;

import java.io.*;

/**
 * @Author briup-adam
 * @Date 2023/10/23 上午8:13
 * @Description 拷贝一份文件对于使用缓冲流和普同节点的耗时对比
 **/

public class CompareReadAndWriteTime {
    public static void nodeStream(String src, String dest) throws Exception {
        long start = System.currentTimeMillis();
//       声明流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        fis = new FileInputStream(src);
        fos = new FileOutputStream(dest);
        int len = 0;
        byte[] b = new byte[8];
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        fos.flush();

        if (fis != null)
            fis.close();
        if (fos != null)
            fos.close();
        long end = System.currentTimeMillis();

        System.out.println("节点流耗费时间" + (end - start));
    }

    public static void bufferedStream(String src, String dest) throws Exception {
        long satrt = System.currentTimeMillis();
        //声明
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        fis = new FileInputStream(src);
        fos = new FileOutputStream(dest);

        bis = new BufferedInputStream(fis);
        bos = new BufferedOutputStream(fos);
        int len = 0;
        byte[] b = new byte[8];
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        bos.flush();

        if (bis != null)
            bis.close();
        if (bos != null)
            bos.close();
        if (fis != null)
            fis.close();
        if (fos != null)
            fos.close();
        long end = System.currentTimeMillis();
        System.out.println("包装流耗时" + (end - satrt));
    }

    public static void main(String[] args) {
        try {
            nodeStream("01code/src/十年.txt", "10-23.txt");
            bufferedStream("01code/src/十年.txt", "10-23.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
