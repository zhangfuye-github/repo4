package com.cmbc.day09.demo4;

import java.util.Scanner;

public class PrintHello {
    public static void main(String[] args) {
        System.out.println("请输入要打印的次数：");
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        printHello(i);
    }

    private static void printHello(Object b) {
        for (int i = 0; i < (int)b; i++) {
            System.out.println("hello");
        }
    }
}
