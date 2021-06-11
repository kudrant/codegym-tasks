package com.codegym.task.task16.task1630;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //write your code here
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //write your code here
        f.join();
        System.out.println(f.getFileContents());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContents();

        void join() throws InterruptedException;

        void start();
    }

    //write your code here
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileContents = "";
        private String fileName = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContents() {

            return fileContents;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName), StandardCharsets.UTF_8))){
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContents += line + " ";
                }
                reader.close();
            } catch (IOException e) {
                // log error
            }
        }
    }
}
