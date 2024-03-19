package com.nhnacademy;

public class SharedCount {
    static int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        synchronized(this) {
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            setCount(getCount() + 1);
        }
    }

    

    // public void increment() {
    //     // setCount(getCount() + 1);
    //     count++;
    // }


}
