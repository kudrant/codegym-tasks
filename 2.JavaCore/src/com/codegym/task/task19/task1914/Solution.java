package com.codegym.task.task19.task1914;

/* 
Problem solving

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
        String[] equationElements = outputString.split(" ");
        int a = Integer.parseInt(equationElements[0]);
        int b = Integer.parseInt(equationElements[2]);
        String sign = equationElements[1];
        int c = 0;
        String equationResult = "";
        switch (equationElements[1]) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;

        }

        System.setOut(consoleStream);

        System.out.println(a + " " + sign + " " + b + " = " + c);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

