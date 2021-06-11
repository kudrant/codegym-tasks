package com.codegym.task.task19.task1907;

/* 
Counting words

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        int counter = 0;
        bufferedReader.close();

        FileReader reader = new FileReader(fileName);
        String input = "";
        while (reader.ready()) {
            int data = reader.read();
            char ch = (char)data;
            input += ch;
        }
        reader.close();


        Pattern pattern = Pattern.compile("[ ,.!?]world(\\w*)");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
            counter++;
        System.out.println(counter);

    }
}
