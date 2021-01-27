package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/30
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
//执行顺序是：先执行循环体，循环变量加一，然后进行循环条件判断。
        }
    }
}
