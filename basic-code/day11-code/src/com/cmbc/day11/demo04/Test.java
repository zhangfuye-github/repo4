package com.cmbc.day11.demo04;

public class Test {
    public static void main(String[] args) {
        Fu fu=new Fu() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了接口");
            }
        };
        fu.method();
    }
}
