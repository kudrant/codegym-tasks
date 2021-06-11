package com.codegym.task.task18.task1818;

/* 
Two in one

*/

import java.io.*;

public class Solution {
    private static final boolean DEBUG = false;
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1, fileName2, fileName3;
            if (DEBUG) {
                fileName1 = "C:/test.txt";
                fileName2 = "C:/test2.txt";
                fileName3 = "C:/test3.txt";
            }
            else {
                fileName1 = reader.readLine();
                fileName2 = reader.readLine();
                fileName3 = reader.readLine();
            }
            FileOutputStream fos1 = new FileOutputStream(fileName1);
            FileInputStream fis2 = new FileInputStream(fileName2);
            FileInputStream fis3 = new FileInputStream(fileName3);

            int size2 = fis2.available();
            int size3 = fis3.available();
            byte[] buffer2 = new byte[size2];
            byte[] buffer3 = new byte[size3];
            fis2.read(buffer2);
            fis3.read(buffer3);
            fos1.write(buffer2);
            fos1.close();
            fos1 = new FileOutputStream(fileName1, true);

            fos1.write(buffer3);

            fos1.close();
            fis2.close();
            fis3.close();


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
