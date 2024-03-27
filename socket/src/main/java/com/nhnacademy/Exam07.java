package com.nhnacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Exam07 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;


        if (args.length > 0) {
            host = args[0];
        }

        try {
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException ignore) {
            //
        }

        try (Socket socket = new Socket(host, port)){
            System.out.println("서버에 연결되었습니다.");

            Thread thread = new Thread(() -> {
                try {
                    System.out.println("서버에 연결되었습니다.");
        
                    String line;
        
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (!(line = input.readLine()).equals("exit")) {
                        // socket.getOutputStream().write("\n".getBytes());
                        System.out.println(line);
                    }
                } catch (Exception ignore) {
                   //
                }
            });
            thread.start();

            while (!Thread.currentThread().isInterrupted()) {
                String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (!(line = reader.readLine()).equals("exit")) {
                    socket.getOutputStream().write(line.getBytes());
                    socket.getOutputStream().write("\n".getBytes());
                }
            }
            
        } catch (Exception ignore) {
           
        }

    }
    
    
}
