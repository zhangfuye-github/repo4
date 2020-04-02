package com.cmbc.demo01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/29
 * @Description:通过字节输入输出流对文件进行复制。
 */
public class FileCopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fio = new FileInputStream("D:\\BaiduNetdiskDownload\\java进阶\\day09_字节流、字符流\\课件资料\\img\\2_copy.jpg");
        FileOutputStream fos=new FileOutputStream("1.jpg");
        int i;
        while( (i = fio.read())!=-1){
            fos.write(i);
        }
        fio.close();
        fos.close();
    }
}
