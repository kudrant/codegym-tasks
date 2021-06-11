package com.codegym.task.task25.task2512;

import java.util.LinkedList;
import java.util.Stack;

/*
Charting our own course

*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        StringBuilder sb = new StringBuilder();
        Throwable ie = e;
        LinkedList<Throwable> eList = new LinkedList<>();

        while (ie.getCause() != null) {
            eList.push(ie);
            ie = ie.getCause();
        }
        eList.push(ie);
        for (Throwable th : eList) {
            System.out.println(th);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
