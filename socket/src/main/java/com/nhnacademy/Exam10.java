package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Exam10 {
    static int port;

    public static void main(String[] args) {

        if (!args[0].equals("snc")) {
            throw new IllegalArgumentException("똑바로 입력하세요 !");
        }

        try {
            port = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("숫자만 입력하세요 !");
        }

        if (!args[1].equals("-l") && !args[1].equals("localhost")) {
            throw new IllegalArgumentException("똑바로 입력하세요 !");
        }

        if (args[1].equals("-l")) {

            try (ServerSocket serverSocket = new ServerSocket(1234)) {

                while (!Thread.currentThread().interrupted()) {
                    try (Socket socket = serverSocket.accept();
                            Scanner sc = new Scanner(System.in);
                            BufferedReader input = new BufferedReader(
                                    new InputStreamReader(socket.getInputStream()));) {

                        String line;

                        System.out.println("Connected : " + socket.getInetAddress().getHostAddress());

                        while (!(line = sc.nextLine()).equals("exit")) {
                            System.out.println(input.readLine());
                            socket.getOutputStream().write(line.getBytes());
                            socket.getOutputStream().write("\n".getBytes());
                        }

                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            try (Socket socket = new Socket(args[1], port);
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    Scanner sc = new Scanner(System.in);) {

                String line;

                while (!(line = sc.nextLine()).equals("exit")) {
                    System.out.println(input.readLine());
                    socket.getOutputStream().write(line.getBytes());
                    socket.getOutputStream().write("\n".getBytes());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
