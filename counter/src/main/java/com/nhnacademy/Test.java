package com.nhnacademy;

import java.time.LocalTime;

public class Test {
    public static void main(String[] args) throws InterruptedException {
    //     LocalTime now = LocalTime.now();
    //    ThreadCounter counter1 = new ThreadCounter("counter1", 10);
    //    ThreadCounter counter2 = new ThreadCounter("counter2", 10);

    //     System.out.println("start : " + LocalTime.now());
    //     counter1.start();
    //     counter2.start();

    //     while (counter1.isAlive() || counter2.isAlive()) ; 

    //     System.out.println("end : " + LocalTime.now());


    // SharedCount sharedCount = new SharedCount();
    // SharedCounter counter1 = new SharedCounter("counter1", 10000, sharedCount);
    // SharedCounter counter2 = new SharedCounter("counter2", 10000, sharedCount);

    // counter1.start();
    // counter2.start();
    // System.out.println(counter1.getName() + " : started");
    // System.out.println(counter2.getName() + " : started");

    // counter1.join();
    // counter2.join();
    // System.out.println(counter1.getName() + " : terminated");
    // System.out.println(counter2.getName() + " : terminated");

    // System.out.println("SharedCount : " + sharedCount.getCount());
    // }

    
    Data data = new Data();
    Thread sender = new Thread(new Sender(data));
    Thread receiver = new Thread(new Receiver(data));

    sender.start();
    receiver.start();
}
}
