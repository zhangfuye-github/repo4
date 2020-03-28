package com.cmbc.day09.demo02;

public interface FatherInterface1 {
    final int A=1;
    public default void method(){
        System.out.println("FatherInterface1");
    }
    public static void method2(){
        System.out.println("接口中的静态方法method2");
    }
}
