package com.codegym.task.task18.task1808;

/* 
Splitting a file

*/

import java.io.*;

public class Solution {
    static final boolean DEBUG = false;
    public static void main(String[] args) {
        try {
            FileInputStream fis1;
            FileOutputStream fos2;
            FileOutputStream fos3;
            if (!DEBUG) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                fis1 = new FileInputStream(reader.readLine());
                fos2 = new FileOutputStream(reader.readLine());
                fos3 = new FileOutputStream(reader.readLine());
                reader.close();
            }
            else {
                fis1 = new FileInputStream("c:/test.txt");
                fos2 = new FileOutputStream("c:/test2.txt");
                fos3 = new FileOutputStream("c:/test3.txt");
            }

            int fos1Size = 0;
            int fos2Size = 0;
            if (fis1.available() % 2 != 0) {
                fos1Size = fis1.available() / 2 + 1;
                fos2Size = fos1Size - 1;
            }
            else {
                fos1Size = fis1.available() / 2;
                fos2Size = fos1Size;
            }

            byte[] buffer1 = new byte[fis1.available()];
            byte[] buffer2 = new byte[fis1.available()];

            fis1.read(buffer1, 0 , fos1Size);
            fis1.read(buffer2, 0 , fos2Size);

            fos2.write(buffer1,0, fos1Size);
            fos3.write(buffer2, 0, fos2Size);

            fis1.close();
            fos2.close();
            fos3.close();


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
