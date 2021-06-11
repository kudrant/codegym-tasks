package com.codegym.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Functionality is not enough!

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        String lastID = "";
        boolean flag = false;

        while (true) {
            String id = reader.readLine();
            String name = reader.readLine();
            if (id.equals("")) break;

            if (name.equals("")) {
                lastID = id;
                flag = true;
                break;
            }
            map.put(name, Integer.parseInt(id));
        }

        for (HashMap.Entry<String, Integer> pair: map.entrySet()
             ) {
            String key = pair.getKey();
            int value = pair.getValue();
            System.out.println(value + " " + key);

        }
        if (flag) {
            System.out.println(lastID);
        }



    }
}
