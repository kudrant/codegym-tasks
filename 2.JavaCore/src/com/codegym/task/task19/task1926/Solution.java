package com.codegym.task.task19.task1926;

/* 
Mirror image

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                String line = reader.readLine();
                String reversedLine = "";
                for (int i = line.length() - 1; i >= 0; i--) {
                    reversedLine += line.charAt(i);
                }
                System.out.println(reversedLine);
            }
            reader.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
