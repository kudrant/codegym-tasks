package com.codegym.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/* 
Searching for the right lines

*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("file");
        words.add("view");
        words.add("In");
    }

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();
            bufferedReader = new BufferedReader(new FileReader(fileName));

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] wordsArray = line.split(" ");
                int counter = 0;
                for (String wordItem: wordsArray
                     ) {
                    if (words.contains(wordItem))
                        counter++;
                }
                if (counter == 2) {
                    System.out.println(line);
                }

            }
            bufferedReader.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
