package com.nhnacademy;

import org.json.JSONException;
import org.json.JSONObject;

public class Exam2 {
    public static void main(String[] args) {
        try {
    
            String jsonString = "{\"code\":\"13487\"}";

            JSONObject object = new JSONObject(jsonString);
         
    
            System.out.print(object);
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
       
    }
    
}
