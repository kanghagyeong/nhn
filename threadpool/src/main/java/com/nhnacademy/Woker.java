package com.nhnacademy;

public class Woker implements Runnable {
    String name;

    public Woker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        System.out.println(getName() + "started " + Thread.currentThread().getName());
        try {
            Thread.sleep(1999);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println(getName() + "finished ");
    }
}
