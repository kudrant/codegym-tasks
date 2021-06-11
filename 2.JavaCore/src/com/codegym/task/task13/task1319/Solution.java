package com.codegym.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Writing to a file from the console

*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // write your code here

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();

            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file); // поток, который подключается к текстовому файлу
            BufferedWriter writer = new BufferedWriter(fileWriter); // соединяем FileWriter с BufferedWriter
            String line = "";
            while(!(line.equals("exit"))) {
                line = reader.readLine();
                writer.write(line + "\n");
            }

            reader.close(); // закрываем поток
            writer.close(); // закрываем поток
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
