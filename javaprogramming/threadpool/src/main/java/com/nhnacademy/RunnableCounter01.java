package com.nhnacademy;

import java.time.LocalTime;

public class RunnableCounter01 implements Runnable {
    int count = 0;
    String name;
    int max;
    Thread thread;

    public RunnableCounter01(ThreadGroup group, String name, int max) {
        thread = new Thread(group, this, name);
        this.max = max;
    }

    public Thread getThread() {
        return thread;
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
}
