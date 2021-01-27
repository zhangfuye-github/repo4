package com.cmbc.day07.demo1;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/1
 * @Description:
 */
public class StudentTest {
    public static void main(String[] args) {
//        作用域的体现：private 修饰的成员变量，只能在本类中进行访问
        Student student = new Student();
        student.age=18;
        Student student1 = new Student();
        System.out.println(student1.age);
    }
}
