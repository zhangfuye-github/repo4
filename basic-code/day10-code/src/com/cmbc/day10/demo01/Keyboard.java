package com.cmbc.day10.demo01;

public class Keyboard implements Usb {
    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }

    public void useKeyboard(){
        System.out.println("使用键盘");
    }
}
