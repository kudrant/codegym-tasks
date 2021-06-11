package com.codegym.task.task19.task1925;

/* 
Long words

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            FileWriter writer = new FileWriter(args[1]);
            ArrayList<String> list = new ArrayList<>();

            while (reader.ready()) {
                String[] words = reader.readLine().split(" ");
                for (String word : words
                ) {
                    if (word.length() > 6)
                        list.add(word);
                }
            }
            reader.close();
            for (int i = 0; i < list.size() - 1; i++) {
                writer.write(list.get(i) + ",");
            }
            writer.write(list.get(list.size() - 1));
            writer.close();




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
