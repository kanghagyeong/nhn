package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoServer {

    static int port;
    static List<Integer> bingoBoard = new ArrayList<>();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1234)) {

            System.out.println("서버가 열렸습니다 !");
            while (!Thread.currentThread().interrupted()) {
                try {
                    Socket socket = serverSocket.accept();
                    clientNotice(socket, "클라이언트 1이 입장했습니다.");

                    Socket socket2 = serverSocket.accept();
                    clientNotice(socket2, "클라이언트 2가 입장했습니다.");
            
                    clientNotice(socket, socket2, "빙고판을 만들겠습니다.");
               
                    for (int i = 0; i < 25; i++) {
                        if (i % 2 == 0) {
                            bingoNumberInput(socket);
                        } else {
                            bingoNumberInput(socket2);
                        }
                    }
                    break;

                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void bingoNumberInput(Socket socket) {
        try {
            socket.getOutputStream().write("숫자를 입력하세요.\n".getBytes());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = input.readLine();

            bingoBoard.add(Integer.parseInt(line));

            displayBingoBoard(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayBingoBoard(Socket socket) {
        try {
            //clientNotice(socket, socket2, "=========== 빙고 보드 ===========\n");
            socket.getOutputStream().write("=========== 빙고 보드 ===========\n".getBytes());
            for (int i = 0; i < bingoBoard.size(); i++) {

                socket.getOutputStream().write((bingoBoard.get(i) + "\t").getBytes());

                if (bingoBoard.get(i) == -1) {
                    socket.getOutputStream().write("O".getBytes());
                }
                if ((i + 1) % 5 == 0) {
                    socket.getOutputStream().write("\n".getBytes());
                }
            }
            socket.getOutputStream().write("\n=================================".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkArea(int number) {
        for (int i = 0; i < bingoBoard.size(); i++) {
                if (bingoBoard.get(i) == number) {
                    bingoBoard.set(i, -1);   
                    break;
                }
        }
     
    }

    public static void clientNotice(Socket socket, Socket socket2, String string) {
        try {
            socket.getOutputStream().write(string.getBytes());
            socket2.getOutputStream().write(string.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clientNotice(Socket socket, String string) {
        try {
            socket.getOutputStream().write(string.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





