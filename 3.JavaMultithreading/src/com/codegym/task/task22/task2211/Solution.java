package com.codegym.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

/* 
Changing the encoding

*/
public class Solution {
    private static final boolean DEBUG = false;
    public static void main(String[] args) throws IOException {
        String fileName1 = "";
        String fileName2 = "";
        if (DEBUG) {
            fileName1 = "C:/test.txt";
            fileName2 = "C:/test2.txt";
        }
        else {
            fileName1 = args[0];
            fileName2 = args[1];
        }

        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos = new FileOutputStream(fileName2);

        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        String s = new String(buffer, "Windows-1251");
        buffer = s.getBytes("UTF-8");
        fos.write(buffer);
        fis.close();
        fos.close();

    }
}
