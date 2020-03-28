package com.cmbc.day10.demo01;
/*
* 该案例用来实现电脑接口
* */
public class Computer {
    public void open(){
        System.out.println("电脑开机");
    }
    public void close(){
        System.out.println("电脑关机");
    }
    public void useDeviece(Usb usb){
        usb.open();
        if(usb instanceof Mouse){
            ((Mouse) usb).useMouse();
        }else if(usb instanceof Keyboard){
            ((Keyboard) usb).useKeyboard();
        }
        usb.close();
    }
}
