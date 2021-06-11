package com.codegym.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Sorting bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();

        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available() > 0) {
            int data = fis.read();
            if (!list.contains(data))
                list.add(data);
        }
        fis.close();
        Collections.sort(list);

        for (Integer listItem: list
             ) {
            System.out.print(listItem + "\t");
        }

    }
}
