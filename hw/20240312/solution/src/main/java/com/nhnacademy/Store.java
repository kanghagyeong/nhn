package com.nhnacademy;

import java.util.List;
import java.util.ArrayList;

public class Store {

    public int visitor;
  
    List<String> items = new ArrayList<>();

    public int getVisior() {
        return visitor;
    }
    public void enter() {
        visitor++;
        System.out.println("입장");
    }

    public void exit() {
        System.out.println("퇴장");
        visitor--;
    }

    public synchronized void buy() {
        while (items.size() <= 0) {
            try {
                wait();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        
        String item = items.get((int)Math.random() * 9);
        System.out.println(item  + "구매했습니다");
        items.remove(item);

        notifyAll();

    }
    
    public synchronized void sell(String item) {
        while (items.size() > 10) {
            try {
                wait();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        items.add(item);
        System.out.println(item + "납품받았습니다.");

        notifyAll();

    }
}
