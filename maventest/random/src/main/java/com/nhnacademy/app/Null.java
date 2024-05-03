package com.nhnacademy.app;

import java.lang.String;
import org.apache.commons.lang3.StringUtils;

public class Null {
 public static void main(String[] args) {
    
    String str = "Hello";
    System.out.println(str.isEmpty());

    StringUtils su = new StringUtils();
    System.out.println(su.isBlank(str));

}
}
