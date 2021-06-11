package com.codegym.task.task19.task1906;

/* 
Even characters

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader reader1 = new FileReader(fileName1);
        FileWriter writer = new FileWriter(fileName2);
        boolean even = false;
        while (reader1.ready()) {
            int data = reader1.read();
            if (!even) {
                even = true;
            }
            else {
                even = false;
                writer.write(data);
            }

        }
        reader1.close();
        writer.close();
    }

}
