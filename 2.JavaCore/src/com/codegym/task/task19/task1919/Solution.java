package com.codegym.task.task19.task1919;

/* 
Calculating salaries

*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];

        Map<String, Double> map = new TreeMap<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                String name = line[0];
                double value = Double.parseDouble(line[1]);
                if (map.containsKey(name)) {
                    double currentValue = map.get(name);
                    map.replace(name, currentValue + value);
                }
                else
                    map.put(name, value);
            }

            fileReader.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Double> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
