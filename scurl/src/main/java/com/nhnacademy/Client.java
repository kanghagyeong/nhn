package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable {
    int port;
    String address;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }
    
    @Override
    public void run() {
          try (Socket socket = new Socket(address, port)) {
                    MultiNC netcat = new MultiNC(socket);
                    Thread thread = new Thread(netcat);
                    thread.start();

                    Thread inputAgent = new Thread(() -> {
                        try {
                            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                            String line;
                            while ((line = input.readLine()) != null) {
                                netcat.send(line + "\n");
                            }
                        } catch (IOException e) {
                        }
                    });

                    Thread outputAgent = new Thread(() -> {
                        while (!Thread.currentThread().isInterrupted()) {
                            if (!netcat.isEmptyReceiveQueue()) {
                                String line = netcat.receive();
                                System.out.println(line);
                            }
                        }
                    });

                    inputAgent.start();
                    outputAgent.start();
                    thread.join();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
    }
    
}
