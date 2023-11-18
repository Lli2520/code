package com.briup.ch11;

import java.lang.String;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author briup-adam
 * @Date 2023/10/19 下午5:14
 * @Description
 **/

public class ReadAndWriteCharFile {
    public static void main(String[] args) {
//        copy("01code/src/十年.txt","01code/src/红玫瑰.txt");
        copy("01code/src/1.jpg","01code/src/2.jpg");
    }
    public  static void  copy(String src,String dest){
        //声明
        FileReader fr=null;
        FileWriter fw=null;

        try {
            fr=new FileReader(src);
            fw=new FileWriter(dest);
            int len=0;
            char c[] =new char[1024];
            while((len=fr.read(c))!=-1){
                fw.write(c,0,len);
            }
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
