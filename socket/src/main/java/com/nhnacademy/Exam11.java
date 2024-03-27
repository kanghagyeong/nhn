package com.nhnacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam11 {
    public static void main(String[] args) {
        
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            Socket socket = serverSocket.accept();

            while (!Thread.currentThread().interrupted()) {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String line;

                while (!(line = input.readLine()).equals("exit")) {
                    socket.getOutputStream().write((line + "\n").getBytes());
                    System.out.println(line);
                }

            }
        } catch (Exception e) {
            // 
        }
    }

    
}