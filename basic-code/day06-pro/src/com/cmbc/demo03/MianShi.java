package com.cmbc.demo03;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/7
 * @Description:
 */
public class MianShi extends Thread{
    public static void main(String[] args) {
        MianShi st=new MianShi();
        st.start();
    }
    public void run(){
        try{
            for (int i=1;i<5;i++){
                System.out.println(i+" ");
                if(i>2){
                    this.interrupt();
                }
                sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("caught");
        }
    }
}
