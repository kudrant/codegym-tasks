package com.codegym.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();

        t1.join();
        t2.start();
        t2.join();
        //write your code here

        t1.printResult();
        t2.printResult();
    }

    //write your code here
    public static class Read3Strings extends Thread {
        private String line = "";
        public Read3Strings() {
            super();
        }

        @Override
        public void run() {

            try {
                line += reader.readLine() + " ";
                line += reader.readLine() + " ";
                line += reader.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void printResult() {
            System.out.println(line);
        }
    }
}
