package com.cmbc.demo01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/29
 * @Description:
 */
public class FileCopyByteArr {
    public static void main(String[] args) throws IOException {
        FileInputStream fio = new FileInputStream("D:\\BaiduNetdiskDownload\\java进阶\\day09_字节流、字符流\\课件资料\\img\\2_copy.jpg");
        FileOutputStream fos=new FileOutputStream("2.jpg");
        byte[] arr=new byte[1024];
        int len;
        while ((len=fio.read(arr)) != -1) {
            fos.write(arr);
        }
        fio.close();
        fos.close();
    }
}
