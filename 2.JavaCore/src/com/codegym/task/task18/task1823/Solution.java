package com.codegym.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Threads and bytes

*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            while (!(fileName = reader.readLine()).equals("exit")) {
                new ReadThread(fileName).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private FileInputStream fis;
        private String filename;
        public ReadThread(String fileName) {
            // Implement constructor body
            try {
                this.filename = fileName;
                this.fis = new FileInputStream(fileName);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // Implement file reading here

        @Override
        public void run() {
            try {
                Map<Integer, Integer> map = new TreeMap<>();
                int maxID = 0;
                int maxValue = 0;
                while (this.fis.available() > 0) {
                    int data = fis.read();
                    if (!map.containsKey(data)) {
                        map.put(data, 1);
                    }
                    else {
                        int counter = map.get(data) + 1;
                        map.replace(data, counter);
                        if (counter > maxValue) {
                            maxValue = counter;
                            maxID = data;
                        }
                    }
                }
                this.fis.close();
                resultMap.put(this.filename, maxID);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
