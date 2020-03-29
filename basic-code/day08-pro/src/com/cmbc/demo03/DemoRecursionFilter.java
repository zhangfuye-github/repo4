package com.cmbc.demo03;

import java.io.File;
import java.io.FileFilter;

public class DemoRecursionFilter {
    public static void main(String[] args) {
        File file = new File("E:\\mianshi");
         printFileName(file);
    }
    private static void printFileName(File file) {
        File[] files = file.listFiles( pathname->pathname.isDirectory() ||pathname.getName().endsWith(".java"));
            for (File file1 : files) {
            if(file1.isDirectory()){
                printFileName(file1);
            } else {
                System.out.println(file1.getAbsolutePath());
            }
        }
/*        for (File file1 : files) {
            if(file1.isDirectory()){
                printFileName(file1);
            }else{
                String name = file1.getName();
                boolean b = name.endsWith(".docx");
                if(name.endsWith(".docx")){
                    System.out.println(file1.getAbsolutePath());
                }
            }
        }*/
    }
}
