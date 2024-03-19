package com.nhnacademy;

import java.time.LocalTime;

public class RunnableCounter implements Runnable {
    int count = 0;
    String name;
    int max;
    Thread thread;

    public RunnableCounter(String name, int max) {
        this.name = name;
        this.max = max;
        thread = new Thread(this, name);
    }

    public Thread getThread() {
        return thread;
        // Thread.currentThread().interrupt(); // 안 돼 ~ 메인을 멈추는 것이라고 함 ,,,
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public int getCount() {
        return count;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted() && count < max) {
            ++count;
            System.out.println(name + " : " + count);
            
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println(name + " : interrupted ");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        RunnableCounter[] counters = new RunnableCounter[10];
        //RunnableCounter counter1 = new RunnableCounter("counter1", 10);
        //RunnableCounter counter2 = new RunnableCounter("counter2", 10);

        for (int i = 0; i < 10; i++) {
            counters[i] = new RunnableCounter("counter" + (i + 1), 10);

            counters[i].getThread().start();
        }

        boolean allStopped = false;
        while (!allStopped) {
            if (counters[0].getCount() > 5) {
                for (int i = 0; i < counters.length; i++) {
                    //counters[i].getThread().interrupt();  //???????????????
                    counters[i].stop();
                }
            }

            allStopped = true;
            for (int i = 0; i < counters.length; i++) {
                if (counters[i].isAlive() ) {
                    allStopped = false;
                }
            }
        }

        // RunnableCounter [] counters = new RunnableCounter[10];
        // Thread[] threads = new Thread[10];

        // for (int i = 0; i < 10; i++) {
        // RunnableCounter counter = new RunnableCounter("counter" + (i + i), 10);

        // threads[i] = new Thread(counters[i]);
        // threads[i].start();
        // }

        // while (true) {
        // boolean allStopped = true;

        // for (int i = 0; i < threads.length; i++) {
        // if (threads[i].isAlive()) {
        // allStopped = false;
        // }
        // }
        // }
        // LocalTime now = LocalTime.now();
        // RunnableCounter counter1 = new RunnableCounter("counter1", 10);
        // RunnableCounter counter2 = new RunnableCounter("counter2", 10);
        // Thread thread1 = new Thread(counter1);
        // Thread thread2 = new Thread(counter2);

        // System.out.println("start : " + LocalTime.now());
        // thread1.start();
        // thread2.start();
        // while (thread1.isAlive() || thread2.isAlive()) {
        // if ((counter1.getCount() > 5) && (counter2.getCount() >5)) {
        // thread1.interrupt();
        // thread2.interrupt();
        // }
        // } ;

        System.out.println("end : " + LocalTime.now());
    }

}
