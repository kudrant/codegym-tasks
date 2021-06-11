package com.codegym.task.task13.task1326;

/* 
Sorting even numbers from a file

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //write your code here
        ArrayList<Integer> list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            reader.close();
            reader = new BufferedReader(new InputStreamReader(fileInputStream));


            int number;
            while(reader.ready()) {

                    list.add(Integer.parseInt(reader.readLine()));
            }
            fileInputStream.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(list);

        for (int number: list
             ) {
            if (number % 2 == 0)
                System.out.println(number);
        }

    }
}
