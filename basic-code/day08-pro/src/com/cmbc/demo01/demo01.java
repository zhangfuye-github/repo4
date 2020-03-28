package com.cmbc.demo01;

import com.sun.deploy.cache.CachedJarFile14;

import java.io.File;
import java.io.IOException;

public class demo01 {
    public static void main(String[] args) throws IOException {
//        System.out.println();
        File file = new File("1.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.getAbsolutePath());
        boolean b = file.delete();
        System.out.println(b);
        File file4 = new File("456");
        boolean b1 = file4.delete();
        System.out.println(b1);
/*//        File file1 = new File(".\\123\\1.txt");
//        if (!file1.exists()){
//            file1.createNewFile();
//        }
//        System.out.println(file1.getAbsolutePath());
        File file1 = new File("");
        System.out.println(file1.getAbsolutePath());
        File file2 = new File(file1+"21.txt");
        if (!file2.exists()){
            file2.createNewFile();
        }
        System.out.println(file1.getAbsolutePath());
        File file3 = new File("..\123.txt");
        if (!file3.exists()){
            file3.createNewFile();
        }
        System.out.println(file3.getAbsolutePath());
        file3.delete();
        file2.delete();
        File file4 = new File("\\123\\234");
        file4.mkdirs();
        File file5= new File("456\\234");
        file5.mkdirs();*/
    }
}
