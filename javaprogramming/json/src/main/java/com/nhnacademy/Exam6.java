package com.nhnacademy;

import org.json.JSONArray;
import org.json.JSONObject;

public class Exam6 {
    public static void main(String[] args) {
        String[] birds =  new String[] {"갈매기" ,"참새", "펭귄"};
        String[] mammals =  new String[] {"사자" ,"호랑이", "말"};

        JSONArray birdArray = new JSONArray(birds);
        JSONObject birdObject = new JSONObject();
        birdObject.put("조류", birdArray);


        JSONArray mammalArray = new JSONArray(mammals);
        JSONObject mammalObject = new JSONObject();
        mammalObject.put("포유류", mammalArray);

        
        JSONArray animalArray = new JSONArray();
        animalArray.put(birdObject);
        animalArray.put(mammalObject);

        JSONObject animalObject = new JSONObject();
        animalObject.put("동물", animalArray);

        System.out.println(animalObject);

        
    }
    
}
