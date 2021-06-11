package com.codegym.task.task19.task1923;

/* 
Words with numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            FileWriter writer = new FileWriter(args[1]);

            while (reader.ready()) {
                String line = reader.readLine();
                String[] words = line.split(" ");
                for (String word: words
                     ) {
                    try {
                        int number = Integer.parseInt(word);
                        continue;
                    }
                    catch (NumberFormatException e) {}

                    if (word.matches(".*\\d.*")) {
                        writer.write(word + " ");
                    }
                }
            }
            reader.close();
            writer.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
