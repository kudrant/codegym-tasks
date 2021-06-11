package com.codegym.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Password generator

*/
public class Solution {


    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();


        for (int i = 0; i < 5; i++) {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    baos.write(genDigit());
                    hasDigit = true;
                    break;
                case 1:
                    baos.write(genUpper());
                    hasUpper = true;
                    break;
                case 2:
                    baos.write(genLower());
                    hasLower = true;
                    break;
            }
        }
        if (!hasDigit) baos.write(genDigit());
        else baos.write(genAny());

        if(!hasUpper) baos.write(genUpper());
        else baos.write(genAny());

        if(!hasLower) baos.write(genLower());
        else baos.write(genAny());

        return baos;
    }

    private static char genDigit() {
        return (char)(int) (48 + Math.random() * 10);
    }
    private static char genUpper() {
        return (char)(int) (65 + Math.random() * 26);
    }

    private static char genLower() {
        return (char)(int) (97 + Math.random() * 26);
    }

    private static char genAny() {
        int result = 48;
        switch ((int) (Math.random() * 3)) {
            case 0:
                result = genDigit();
                break;
            case 1:
                result = genUpper();
                break;
            case 2:
                result = genLower();
                break;
        }
        return (char)result;
    }
}