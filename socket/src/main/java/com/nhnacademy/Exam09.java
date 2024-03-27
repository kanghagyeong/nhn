package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Exam09 {
    public static void main(String[] args) {

         try (ServerSocket serverSocket = new ServerSocket(1234)) {
           
            while (!Thread.currentThread().interrupted()) {
                Socket socket = serverSocket.accept();

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = input.readLine();

                System.out.println("Connected : " + socket.getInetAddress().getHostAddress());
                socket.getOutputStream().write(line.getBytes());
                socket.getOutputStream().write("\n".getBytes());

                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
