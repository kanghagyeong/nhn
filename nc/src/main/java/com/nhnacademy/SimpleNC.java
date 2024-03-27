package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class SimpleNC {
    public static void main(String[] args) {
        Options options = new Options(); 

        options.addOption("l", false, "Listen"); // -l 옵션 추가 -> listen을 나타내며, 리스닝 모드로 프로그램 실행 

        CommandLineParser parser = new DefaultParser(); // CommandLineParser 객체 생성 - 명령행을 파싱하는데 사용 ?

        try {
            CommandLine commandLine = parser.parse(options, args); // 옵션과 args(명령행 인수)를 파싱하여 commandline 객체 얻기 

            if (commandLine.hasOption("l")) { // commandline 객체에 "l" 옵션이 포함되어 있는지 확인 , 있다면 true ... 
                List<Thread> clientHandlerList = new LinkedList<>();
                List<NetCat> netCatList = new LinkedList<>();

                Thread inputAgent = new Thread(() -> { 
                    // -l 옵션이 존재할 경우 클라이언트 핸들러, 스레드, netcat생성하고 
                    // 사용자 입력 처리하는 inputAgent 실행 
                    try {
                        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                        String line;
                        while ((line = input.readLine()) != null) { // 사용자의 입력을 한 줄씩 읽어옴
                            synchronized (netCatList) {
                                for (NetCat netCat : netCatList) { // 각 netcat 객체 반복 
                                    netCat.send(line + "\n"); // 각 netcat 객체에 사용자가 입력한 내용을 전송
                                }
                            }
                        }
                    } catch (IOException e) {
                        //
                    }
                });

                Thread outputAgent = new Thread(() -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        synchronized (netCatList) { // 다른 스레드가 동시에 접근하는 것을 방지 
                            for (NetCat netCat : netCatList) { // netCatList 안에 있는 각 netcat객체에 대해 반복 
                                if (!netCat.isEmptyReceiveQueue()) { // 네트캣 객체의 수신 대기 큐가 비어있지 않은지 확인 
                                    String line = netCat.receive(); // 수신 대기 큐에서 메시지 읽어오기 
                                    System.out.println(line); // 읽어온 메시지 콘솔에 출력 
                                }
                            }
                        }

                        try {
                            Thread.sleep(10); // 10초동안 스레드 멈춤 
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });

                inputAgent.start();
                outputAgent.start();

                ServerSocket serverSocket = new ServerSocket(1234); // 포트 번호 1234 사용하는 새로운 서버 소켓 생성 
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        NetCat netCat = new NetCat(serverSocket.accept()); // 새로운 소켓 기다리고 연결되면 새로운 소켓 반환 
                        Thread thread = new Thread(netCat); 
                        thread.start();
                        clientHandlerList.add(thread); // 새로 생성된 스레드를 클라이언트 핸들러에 추가 
                        netCatList.add(netCat); // 갹채룰 냇캿 리스트애 추가 
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                serverSocket.close();
            } else { // 클라이언트가 서버에 연결하고 통신하는 역할 
                try (Socket socket = new Socket("localhost", 1234)) { // 1234포트 번호에 연결하는 새로운 소캣 생성 - 자동으로 닫힘 try with resources문 사용 
                    NetCat netCat = new NetCat(socket);
                    Thread thread = new Thread(netCat);
                    thread.start(); // 스레드 시작 -서버와 통신 시작 

                    Thread inputAgent = new Thread(() -> { // 사용자의 입력을 처리하는 새로운 스레드 생성 - 사용자가 입력한 내용을 서버로 전송
                        try {
                            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                            String line;
                            while ((line = input.readLine()) != null) { //1. 읽어
                                netCat.send(line + "\n"); // 2. 보내 
                            }
                        } catch (IOException e) {
                            //
                        }
                    });

                    Thread outputAgent = new Thread(() -> { // 서버로부터 수신되는 메시지를 처리하는 새로운 스레드 - 수신된 메시지를 화면에 출력 
                        while (!Thread.currentThread().isInterrupted()) {
                            if (!netCat.isEmptyReceiveQueue()) {
                                String line = netCat.receive(); // 3. 받아서 
                                System.out.println(line); // 4. 콘솔 출력 
                            }
                        }
                    });

                    inputAgent.start(); // 사용자 입력 스레드 실행 
                    outputAgent.start(); // 서버로부터 수신된 메시지 처리 스레드 실행 
                    thread.join(); // 스레드 종료까지 대기 ?  // 클라이언트 통신이 완료될 때까지 메인 스레드가 종료되지 않고 대기 
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (org.apache.commons.cli.ParseException | IOException e) {
        }
    }
}