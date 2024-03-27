package com.nhnacademy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam08 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (!Thread.currentThread().interrupted()) {
                Socket socket = serverSocket.accept();

                System.out.println("Connected : " + socket.getInetAddress().getAddress());
                socket.getOutputStream().write("hello\n".getBytes());
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
