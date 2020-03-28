package com.cmbc.demo01;

public class Test {
    public static void main(String[] args) {
        MyThread thre = new MyThread();
        thre.start();
        System.out.println(thre.getName());
        System.out.println(Thread.currentThread().getName());
    }
}
