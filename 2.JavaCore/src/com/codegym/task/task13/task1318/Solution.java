package com.codegym.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Reading a file

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = null;

        try {
            filename = reader.readLine();
        }
        catch (IOException e) {
            System.out.println("Empty string");
        }

        FileInputStream inStream = new FileInputStream(filename);

        while (inStream.available() > 0)
        {
            int data = inStream.read(); //read one byte from the input stream
            System.out.print((char)data);; //write that byte to the other stream.
        }

        inStream.close();
        reader.close();
    }
}