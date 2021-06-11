package com.codegym.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Using TreeSet

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> treeSet = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            StringBuilder sb = new StringBuilder();
            while(reader.ready()) {
                sb.append(reader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]",""));
            }
            for (char ch: sb.toString().toCharArray()
                 ) {
                treeSet.add(ch);
            }

            StringBuilder sbResult = new StringBuilder();
            for (char ch: treeSet
                 ) {
                sbResult.append(ch);
                if (sbResult.length() == 5) break;
            }
            System.out.println(sbResult);
        }

    }


}
