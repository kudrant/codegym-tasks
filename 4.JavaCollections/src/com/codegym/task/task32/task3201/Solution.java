package com.codegym.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Writing to an existing file

*/
public class Solution {
    public static void main(String... args) throws Exception {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        if(raf.length() <= number)
            raf.seek(raf.length());
        else
            raf.seek(number);
        raf.write(text.getBytes());
        raf.close();
    }
}
