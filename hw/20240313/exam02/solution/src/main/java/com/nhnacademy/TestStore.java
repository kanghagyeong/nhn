package com.nhnacademy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.concurrent.ScheduledExecutorService;
// import java.util.concurrent.TimeUnit;

public class TestStore {
    public static void main(String[] args) {
        Mart mart = new Mart();

        ExecutorService produce = Executors.newFixedThreadPool(3);
        ExecutorService consume = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++) {
            produce.submit(new Producer("Producer" + i, mart));
        }

        for (int i = 0; i < 100; i++) {
            consume.submit(new Consumer("Consumer" + i, mart));
        }

        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread Interrupted");
        }

        produce.shutdown();
        consume.shutdown();

        
        while (!produce.isTerminated() && (!consume.isTerminated())) {

        }

        

    // 5분뒤 종료 -> 스레드 풀을 5분 뒤 종료하는 방법으로 괜찮은건지..??
    //    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    //     scheduler.schedule(() -> {
    //         produce.shutdown();
    //         consume.shutdown();
    
    //     }, 5, TimeUnit.MINUTES);
        
    }
}
