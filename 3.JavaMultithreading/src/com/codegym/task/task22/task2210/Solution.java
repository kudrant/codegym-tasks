package com.codegym.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer

*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> stringList = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            stringList.add(tokenizer.nextToken());
        }
        String[] result = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            result[i] = stringList.get(i);
        }
        return result;
    }
}
