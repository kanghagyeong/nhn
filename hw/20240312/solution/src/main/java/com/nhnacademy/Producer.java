package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Store store;
    
    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        String[] items = {
            "First",
            "Second",
            "Third",
            "Fourth",
            "Fifth",
            "Sixth",
            "Seventh",
            "Eighth",
            "Ninth",
            "Tenth"
        };

       for (String item : items ) {
        store.sell(item);

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100,1000));
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
       }
    }
}
