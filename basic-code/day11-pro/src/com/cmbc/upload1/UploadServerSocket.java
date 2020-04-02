package com.cmbc.upload1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import static java.lang.Math.random;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:
 */
public class UploadServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        File file = new File("d:\\uplaod");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String name;
                        name=""+System.currentTimeMillis()+new Random().nextInt(1000);
                        FileOutputStream fileOutputStream = new FileOutputStream(file + "\\"+name+".jpg");
                        InputStream inputStream = socket.getInputStream();
                        byte[] bytes=new byte[1024];
                        int len;
                        while ((len = inputStream.read(bytes)) != -1) {
                            fileOutputStream.write(bytes,0,len);
                        }
                        fileOutputStream.close();
                        socket.getOutputStream().write("上传成功".getBytes());
                        socket.shutdownOutput();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
