package com.cmbc.day13.demo02;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/2
 * @Description:
 */
public class TestDemo {
    public static void method(PrintInter printInter){
        printInter.printl("hello");
    }

    public static void main(String[] args) {
        ReverseBig big = new ReverseBig();
        method(big::toUpperCase1);
//        method(s ->big.toUpperCase1(s));
    }
}
