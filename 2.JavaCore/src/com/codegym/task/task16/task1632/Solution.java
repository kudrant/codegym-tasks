package com.codegym.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        Thread thread3 = new Thread3();
        Thread thread4 = new Thread4();
        Thread thread5 = new Thread5();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);

    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread implements Runnable {

        public void run() {
            while(true){
            }
        }

    }
    public static class Thread2 extends Thread {

        @Override
        public void run() {
            while (!isInterrupted()) {

            }
            System.out.println("InterruptedException");
        }
    }
    public static class Thread3 extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("Hurray");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Thread4 extends Thread implements Message {

        @Override
        public void run() {
            while(isAlive()){
            }
        }

        public void showWarning() {
            stop();
        }
    }
    public static class Thread5 extends Thread {


        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            int sum = 0;
            try {
                while (!(line = reader.readLine()).equals("N")) {
                    sum += Integer.parseInt(line);
                }
                System.out.println(sum);

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



}