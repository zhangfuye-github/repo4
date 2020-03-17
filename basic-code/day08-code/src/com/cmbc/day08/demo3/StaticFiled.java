package com.cmbc.day08.demo3;
/*
static 关键字修饰的变量和方法属于类，不在属于对象，多个实例公用一个数据。
static修饰成员变量和成员方法都可以通过对象名.成员来调用，但是不推荐，推荐使用类名
直接调用。
static可以用来修饰变量，方法和代码块。代码修饰代码块，只在类加载的时候执行一次。
类加载时先执行代码块，在执行构造方法。静态方法不能访问非静态的变量，因为后人知道先人，
先人不知道后人，静态方法不能使用this关键字。
 */
public class StaticFiled {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(15);
        student.setName("张夫业");
        student.cla="123";
        Student student1 = new Student("张三",45);
        Student student2 = new Student();
        System.out.println(student2.cla);

        System.out.println(student.getName()+"  "+student.getAge()+"  "+
                student.getId()+"  "+student.cla);
        System.out.println(student1.getName()+"  "+student1.getAge()+"  "+
                student1.getId()+"  "+student1.cla);
        System.out.println(student2.getName()+"  "+student2.getAge()+"  "+
                student2.getId()+"  "+student2.cla);
        System.out.println(Student.cla);
    }
}
