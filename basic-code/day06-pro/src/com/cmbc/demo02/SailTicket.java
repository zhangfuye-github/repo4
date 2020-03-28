package com.cmbc.demo02;

public class SailTicket implements Runnable {
    private int ticket=100;

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
