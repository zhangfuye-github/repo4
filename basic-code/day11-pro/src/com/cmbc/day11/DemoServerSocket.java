package com.cmbc.day11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:
 */
public class DemoServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println(new String(bytes));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(123);
        socket.close();

    }
}
