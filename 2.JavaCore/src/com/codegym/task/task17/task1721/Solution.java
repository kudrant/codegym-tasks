package com.codegym.task.task17.task1721;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = "";
        String fileName2 = "";
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Reader fileReader = new FileReader(fileName1);
            reader = new BufferedReader(fileReader);

            while (reader.ready()) {
                allLines.add(reader.readLine());
            }

            fileReader = new FileReader(fileName2);
            reader = new BufferedReader(fileReader);

            while (reader.ready()) {
                linesForRemoval.add(reader.readLine());
            }

            fileReader.close();
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        boolean isContains = true;

        for (String line: linesForRemoval
             ) {
            if (allLines.contains(line)) {
                continue;
            } else {
                isContains = false;
                break;
            }
        }

            if (isContains) {
                for (String lineToRemove: linesForRemoval
                     ) {
                    allLines.remove(lineToRemove);
                }
            }
            else {
                allLines.clear();
                throw new CorruptedDataException();
            }


    }
}
