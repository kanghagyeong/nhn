package com.nhnacademy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        for (String s : args) {

            // Pattern pattern = Pattern.compile("^\\s*[+-]?(0[1-9]\\d{0,9})\\s*$");
            // Matcher matcher = pattern.matcher(arg);

            // if (matcher.find()) {
            // int value = Integer.parseInt(arg.trim());
            // System.out.println("int : " + value);
            // } else {
            // System.out.println("String : " + arg);
            // }
            // }
            try {
                String[] text = s.split("\\s+");
                for (String str : text) {
                    if (str.equals("javac")) {
                        continue;
                    }

                    if (str.contains(";")) {
                        String[] lines = str.split(";");
                        for (String str2 : lines) {
                            System.out.println(str2);
                        }
                        continue;
                    }

                    System.out.println(str);
                }

            } catch (Exception ignore) {
                //
            }

        }
    }
}
