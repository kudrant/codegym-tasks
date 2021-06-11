package com.codegym.task.task14.task1419;


import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.ZipException;

/* 
Exception invasion

*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   // The first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //write your code here
        try {
            throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            exceptions.add(e);
        }

        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            throw new DataFormatException();
        } catch (DataFormatException e) {
            exceptions.add(e);
        }
        try {
            throw new SecurityException();
        } catch (SecurityException e) {
            exceptions.add(e);
        }
        try {
            throw new ZipException();
        } catch (ZipException e) {
            exceptions.add(e);
        }
        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            exceptions.add(e);
        }
        try {
            throw new NegativeArraySizeException();
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

    }
}
