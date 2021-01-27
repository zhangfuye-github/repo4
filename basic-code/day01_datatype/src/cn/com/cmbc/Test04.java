package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/29
 * @Description:
 */
public class Test04 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int x = a + b++;
        System.out.println("b=" + b);//21
        System.out.println("x=" + x);//30
    }
}
