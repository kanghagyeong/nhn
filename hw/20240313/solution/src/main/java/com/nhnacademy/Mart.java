package com.nhnacademy;

import java.util.List;
import java.util.ArrayList;

public class Mart {

    List<Store> storeList = new ArrayList<>();

    public Mart() {
        addStore();
    }

    public void addStore() {
       for (int i = 0; i < 3; i++) {
         storeList.add(new Store());
       }
    }

    public List<Store> getStoreList() {
        List<Store> newStoreList = new ArrayList<>();
        newStoreList.add(storeList.get((int)Math.random() * 2));
        return newStoreList;
    }


    
}
