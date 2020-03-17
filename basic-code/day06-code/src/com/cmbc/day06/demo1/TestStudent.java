package com.cmbc.day06.demo1;
/*
注意java中的内存：分为
栈，      栈中存放的是java的局部变量，
堆，      存放new出来的东西，
方法区，    cunfangclass文件，方法，方法的执行是加载到栈中进行的，
局部变量和成员变量的区别：
    1.作用域
    2.生命周期
    3.有无默认初始化值
    4.在内存中年的位置
    5.定义的位置
构造方法：public 类名(object ...){}
    构造方法就是声明对象时用到的方法，分为无参构造和有参构造，可以进行重载
重载方法:
    就是方法名称相同，但是参数列表不一样
成员方法：
    就是类的行为属性，声明如下：public void method(){} 无static
    调用方式必须通过对象名.方法名()
一般方法的声明格式如下：
       public static void method(){}
加上static可以直接在该类中进行调用。否则需要创建该类的实例。
 */
public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println(student1);
        student1.setAge(17);
        student1.setName("张夫业");
        System.out.println(student1);
        Student stu = new Student("张三",78);
        System.out.println(stu);
//        TestStudent tstu = new TestStudent();
//        tstu.eat();
    }
    public static void eat(){
        String name ="张三";
        System.out.println(name+"is eating");
    }
}
