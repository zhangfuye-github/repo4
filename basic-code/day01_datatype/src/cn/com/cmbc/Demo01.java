package cn.com.cmbc;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/29
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        byte b1=3,b2=4,b;
        b=b1++;
        System.out.println(b);
//        b=b1+1;
//        b=(byte)(b1+b2) ;//变量参与运算会先把数据类型进行转换成int类型，在进行计算，因此改行报错。
////        b=3+4;
//        b1+=1;
//        b+=b1++;
    }
}
