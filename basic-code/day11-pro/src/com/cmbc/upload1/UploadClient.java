package com.cmbc.upload1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:
 */
public class UploadClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\1.jpg");
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes=new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while((len = is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();
    }
}
