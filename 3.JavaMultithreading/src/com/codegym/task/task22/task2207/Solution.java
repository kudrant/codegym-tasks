package com.codegym.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Inverted words

*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "c:/test2.txt";
        reader = new BufferedReader(new FileReader(fileName));


        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
            sb.append(" ");
        }
        reader.close();

        String inputString = sb.toString();
        String[] words = inputString.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(""))
                continue;
            for (int j = i + 1; j < words.length; j++) {
                String reversedStr = new StringBuilder(words[j]).reverse().toString();
                if (words[i].equals(reversedStr)) {
                    Pair pair = new Pair();
                    pair.first= words[i];
                    pair.second = words[j];
                    result.add(pair);
                    words[j] = "";
                    break;
                }
            }
        }
        for (Pair pair: result
             ) {
            System.out.println(pair.toString());
        }


    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}