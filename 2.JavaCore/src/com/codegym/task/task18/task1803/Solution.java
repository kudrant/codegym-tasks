package com.codegym.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Most frequent bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> diffSet = new HashSet<Integer>();
        while (fis.available() > 0) {
            int current = fis.read();
            if(!set.contains(current)) {
                set.add(current);
            }
            else {
                if(!(diffSet.contains(current))) {
                    diffSet.add(current);
                }
                else System.out.print(current+"\t");
            }
        }
        fis.close();
    }
}
