package com.nhnacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Shttp implements Runnable {
    int port = 80;
    public static void main(String[] args) {
        
    }

    @Override
    public void run() {
        while (!Thread.currentThread().interrupted()) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                ServiceHandler handler = new ServiceHandler(serverSocket.accept());
            } catch (Exception e) {
                //
            }
        }
    }
}
