package com.nhnacademy;

public class SharedCounter implements Runnable {
    SharedCount sharedCount;
    int count;
    int max;
    private Thread thread;

    public SharedCounter(String name, int max, SharedCount sharedCount) {
        //setName(name);
        this.max = max;
        this.sharedCount = sharedCount;
        count = 0;
        thread = new Thread(this);
    }

    public Thread getThread() {
        return thread;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (count < max) {
            count++;
            synchronized(sharedCount) {
                sharedCount.increment();
            }
            
        }
    }
}
