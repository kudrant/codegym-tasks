package com.codegym.task.task18.task1807;

/* 
Counting commas

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        int result = 0;
        while (fis.available() > 0) {
            int data = fis.read();
            char ch = (char)data;
            if (Character.toString(ch).equals(",")) {
                result++;
            }
        }
        fis.close();
        System.out.println(result);

    }
}
