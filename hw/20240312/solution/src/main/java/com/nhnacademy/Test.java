package com.nhnacademy;

public class Test {

    public static void main(String[] args) {

        Store store = new Store();

        Thread producer = new Thread(new Producer(store));
        producer.start();

        Thread[] consumers = new Thread[5];
        for (int i = 0; i < consumers.length; i++) {
            String visitor = "visitor" + (i + 1);
            consumers[i] = new Thread(new Consumer(visitor, store));
            consumers[i].start();


        }

    }
}
