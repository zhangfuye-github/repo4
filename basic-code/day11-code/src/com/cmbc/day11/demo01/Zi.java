package com.cmbc.day11.demo01;

public class Zi extends Fu{
    @Override
    public void method1() {
        super.method1();
        System.out.println("子类重写成员方法");
    }
/*
    静态方法不能被重写
    @Override
    public static void method3(){

    }*/
}
