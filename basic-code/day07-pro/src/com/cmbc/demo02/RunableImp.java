package com.cmbc.demo02;

public class RunableImp implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
