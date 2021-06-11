package com.codegym.task.task18.task1809;

/* 
Reversing a file

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fis = new FileInputStream(reader.readLine());
            FileOutputStream fos = new FileOutputStream(reader.readLine());
            reader.close();

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            for (int i = buffer.length-1; i >= 0 ; i--) {
                fos.write(buffer[i]);
            }

            fis.close();
            fos.close();


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
