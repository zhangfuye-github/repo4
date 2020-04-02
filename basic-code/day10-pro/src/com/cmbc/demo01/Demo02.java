package com.cmbc.demo01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/29
 * @Description:
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        //出现乱码问题的原因是因为编码和解码使用的字符集不一样，要想解决乱码问题，要使用转换流。
        BufferedReader bufferedReader = new BufferedReader(new FileReader("5.txt"));
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
