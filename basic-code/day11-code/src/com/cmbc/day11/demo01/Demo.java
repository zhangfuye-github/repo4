package com.cmbc.day11.demo01;
/*
final关键字的四种用法：不能和abstract连用，矛盾。
    1.用来修饰类，表示最终类，该类不能被继承
    2.修饰成员方法，表示该方法不能被重写
    3.修饰局部变量，对于基本类型表示常量，一旦声明就必须初始化，不能二次赋值，作用于该方法中
    修饰引用类型时，其地址值不可以改变但是其变量的内容可以改变。
    4.修饰成员变量，成员变量有默认值，一旦用了final，就必须手动赋值，就不在有默认值。
    有两种赋值方式:1.直接手动赋值2.通过构造方法赋值，构造方法赋值的好处，
    每个对像的该成员变量可以有不同的内容
 */
public class Demo {
    public static void main(String[] args) {
        Fu fu = new Fu();
        System.out.println(fu.getName());
        System.out.println(fu.name);
        Fu fu1=new Fu("李四");
        System.out.println(fu1.name);
    }
}
