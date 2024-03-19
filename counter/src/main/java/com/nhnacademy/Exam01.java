package com.nhnacademy;

public class Exam01 {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 5, sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2", 5, sharedCount);

        // Thread thread = new Thread(() -> {
        // long count = 0;
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // Thread.currentThread().interrupt();
        // }
        // });
        counter1.start();
        counter2.start();

        //System.out.println(thread.getState());

        Thread.State state1 = counter1.getThread().getState();
        Thread.State state2 = counter2.getThread().getState();
        System.out.println("T1 : " + state1 + ", T2 : " + state2);

        while (counter1.getThread().isAlive() || counter2.getThread().isAlive()) {
            if ((counter1.getThread().getState() != state1) ||
                    (counter2.getThread().getState() != state2)) {
                state1 = counter1.getThread().getState();
                state2 = counter2.getThread().getState();
                System.out.println("T1 : " + state1 + ", T2 : " + state2);
            }
            Thread.sleep(100);
        }

        // thread.start();

        // while (thread.isAlive()){
        // System.out.println(Thread.currentThread().getState() + " : " +
        // thread.getState());
        // Thread.sleep(100);
        // }

        // System.out.println(thread.getState());
    }
}
