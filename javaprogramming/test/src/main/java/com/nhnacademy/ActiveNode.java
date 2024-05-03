package com.nhnacademy;

public abstract class ActiveNode extends Node implements Runnable{
    private Thread thread;

    
    public ActiveNode(String name) {
        super(name);
        this.thread = new Thread(this);
    }

    public boolean isActive() {
        return true;
    }

    public void start() { // 동작 시작
        thread.start();
        perform();
    }

    public void initialize() { // 초기화
        
    }

    public void perform() { // 주요 기능 수행 / 대기

        while (isActive()) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
       
        idle();
    }

    public void idle() { // 일정 주기 반복 , 시간 내 수행 완료시 대기 
       
    }

    public void finalize() { // 정리 작업

    }

    public void terminated() { // 실행 노드 완전 종료
        thread.interrupt();
    }
    

    @Override
    public void run() {

    }
}
