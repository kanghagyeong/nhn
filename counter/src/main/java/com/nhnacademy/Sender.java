package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private Data data;
    
    public Sender(Data data) {
        this.data = data;
    }
    public void run() {
        String packets[] = {
            "First Packet",
            "Second Packet",
            "Third Packet",
            "Forth Packet",
            "End"
        };
        
        for (String packet : packets) {
            data.send(packet);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
