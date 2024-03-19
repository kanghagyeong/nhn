package com.nhnacademy;

import org.json.JSONObject;

public class Exam1 {
    public static void main(String[] args) {
        
        JSONObject object = new JSONObject();
        JSONObject object2 = new JSONObject();

        object.put("address", object2);
        object2.put("code", "13487");
        object2.put("city", "Seongnam");
        object.put("name", "nhn");
        object.put("name", "NHN"); // 2번째 줄은 값 변경 ?

        System.out.println(object);
    }
    
}
