package com.cmbc.day09.demo02;

public class StaMeth extends FatherInterfaceImpl {

/*
    此方法表明静态方法不能被重写
    @Override
    public static void method2(){

    }*/
final int b=123;//这是一个成员变量,有的时候加上static的原因是想通过类名直接调用
public static void main(String[] args) {
    FatherInterfaceImpl f = new FatherInterfaceImpl();
    //记住，私有方法只能在当前类中进行访问
    final int a=1;
    System.out.println(a);
    System.out.println(f.A);
//    a=2;一旦被final修饰就不能被从新赋值
//    static final int c=12;static 只能用在类当中，适合用在方法体当中。final修饰表示是一个最终
}
}
