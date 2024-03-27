package com.nhnacademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class NetCat implements Runnable {
    Socket socket;
    Queue<String> receiverQueue = new LinkedList<>();
    Queue<String> senderQueue = new LinkedList<>();

    public NetCat(Socket socket) {
        this.socket = socket;
    }

    public void send(String message) { 
        synchronized(senderQueue) {
            senderQueue.add(message); // 메세지를 sender 큐에 추가 
        }
    }

    public boolean isEmptyReceiveQueue() { // 동기화된 방식으로 리시버큐가 비어있는지 확인 - 여러 스레드가 이 영역을 동시에 실행시키지 못하게 
        synchronized(receiverQueue) {
            return receiverQueue.isEmpty();
        }
    }

    public String receive() {
        synchronized(receiverQueue) {
            return receiverQueue.poll(); // 첫번쩨 요소를 제거하고 반환 // 제거할 요소가 없는 경우에는 null 반환 
        }
    }

    public void run() {
        try {
                
                    BufferedReader inputRemote = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입출력 속도 향상 // 입출력 스트림 초기화 
                    BufferedWriter outputRemote = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 버퍼는 데이터를 일시적으로 저장하는 메모리 영역

            Thread receiver = new Thread(() -> { // 데이터를 받아서 큐에 저장하는 스레드 
                try {
                    String line;
                    while ((line = inputRemote.readLine()) != null) {
                        synchronized(receiverQueue) { // 다른 스레드가 동시에 접근하지 못하게 하기 
                            receiverQueue.add(line);
                        }
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            });

            Thread sender = new Thread(() -> { // 소켓을 통해 데이터를 전송하는 스레드 
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        synchronized(senderQueue) {  // 다른 스레드가 동시에 접근하지 못하게 하기 
                            if (!senderQueue.isEmpty()) {
                                outputRemote.write(senderQueue.poll()); // 큐에서 요소를 제거하고 반환하는 역할 
                                outputRemote.flush(); // 출력 스트림에서 강제적?으로 데이터 전송 
                            }
                        }
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            });

            receiver.start(); // 스레드 시작 
            sender.start();

            receiver.join(); // 종료까지 대기 
            sender.join();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
        }
    }
}
