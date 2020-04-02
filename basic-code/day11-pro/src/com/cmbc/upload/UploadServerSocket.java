package com.cmbc.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:
 */
public class UploadServerSocket {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\uplaod");
        if (!file.exists()) {
           file.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file + "\\1.jpg");
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();

        socket.getOutputStream().write("上传成功".getBytes());
        socket.shutdownOutput();
        socket.close();
    }
}
