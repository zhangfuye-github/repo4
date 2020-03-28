package com.cmbc.day11.demo01;

public class Fu {
    final String name;

    public void method1(){
        System.out.println("父类的成员方法");
    }
    public final void  method2(){
        System.out.println("父类的最终成员方法");
    }

    public String getName() {
        return name;
    }

    public Fu() {
        this.name="张三";
    }

    /*    public static void method3(){
            System.out.println("父类的静态方法");
        }
     */

    public Fu(String name) {
        this.name = name;
    }
}
