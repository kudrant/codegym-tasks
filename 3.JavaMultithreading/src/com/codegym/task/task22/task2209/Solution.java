package com.codegym.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Make a word chain

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // ...
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        List<String> fileWords = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader(fileName));
        while(buffer.ready()){
            fileWords.addAll(Arrays.asList(buffer.readLine().split(" ")));
        }
        buffer.close();
        //String[] testItems = {"Okinawa", "Washington", "Auckland", "Kalamazoo", "Norfolk"};

        //StringBuilder result = getLine((String[])fileWords.toArray());
        StringBuilder result = getLine((String[])fileWords.toArray(new String[0]));
        //StringBuilder result = getLine(testItems);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words){
        StringBuilder builder = new StringBuilder();
        if(words.length==0){
            return builder;
        }else if(words.length==1){
            builder.append(words[0]);
            return builder;
        }
        List<String> listOfWords = getMaxLine(' ', words);
        if(listOfWords.size()==0){
            return builder;
        }
        builder.append(listOfWords.get(0));
        for(int i=1; i<listOfWords.size();i++){
            builder.append(" "+listOfWords.get(i));
        }
        return builder;
    }

    public static List<String> getMaxLine(char character, String[] words){
        if(words.length == 0){
            return new ArrayList<>();
        }else if(words.length == 1){
            List<String> list = new ArrayList<>();
            if(isFollower(character,words[0])){
                list.add(words[0]);
            }
            return list;
        }else{
            if(hasFollower(character, words)){
                int maxLength = 0;
                List<String> maxList = new ArrayList<>();
                for(String word: words){
                    String[] newWords;
                    ArrayList tempWords = new ArrayList(Arrays.asList(words));
                    tempWords.remove(word);
                    newWords = (String[])tempWords.stream().toArray(String[]::new);
                    if(isFollower(character, word)){
                        char newCharacter = word.charAt(word.length()-1);
                        List<String> newList = getMaxLine(newCharacter, newWords);
                        newList.add(0,word);
                        if(newList.size()>maxLength){
                            maxList = newList;
                            maxLength = maxList.size();
                        }
                    }
                }
                return maxList;
            }else{
                return new ArrayList<>();
            }
        }
    }

    public static boolean hasFollower(char character, String[] words) {
        if (character==' '){
            return true;
        }
        for (String word : words) {
            if (Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(character)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFollower(char character, String word){
        if(character == ' '){
            return true;
        }
        return Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(character);
    }


}