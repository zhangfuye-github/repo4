package com.cmbc.demo03;
/*
3.7 练习：使用Lambda标准格式（无参无返回）
题目
给定一个厨子Cook 接口，内含唯一的抽象方法makeFood ，且无参数、无返回值。如下：
在下面的代码中，请使用Lambda的标准格式调用invokeCook 方法，打印输出“吃饭啦！”字样：
解答
备注：小括号代表Cook 接口makeFood 抽象方法的参数为空，大括号代表makeFood 的方法体。
3.8 Lambda的参数和返回值
下面举例演示java.util.Comparator<T> 接口的使用场景代码，其中的抽象方法定义为：
public abstract int compare(T o1, T o2);
当需要对一个对象数组进行排序时， Arrays.sort 方法需要一个Comparator 接口实例来指定排序的规则。假设有
一个Person 类，含有String name 和int age 两个成员变量：
public interface Cook {
void makeFood();
}
public class Demo05InvokeCook {
public static void main(String[] args) {
// TODO 请在此使用Lambda【标准格式】调用invokeCook方法
}
private static void invokeCook(Cook cook) {
cook.makeFood();
}
}
 */
public class Test2 {
    public static void main(String[] args) {
        invokeCook(()->{
            System.out.println("吃饭啦");//此处相当于，重写了Cook接口当中的makeFood方法。
        });
    }

    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
