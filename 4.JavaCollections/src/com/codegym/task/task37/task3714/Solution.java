package com.codegym.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Ancient Rome

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman numeral to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result: " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        StringBuffer sbuf = new StringBuffer(s.trim());

        Map<Integer, String> romanNumerals = new LinkedHashMap<>();
        romanNumerals.put(3000, "MMM");
        romanNumerals.put(2000, "MM");
        romanNumerals.put(900, "CM");
        romanNumerals.put(1000, "M");
        romanNumerals.put(800, "DCCC");
        romanNumerals.put(700, "DCC");
        romanNumerals.put(600, "DC");
        romanNumerals.put(400, "CD");
        romanNumerals.put(500, "D");
        romanNumerals.put(300, "CCC");
        romanNumerals.put(200, "CC");
        romanNumerals.put(90, "XC");
        romanNumerals.put(100, "C");
        romanNumerals.put(80, "LXXX");
        romanNumerals.put(70, "LXX");
        romanNumerals.put(60, "LX");
        romanNumerals.put(40, "XL");
        romanNumerals.put(50, "L");
        romanNumerals.put(30, "XXX");
        romanNumerals.put(20, "XX");
        romanNumerals.put(9, "IX");
        romanNumerals.put(10, "X");
        romanNumerals.put(8, "VIII");
        romanNumerals.put(7, "VII");
        romanNumerals.put(6, "VI");
        romanNumerals.put(4, "IV");
        romanNumerals.put(5, "V");
        romanNumerals.put(3, "III");
        romanNumerals.put(2, "II");
        romanNumerals.put(1, "I");

        //Find Patterns
        int result = 0;
        for (Map.Entry<Integer, String> entry : romanNumerals.entrySet()) {
            int position = sbuf.indexOf(entry.getValue());
            if (!(position < 0)) {
                result += entry.getKey();
                sbuf.delete(position, position + entry.getValue().length());
            }
            if (sbuf.length() == 0)
                break;
        }
        return result;
    }
}
