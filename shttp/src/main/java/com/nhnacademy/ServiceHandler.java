package com.nhnacademy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServiceHandler implements Runnable {
    Socket socket;
    Thread thread;

    public ServiceHandler(Socket socket) {
        this.socket = socket;
        thread = new Thread(this);
    }

    @Override
    public void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedOutputStream writer = new BufferedOutputStream(socket.getOutputStream())) {
                    while (!Thread.currentThread().interrupted()) {
                        String requestLine;
                        if (requestLine == null) {
                            break;
                        }

                        String[] fields = requestLine.split("\\s", 3);
                        if (fields.length != 3) {
                           // throw new InvalidHttpRequestException();
                        }

                        Request request = new Request(fields[0], fields[1], fields[2]);

                    }
        } catch (Exception e) {
            //
            e.printStackTrace();
        }
    }

}

// 클래스 설계 인터페이스 만들기 스레드 사용 ............볼 ,,, 음,,, 기억이 잘 ,,, 소켓통신까지 만들기 플로그 베이스드 프로그래밍 >?? 노도어쩌고 
// 결국 다 한다는 소리 ^^^^^^^