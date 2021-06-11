package com.codegym.task.task18.task1816;

/* 
ABCs

*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            int counter = 0;
            while (fis.available() > 0) {
                int data = fis.read();

                if ((data >= 65 && data <= 90) || (data >= 97 && data <= 122)) {
                    counter++;
                }
            }
            fis.close();
            System.out.println(counter);


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
