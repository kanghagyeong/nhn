package com.nhnacademy;

public class SharedCounter2 extends Thread {
    SharedCount sharedCount;
    int count;
    int max;

    public SharedCounter2(String name, int max, SharedCount sharedCount) {
        setName(name);
        this.max = max;
        this.sharedCount = sharedCount;
        count = 0;
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
