package com.codegym.task.task19.task1927;

/* 
Contextual advertising

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        //Put everything back to the way it was
        System.setOut(consoleStream);

        String[] lines = result.split("\\n");
        boolean other = false;
        for (String line: lines
             ) {
            if (other) {
                System.out.println(line);
                System.out.println("CodeGym - online Java courses");
                other = false;
            }
            else {
                System.out.println(line);
                other = true;
            }
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
