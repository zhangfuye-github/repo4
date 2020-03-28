package com.cmbc.day09.demo01;

public class Fu {
    private int a=200;

    public Fu(int a) {
        this.a = a;
        System.out.println("父类有参构造方法执行了");
    }

    public Fu() {
        System.out.println("父类无参构造方法执行了");
    }
}
