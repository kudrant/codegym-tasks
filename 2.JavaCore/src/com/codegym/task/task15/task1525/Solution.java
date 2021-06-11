package com.codegym.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
File in a static block

*/

public class Solution {

    public static List<String> lines = new ArrayList<>();

    static {

        try {
            Reader reader = new FileReader(Statics.FILE_NAME);
            BufferedReader buffReader = new BufferedReader(reader);

            while (buffReader.ready()) {
                lines.add(buffReader.readLine());
            }

            reader.close();
            buffReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
        catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
