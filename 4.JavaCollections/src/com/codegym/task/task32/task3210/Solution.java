package com.codegym.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Using RandomAccessFile

*/

public class Solution {
    public static void main(String... args) throws Exception {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        String readText;

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(number);
        byte[] arr = new byte[text.length()];
        raf.read(arr, 0, text.length());
        readText = new String(arr);

        raf.seek(raf.length());
        if(text.equals(readText))
            raf.write("true".getBytes());
        else
            raf.write("false".getBytes());
        raf.close();
    }
}