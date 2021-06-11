package com.codegym.task.task18.task1824;

/* 
Files and exceptions

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = "";
        FileInputStream fis1 = null;
        try {
            while (true) {
                fileName1 = reader.readLine();
                fis1 = new FileInputStream(fileName1);
                fis1.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(fileName1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
