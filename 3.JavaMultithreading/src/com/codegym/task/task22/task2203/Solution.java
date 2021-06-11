package com.codegym.task.task22.task2203;

/* 
Between tabs

*/
public class Solution {
    public static String getPartOfString(String string) throws StringTooShortException {
        if (string == null)
            throw new StringTooShortException();
        int start = string.indexOf('\t')+1;
        if (start < 0)
            throw new StringTooShortException();
        int end = string.indexOf('\t', start + 1);
        if (end < 0)
            throw new StringTooShortException();

        return string.substring(start, end);
    }

    public static class StringTooShortException extends Exception {
    }

    public static void main(String[] args) throws StringTooShortException {
        System.out.println(getPartOfString("\tCodeGym is the best place \tto learn Java\t."));

    }
}