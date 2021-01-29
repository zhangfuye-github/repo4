package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/16
 * @Description:
 */
public class Demo02 {
    public static void main(String[] args) {
        int a=100;
        method(a);
        System.out.println(a);//该方法表示java中的参数传递都是值传递。那么java中如何实现改变值呢、
    }

    private static int method(int a) {
        a=10;
        return a;
    }
}
