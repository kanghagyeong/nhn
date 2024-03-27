package com.nhnacademy;

import java.io.Console;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test {
    public static void main(String[] args) {
        JSONArray userArray = new JSONArray();
        JSONArray itemArray = new JSONArray();

        Console console = System.console();

        while (true) {
            System.out.println("command : ");
            String line = console.readLine();
            if (line.equals("quit")) {
                break;
            }
            System.out.println("input command : " + line);

            String[] inputs = line.split(" ");
            // user add 002 tiger
            if (inputs[0].equals("user") && inputs[1].equals("add")) {
                User user = new User(inputs[2], inputs[3]);

                JSONObject userObject = new JSONObject(user);

                userArray.put(userObject);

                System.out.println("사용자 " + inputs[3] + " 추가되었습니다.");
            } else if (inputs[0].equals("user") && inputs[1].equals("delete")) {

                for (int i = 0; i < userArray.length(); i++) {
                    Object userId = userArray.getJSONObject(i).get("id");

                    if (userId.equals(inputs[2])) {
                        userArray.remove(i);
                    }
                }
                System.out.println("사용자" + inputs[2] + " 삭제되었습니다.");
            }


            // item add // id model hp ap dp ms as

            if (inputs[0].equals("item") && inputs[1].equals("add")) {
                Item item = new Item(inputs[2], inputs[3],
                Integer.parseInt(inputs[4]),
                Integer.parseInt(inputs[5]),
                Integer.parseInt(inputs[6]),
                Integer.parseInt(inputs[7]),
                Integer.parseInt(inputs[8]));

                JSONObject itemObject = new JSONObject(item);

                itemArray.put(itemObject);

                System.out.println("아이템 " + inputs[3] + " 추가되었습니다.");
            } else if (inputs[0].equals("item") && inputs[1].equals("delete")) {

                for (int i = 0; i < itemArray.length(); i++) {
                    Object itemId = itemArray.getJSONObject(i).get("id");

                    if (itemId.equals(inputs[2])) {
                        itemArray.remove(i);
                    }
                }
                System.out.println("아이템" + inputs[2] + " 삭제되었습니다.");
            }

        }

    }

}
