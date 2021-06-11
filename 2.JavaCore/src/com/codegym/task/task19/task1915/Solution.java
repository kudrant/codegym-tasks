package com.codegym.task.task19.task1915;

/* 
Duplicate text

*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String outputString = outputStream.toString();
        FileOutputStream fos = new FileOutputStream(fileName);
        System.setOut(consoleStream);


        for (char ch: outputString.toCharArray()
             ) {
            fos.write((int)ch);
        }


        System.out.println(outputString);

        fos.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This is text for testing");
        }
    }
}

