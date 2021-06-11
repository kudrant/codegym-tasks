package com.codegym.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Request parser

*/

public class Solution {
    public static void main(String[] args) {
        //write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parameters = null;
        Map<String, String> map = new HashMap<>();

        try {
            String url = reader.readLine();
            String subURL = url.substring(url.indexOf('?')+1);

            parameters = subURL.split("&");
            for (int i = 0; i < parameters.length - 1; i++) {
                if (parameters[i].contains("=")) {
                    map.put(parameters[i].split("=")[0], parameters[i].split("=")[1]);
                    System.out.print(parameters[i].split("=")[0] + " ");
                }
                else {
                    map.put(parameters[i], "");
                    System.out.print(parameters[i] + " ");
                }

            }
            System.out.println(parameters[parameters.length-1].split("=")[0]);

            for (Map.Entry entry: map.entrySet()
                 ) {
                if (entry.getKey().equals("obj")) {
                    try{
                        alert((double)Double.parseDouble(entry.getValue().toString()));

                    }
                    catch (NumberFormatException e) {
                        alert(entry.getValue().toString());
                    }
                }
            }
        }
        catch(IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
