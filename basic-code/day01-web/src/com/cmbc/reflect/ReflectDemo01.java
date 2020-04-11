package com.cmbc.reflect;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/5
 * @Description:
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一：通过静态方法进行生成字节码文件
        Class<Person> aClass;
        aClass = (Class<Person>) Class.forName("com.cmbc.reflect.Person");
        System.out.println(aClass);
        //方式二：已经通过类加载器将字节码文件加载到内当中，通过类名.class属性，进行获取字节码文件
        Class<Person> personClass = Person.class;//通过该方法获取到的字节码文件，知道泛型类型
        System.out.println(personClass);
        //方式三：通过类的对象，获取获取类的字节码对象。
        Person person = new Person();
        Class<? extends Person> aClass1 = person.getClass();
        System.out.println(aClass1);

        System.out.println(aClass == aClass1);
/*        通过此处可以说明，程序在运行过程中，字节码文件只会加载到内存
         中一次，不同的对象，指向同一内存地址。该对象在堆内存当中。*/
        System.out.println(personClass == aClass);

    }
}
