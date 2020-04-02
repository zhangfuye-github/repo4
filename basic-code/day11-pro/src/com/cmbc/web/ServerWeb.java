package com.cmbc.web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:
 */
public class ServerWeb {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        InputStream inputStream = socket.getInputStream();
                        /*        byte[] bytes=new byte[1024];
                                while (inputStream.read(bytes) != -1) {
                                    System.out.println(new String(bytes));
                                }
                                */
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        String s = reader.readLine();
                        String[] s1 = s.split(" ");
                        String s2 = s1[1].substring(1);
                        System.out.println(s2);
                        OutputStream outputStream = socket.getOutputStream();
                        // 写入HTTP协议响应头,固定写法
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content-Type:text/html\r\n".getBytes());
                        // 必须要写入空行,否则浏览器不解析
                        outputStream.write("\r\n".getBytes());

                        if (!"favicon.ico".equals(s2)) {
                            FileInputStream fileInputStream = new FileInputStream(s2);
                            byte[] bytes = new byte[1024];
                            int len;
                            while ((len = fileInputStream.read(bytes)) != -1) {
                                outputStream.write(bytes);
                            }
                            fileInputStream.close();
                        }
                        reader.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
//        server.close();
    }
}
