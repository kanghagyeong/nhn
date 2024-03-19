package com.nhnacademy;

import org.json.JSONObject;

public class Exam5 {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();

        object.put("name", "nhn");
        object.put("age", 10);

        Object nameObject = object.get("name");
        System.out.println("Name type : " + nameObject.getClass().getTypeName());

        if (nameObject instanceof String) {
            System.out.println("Name is String");
        }
        
        Object ageObject = object.get("age");
        System.out.println("Age type : " + ageObject.getClass().getTypeName());
    }
    
}
