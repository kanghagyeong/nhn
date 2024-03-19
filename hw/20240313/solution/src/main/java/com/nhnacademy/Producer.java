package com.nhnacademy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Mart mart;

    List<Store> produceList;
    
    public Producer(String name, Mart mart) {
        this.mart = mart;
    }


    @Override
    public void run() {

        
        produceList = mart.getStoreList();
        for (Store store : produceList) {
            try {
                store.enter();
                store.sell();
                store.exit();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            
        }
        
    }
}
