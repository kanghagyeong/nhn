package com.nhnacademy;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Store {
    final int MAX_VISITOR = 3;
    final int MAX_ITEMS = 5;
    int visitor;
    int items;
    Semaphore storeSemaphore = new Semaphore(MAX_VISITOR);
    Logger logger = Logger.getLogger(Store.class.getName());

    public int getVisitor() {
        return visitor;
    }

    public void enter() throws InterruptedException {
        visitor++;
        storeSemaphore.acquire();
        System.out.println("입장");
        logger.info("입장");
    }

    public void exit() {
        storeSemaphore.release();
        System.out.println("퇴장");
        logger.info("퇴장");
        visitor--;
    }

    public void buy() {
        try {
            if (items >= MAX_ITEMS && (!storeSemaphore.tryAcquire(1, TimeUnit.SECONDS))) {
                System.out.println("Consumer - 구매 포기(시간초과)");
                logger.warning("Consumer - 구매 포기(시간초과)");
                return;
            }
            System.out.println("구매했습니다");
            logger.info("구매했습니다");
            items--;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void sell() {
        try {
            if (items >= MAX_ITEMS && (!storeSemaphore.tryAcquire(1, TimeUnit.SECONDS))) {
                System.out.println("Producer - 납품 포기(시간초과)");
                logger.warning("Producer - 납품 포기(시간초과)");
                return;
            }
            items++;
            System.out.println("납품 받았습니다.");
            logger.info("납품 받았습니다.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
