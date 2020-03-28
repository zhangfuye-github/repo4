package com.cmbc.day10.demo01;
/*
这是一个多态的实例，注意向上转换，向下转换，instanceof函数，以及接口的实现
 */
public class Demo01 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.open();
        Mouse mouse = new Mouse();
        computer.useDeviece(mouse);
        Keyboard keyboard = new Keyboard();
        computer.useDeviece(keyboard);
        computer.close();
    }
}
