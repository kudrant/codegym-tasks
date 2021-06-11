package com.codegym.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Replacing numbers

*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) {
                StringBuilder sb = new StringBuilder();
                String[] arr = reader.readLine().split(" ");
                for(String s : arr) {
                    String punctuation = s.replaceAll("[a-zA-Z0-9]", ""); //take out all punctuation from string;
                    String word = s.replaceAll("[^a-zA-Z0-9]", ""); // replace all punctuation
                    if (isDigitValue(word)) {      // if word is digit, compare if it in the maps , replace it if it in the map
                        if (map.containsKey(Integer.parseInt(word)))
                            word = map.get(Integer.parseInt(word));
                    }
                    sb.append(word).append(punctuation).append(" "); // put all parts comeback.

                }
                System.out.println(sb.toString().trim()); //convert stringbuilder to string and print
            }

            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean isDigitValue (String s) {  //identify if word is numeric
        if (s == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(s);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
