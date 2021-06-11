package com.codegym.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Number of letters

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Alphabet
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<>();
        for (char letter : abcArray) {
            alphabet.add(letter);
        }

        // Read in strings
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        HashMap<Character, Integer> numOfLetters = new HashMap<>();

        // write your code here
        for (char ch: alphabet
             ) {
            int counter = 0;
            for (String str: list
                 ) {
                for (int i = 0; i < str.length(); i++) {
                    if (ch == str.charAt(i)) {
                        counter++;
                    }
                }
            }
            numOfLetters.put(ch, counter);
        }

        for (Map.Entry<Character, Integer> pair: numOfLetters.entrySet()
             ) {
            Character key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(key + " " + value);

        }
    }

}
