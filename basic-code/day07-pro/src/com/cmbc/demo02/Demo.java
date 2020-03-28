package com.cmbc.demo02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new RunableImp());//这就是代表开启了一个新线程，传递一个线程对象
        executorService.submit(new RunableImp());
        executorService.submit(new RunableImp());
        executorService.submit(new RunableImp());
        executorService.submit(new RunableImp());
        executorService.submit(new RunableImp());
        executorService.submit(new RunableImp());
        executorService.submit(new RunableImp());
        executorService.submit(new RunableImp());
        executorService.submit(new RunableImp());
    }
}
