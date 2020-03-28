package com.cmbc.day07;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("zfy");
//        file.delete();
        file.mkdir();
        file.mkdirs();
        File file1 = new File("zfy.txt");
        System.out.println("AbsolutePath"+file1.getAbsolutePath());
        System.out.println("Name"+file1.getName());
        System.out.println("Path"+file1.getPath());
        System.out.println("CanonicalPath"+file1.getCanonicalPath());
        System.out.println("Parent"+file1.getParent());

        System.out.println(file.getAbsolutePath());
    }
}
