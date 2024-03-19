package com.nhnacademy;

public class ThreadCounter extends Thread {
    int count = 0;
    String name;
    int max;

    public ThreadCounter(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && count < max) {
            count++;
            System.out.println(name + " : " +  count);

            try {
                Thread.sleep(1000);
               
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
}
