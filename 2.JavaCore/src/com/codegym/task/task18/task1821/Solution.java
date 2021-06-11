package com.codegym.task.task18.task1821;

/* 
Symbol frequency

*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private static final boolean DEBUG = false;
    public static void main(String[] args) {
        try {
            String fileName;
            if (DEBUG) {
                fileName = "C:/test.txt";
            } else {
                fileName = args[0];
            }
            FileInputStream fis = new FileInputStream(fileName);
            Map<Integer, Integer> symbolMap = new TreeMap<>();

            while (fis.available() > 0) {
                int data = fis.read();
                if (!symbolMap.containsKey(data)) {
                    symbolMap.put(data, 1);
                }
                else {
                    int curSymbolCount = symbolMap.get(data);
                    symbolMap.replace(data, curSymbolCount + 1);
                }
            }
            fis.close();

            for (Map.Entry<Integer, Integer> entry: symbolMap.entrySet()
                 ) {
                int key = entry.getKey();
                int value = entry.getValue();
                System.out.println((char)key + " " + value);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
