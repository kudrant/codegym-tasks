package com.codegym.task.task19.task1912;

/* 
Reader Wrapper 2

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;

        //Create a dynamic array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //Create an adapter for the PrintStream class
        PrintStream stream = new PrintStream(outputStream);

        //Set it as the current System.out
        System.setOut(stream);

        testString.printSomething();

        //Convert the data written to our ByteArray into a string
        String outputString = outputStream.toString();

        String result = outputString.replaceAll("(te)", "??");

        System.setOut(consoleStream);
        System.out.println(result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This is text for testing");
        }
    }
}
