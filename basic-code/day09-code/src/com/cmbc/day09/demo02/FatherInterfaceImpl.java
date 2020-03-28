package com.cmbc.day09.demo02;

public class FatherInterfaceImpl implements FatherInterface,FatherInterface1 {
    //当实现类实现的多个接口当中包含有同名默认方法时，需要实现类重写方法
    //当接口中包含有静态方法时，只能通过类名进行调用，不能通过实现类对象进行调用，
    //因为可能多个接口中可能存在重名的静态方法。static修饰的代码块，方法以及成员变量
    //都归类所拥有，那么静态方法可以重写吗？只能通过类名进行调用，因此不存在冲突
    //记住，static修饰的归类所有，不是对象特有，是共性。

    /*
    * 接口中存在的内容：
    * jdk1.7  常量，抽象方法
    * jdk1.8  默认方法（用于接口的升级） 静态方法
    * jdk9    私有方法，用来解决代码复用问题，分静态私有和非静态私有
    * */
/*
    此处表明java接口中的静态方法是不能被重写的。
    @Override
    public static void method2(){

    }*/
    public static void method2(){

    }
    /*
    * 私有的成员方法不能被重写
    *
    @Override
    private void method3(){

    }
    * */
    static final int A=1;
    private void method4(){
        System.out.println("实现类的私有成员方法");
    }
}
