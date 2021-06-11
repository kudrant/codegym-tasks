package com.codegym.task.task18.task1817;

/* 
Spaces

*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    static final boolean DEBUG = false;
    public static void main(String[] args) {
        try {
            String filename;

            if(DEBUG)
                filename = "C:/test.txt";
            else
                filename = args[0];

            FileInputStream fis = new FileInputStream(filename);
            int spaces = 0;
            int characters = fis.available();
            while (fis.available() > 0) {
                int data = fis.read();
                if (data == 32)
                    spaces++;
            }
            fis.close();
            double result = (double)spaces / characters * 100;

            System.out.printf("%.2f\n", result);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
