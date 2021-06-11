package com.codegym.task.task38.task3803;

/* 
Runtime exceptions (unchecked exceptions)

*/

import java.util.ArrayList;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object ch = '@';
        System.out.println((Byte)ch);
    }

    public void methodThrowsNullPointerException() {
        ArrayList<Integer> arrayList = null;
        System.out.println(arrayList.get(1));

    }

    public static void main(String[] args) {

    }
}