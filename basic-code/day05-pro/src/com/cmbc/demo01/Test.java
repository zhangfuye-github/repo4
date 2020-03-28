package com.cmbc.demo01;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

/*
    开辟新线程并使用新线程：
        1.首先继承thread类
        2.重写run方法
        3.创建子类对象
        4.调用start方法,就会默认执行子类当中重写的run方法
        5.线程一旦结束，就不能再次被调用。
        6.使用一个.start方法就对开辟一个新的栈内存空间。
 */
public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main"+i);
        }
    }
}
