package com.nhnacademy;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataBase {

    public JSONObject object;
    public JSONArray array;

    public DataBase() {
       this.object = new JSONObject();
       this.array = new JSONArray();
    }
    
    public void createUserDataBase(String id, String name) {

        JSONObject user = new JSONObject();

        user.put("id", id);
        user.put("name", name);

        array.put(user);
        object.put("users", array);
    }

    public void createItemDataBase(String id, String model, int hp, int defensePower, int attackPower, int movePower, int attackSpeed) {

        JSONObject item = new JSONObject();
        
        item.put("id", id);
        item.put("model", model);
        item.put("hp", hp);
        item.put("defensePower", defensePower);
        item.put("attackPower", attackPower);
        item.put("movePower", movePower);
        item.put("attackSpeed", attackSpeed);

        array.put(item);
        object.put("items", array);
    }




}