package com.codegym.task.task32.task3203;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/*
Writing a stack trace

*/
public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }
}