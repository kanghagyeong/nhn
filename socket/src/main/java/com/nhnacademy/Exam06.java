package com.nhnacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Exam06 {
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

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결되었습니다.");

            String line;

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!(line = input.readLine()).equals("exit")) {
                socket.getOutputStream().write((line + "\n").getBytes());
                System.out.println(line);
            }
        } catch (Exception ignore) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }
    }

}
