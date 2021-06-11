package com.codegym.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Maximum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int max = 0;
        while (fis.available() > 0) {
            int num = fis.read();
            if (num > max)
                max = num;
        }

        fis.close();
        System.out.println(max);
    }
}
