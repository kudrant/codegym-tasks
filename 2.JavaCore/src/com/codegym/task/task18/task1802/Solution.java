package com.codegym.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Minimum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        int min = fis.read();
        while (fis.available() > 0) {
            int num = fis.read();
            if (num < min)
                min = num;
        }
        fis.close();
        System.out.println(min);
    }
}
