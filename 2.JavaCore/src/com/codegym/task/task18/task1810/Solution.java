package com.codegym.task.task18.task1810;

/* 
DownloadException

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {

        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int size = fis.available();


        while (size >= 1000) {
            fis = new FileInputStream(reader.readLine());
            size = fis.available();
        }

        fis.close();
        throw new DownloadException();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class DownloadException extends Exception {

    }
}
