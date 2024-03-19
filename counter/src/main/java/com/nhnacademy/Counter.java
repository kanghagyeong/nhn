package com.nhnacademy;

public class Counter {
    int count = 0;
    String name;
    int max;

    public Counter(String name, int max) {
        this.name = name;
        this.max = max;
    }

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
