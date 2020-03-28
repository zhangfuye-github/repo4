package com.cmbc.day09.demo2;
/*
* 方法的定义格式：public static void 方法名(){
* }
*
* */
public class MethodEx {
    public static void main(String[] args) {
        printMethod();
    }
    public static void printMethod(){
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 20; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
