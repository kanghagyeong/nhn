package com.nhnacademy;

public class Exam03 {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group");
        
        RunnableCounter01 thread1 = new RunnableCounter01(group,"worker1", 100);
        RunnableCounter01 thread2 = new RunnableCounter01(group, "worker2", 100);

        thread1.start();
        thread2.start();

        Thread.sleep(5000);
        group.interrupt();
    }
}
