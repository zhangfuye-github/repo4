package com.cmbc.demo02;

public class Ticket extends Thread{
    private int ticket=20;

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"is sell " +ticket);
                ticket--;
            }
        }
    }
}
