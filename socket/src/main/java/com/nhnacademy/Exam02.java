package com.nhnacademy;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exam02 {
    public static void main(String[] args) {

        int startPort = Integer.parseInt(args[0]);
        int endPort = Integer.parseInt(args[1]);

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket("localhost", port)) {
                System.out.println("Port" + port + "열려 있습니다.");
            } catch (UnknownHostException e) {

            } catch (IOException e) {

            }

        }

    }
}
