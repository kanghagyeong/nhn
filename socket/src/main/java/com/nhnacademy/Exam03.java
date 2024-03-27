package com.nhnacademy;

import java.net.Socket;

public class Exam03 {
    public static void main(String[] args) {
    
        try (Socket socket = new Socket("localhost" , 12345)) {
            System.out.println("Local address : " + socket.getLocalAddress());
            System.out.println("Local port : " + socket.getLocalPort());
            System.out.println("Remote address : " + socket.getInetAddress());
            System.out.println("Remote port : " + socket.getPort());
        } catch (Exception e) {
            //
        }
    }
    
}
