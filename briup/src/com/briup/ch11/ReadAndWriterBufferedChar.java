package com.briup.ch11;

import java.lang.String;

import java.io.*;

/**
 * @Author briup-adam
 * @Date 2023/10/23 上午8:42
 * @Description
 * @see FileReader
 * @see FileWriter
 * @see BufferedReader
 * @see BufferedWriter
 **/

public class ReadAndWriterBufferedChar {
    public static void copy(String src, String dest) throws Exception {
        //声明
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        fr = new FileReader(src);
        fw = new FileWriter(dest);
        br = new BufferedReader(fr);
        bw = new BufferedWriter(fw);
//        int len=0;
//        char [] c=new  char[8];
//        while ((len=br.read(c))!=-1){
//            bw.write(c,0,len);
//        }

        //使用读一行  BufferedReader 特有方法 读一行
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            //ready() 判断当前行是否为最后一行
            if (br.ready())
                //写回车换行符 是BufferedWriter 特有的方法
                bw.newLine();


        }

        bw.flush();

        if (br != null)
            br.close();
        if (bw != null)
            bw.close();
        if (fr != null)
            fr.close();
        if (fw != null)
            fw.close();
    }

    public static void main(String[] args) {
        try {
            copy("01code/src/十年.txt", "10-23.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
