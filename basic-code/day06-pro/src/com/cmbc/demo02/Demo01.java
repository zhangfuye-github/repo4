package com.cmbc.demo02;

public class Demo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();

        ticket.start();
        ticket1.start();
        ticket2.start();
    }
}
