package com.cmbc.demo02;

public class Demo {
    public static void main(String[] args) {
        SailTicket t1 = new SailTicket();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }
}
