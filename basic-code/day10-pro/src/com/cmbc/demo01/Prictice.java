package com.cmbc.demo01;

import java.io.*;
import java.util.function.DoubleToIntFunction;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/30
 * @Description:
 */
public class Prictice {
    public static void main(String[] args) throws IOException {
        FileInputStream fs = new FileInputStream("5.txt");
        InputStreamReader gbk = new InputStreamReader(fs, "gbk");
        FileOutputStream fo = new FileOutputStream("6.txt");
        OutputStreamWriter utf = new OutputStreamWriter(fo, "utf-8");
        int len;
        while ((len = gbk.read()) != -1) {
            utf.write(len);
        }
        gbk.close();
        utf.close();
    }
}
