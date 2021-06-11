package com.codegym.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* 
Rarest bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> diffSet = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<>();

        while (fis.available() > 0) {
            int data = fis.read();
            if (list.contains(data)) {
                set.add(data);
            }
            list.add(data);

        }
        fis.close();

        for (Integer item: list
             ) {
            if (!set.contains(item)) {
                System.out.print(item + "\t");
            }

        }

    }
}
