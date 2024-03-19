package com.nhnacademy;

import org.json.JSONObject;

public class Exam3 {
    public static void main(String[] args) {
        Person person = new Person("강하경");
        

        JSONObject object = new JSONObject(person);

        System.out.println(object);
    }
    
}
