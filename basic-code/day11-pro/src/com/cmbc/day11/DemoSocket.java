package com.cmbc.day11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:
 */
public class DemoSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        os.write("你好！socket".getBytes());
        InputStream inputStream = socket.getInputStream();
        int read;
        while ((read = inputStream.read()) != -1) {
            System.out.println(read);
        }
        os.close();
    }
}
