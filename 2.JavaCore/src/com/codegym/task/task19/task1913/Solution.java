package com.codegym.task.task19.task1913;

/* 
Output only digits

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StreamCorruptedException;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String outputString = outputStream.toString();
        String result = outputString.replaceAll("[\\D+]", "");
        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This 1 text 23 is 4 f5-6or7 tes8ting");
        }
    }
}
