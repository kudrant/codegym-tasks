package com.codegym.task.task19.task1908;

/* 
Picking out numbers

*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        //String fileName1 = "c:/test.txt";
        //String fileName2 = "c:/test2.txt";
        bufferedReader.close();

        String inputStr = "";
        bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        while (bufferedReader.ready()) {
            inputStr += bufferedReader.readLine();
        }
        bufferedReader.close();
        String outputStr = "";
        String[] strArray = inputStr.split(" ");
        for (String strItem: strArray
             ) {
            try {
                int n = Integer.parseInt(strItem);
                outputStr += strItem + " ";
            }
            catch (NumberFormatException e) {
                continue;
            }
        }
        outputStr = outputStr.substring(0, outputStr.length()-1);
        bufferedWriter.write(outputStr);

        bufferedWriter.close();

    }
}
