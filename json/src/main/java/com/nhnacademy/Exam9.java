package com.nhnacademy;

import java.io.Console;
import java.io.InputStreamReader;

import javax.sound.sampled.LineEvent;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Exam9 {
    public static void main(String[] args) {
        // JSONTokener tokener = new JSONTokener(System.in);

        // while (!tokener.end()) {
        // Object object = tokener.nextValue();
        // System.out.println(object.getClass().getTypeName() + " : " + object);
        // }

        // InputStreamReader reader = new InputStreamReader(System.in);

        // System.out.println();

        Console console = System.console();

        while (true) {
            System.out.println("command : ");
            String line = console.readLine();
            if (line.equals("quit")) {
                break;
            }
            System.out.println("input command : " + line);
        }

    }

}
