package com.cmbc.demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/29
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
        String s="你好，世界！！！Hello World！！！";
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes).length());
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
}
