package com.cmbc.demo01;

import java.io.*;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/29
 * @Description:
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        //出现乱码问题的原因是因为编码和解码使用的字符集不一样，要想解决乱码问题，要使用转换流。
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("5.txt"));
        FileInputStream fileInputStream = new FileInputStream("5.txt");
        InputStreamReader bufferedReader = new InputStreamReader(fileInputStream,"GBk");
        int read = bufferedReader.read();
        System.out.println((char)(read));
        read = bufferedReader.read();
        System.out.println((char)(read));
        read = bufferedReader.read();
        System.out.println((char)(read));
        read = bufferedReader.read();
        System.out.println((char)(read));
        read = bufferedReader.read();
        System.out.println((char)(read));
        bufferedReader.close();
    }
}
