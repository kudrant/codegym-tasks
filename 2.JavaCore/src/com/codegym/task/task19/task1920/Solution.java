package com.codegym.task.task19.task1920;

/* 
The richest

*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];

        Map<String, Double> map = new TreeMap<>();


//        map.put("A", 99.5);
//        map.put("B", 67.4);
//        map.put("C", 67.4);
//        map.put("D", 67.3);
//
//        System.out.println("unsorted map: " + map);
//        sorted_map.putAll(map);
//        System.out.println("results: " + sorted_map);



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

        double maxValue = Integer.MIN_VALUE;
        ArrayList<String> result = new ArrayList<String>();

        for(Map.Entry<String, Double> pair: map.entrySet()){
            if(pair.getValue() > maxValue){
                maxValue = pair.getValue();
            }
        }
        for(Map.Entry<String, Double> pair: map.entrySet())
        {
            if(pair.getValue() == maxValue || pair.getValue() >= (maxValue - 1))
            {
                result.add(pair.getKey());
            }
        }
        Collections.sort(result);
        for(String l : result)
        {
            for(Map.Entry<String, Double> pair:map.entrySet())
            {
                if(l.equals(pair.getKey()))
                {
                    System.out.println(pair.getKey());
                }
            }
        }
    }



}
