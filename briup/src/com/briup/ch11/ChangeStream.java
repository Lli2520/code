package com.briup.ch11;

import java.lang.String;

import java.io.*;

/**
 * @Author briup-adam
 * @Date 2023/10/23 上午10:24
 * @Description
 **/

public class ChangeStream {
    public static void main(String[] args) {
        try {
            encodingDemo();
            changeRead();
            copy("01code/src/你的背包.txt", "01code/src/他的背包.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void encodingDemo() throws Exception {
        FileReader fr = null;
        BufferedReader br = null;

        fr = new FileReader("/Users/adam/code/idea-workspace/bttc-code/01code/src/你的背包.txt");
        br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        if (br != null)
            br.close();
        if (fr != null)
            fr.close();
    }

    static void changeRead() throws Exception {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        fis = new FileInputStream("01code/src/你的背包.txt");
        isr = new InputStreamReader(fis, "GBK");
        br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        if (br != null)
            br.close();
        if (isr != null)
            isr.close();
        if (fis != null)
            fis.close();

    }

    static void copy(String src, String dest) throws IOException {

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        fis = new FileInputStream(src);
        isr = new InputStreamReader(fis, "GBK");
        br = new BufferedReader(isr);

        fos = new FileOutputStream(dest);
        osw = new OutputStreamWriter(fos);
        bw = new BufferedWriter(osw);
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            if (br.ready())
                bw.newLine();
        }
        bw.flush();
        if (bw != null)
            bw.close();
        if (br != null)
            br.close();
        if (isr != null)
            isr.close();
        if (fis != null)
            fis.close();
        if (osw != null)
            osw.close();
        if (fos != null)
            fos.close();


    }


}
