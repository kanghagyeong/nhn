package com.nhnacademy;

import java.util.List;

public class Consumer implements Runnable {
    Mart mart;
    String name;
    final int MAX_COUNT = 6;

    List<Store> consumerList;

    public Consumer(String name, Mart mart) {
        this.name = name;
        this.mart = mart;
    }

    @Override
    public void run() {

        consumerList = mart.getStoreList();
        for (Store store : consumerList) {
            try {
                store.enter();
                store.buy();
                store.exit();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }

    }

}
