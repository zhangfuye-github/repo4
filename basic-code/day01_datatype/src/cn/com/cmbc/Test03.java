package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/29
 * @Description:
 */
public class Test03 {
    public static void main(String[] args) {
        int x = 4;
        int y = (--x)+(--x)+(x*10);
        int a = --x;
        System.out.println("x = " + x + ",y = " + y);//1,25
    }
}
