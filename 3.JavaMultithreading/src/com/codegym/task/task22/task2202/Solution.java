package com.codegym.task.task22.task2202;



/*
Find a substring

*/
public class Solution {
    public static void main(String[] args) throws StringTooShortException {
        System.out.println(getPartOfString("CodeGym is the best place to learn Java."));
    }

    public static String getPartOfString(String string) throws StringTooShortException {
        if (string == null) throw new StringTooShortException();
        String[] words = string.split(" ");
        String result = "";
        if (words.length < 5)
            throw new StringTooShortException();
        else {
            result = words[1] + " " + words[2] + " " + words[3] + " " + words[4];
            return result;
        }
    }

    public static class StringTooShortException extends RuntimeException{

    }
}