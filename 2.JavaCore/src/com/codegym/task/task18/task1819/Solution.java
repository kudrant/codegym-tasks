package com.codegym.task.task18.task1819;

/* 
Combining files

*/

import java.io.*;

public class Solution {
    private static final boolean DEBUG = false;
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1, fileName2;
            if (DEBUG) {
                fileName1 = "C:/test.txt";
                fileName2 = "C:/test2.txt";
            } else {
                fileName1 = reader.readLine();
                fileName2 = reader.readLine();

            }
            FileInputStream fis1 = new FileInputStream(fileName1);
            byte[] buffer1 = new byte[fis1.available()];
            fis1.read(buffer1);
            fis1.close();
            FileOutputStream fos1 = new FileOutputStream(fileName1);
            FileInputStream fis2 = new FileInputStream(fileName2);
            byte[] buffer2 = new byte[fis2.available()];
            fis2.read(buffer2);
            fos1.write(buffer2);
            fos1.write(buffer1, 0, buffer1.length);

            fos1.close();
            fis2.close();


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
