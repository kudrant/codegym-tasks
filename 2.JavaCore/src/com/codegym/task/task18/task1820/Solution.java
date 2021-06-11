package com.codegym.task.task18.task1820;

/* 
Rounding numbers

*/

import java.io.*;
import java.util.ArrayList;

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
            reader.close();

            FileInputStream fis1 = new FileInputStream(fileName1);
            FileOutputStream fos2 = new FileOutputStream(fileName2);
            String floatStr = "";
            while (fis1.available() > 0) {
                int data = fis1.read();
                floatStr += (char)data;
            }
            fis1.close();
            System.out.println(floatStr);
            String [] numbers = floatStr.split(" ");

            for (String strNum: numbers
                 ) {
                float f = Float.parseFloat(strNum);

                int n = Math.round(f);
                String str = Integer.toString(n);
                for (char ch: str.toCharArray()
                     ) {
                    int code = (int)ch;
                    fos2.write(code);
                }
                fos2.write(32);
            }
            fos2.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
