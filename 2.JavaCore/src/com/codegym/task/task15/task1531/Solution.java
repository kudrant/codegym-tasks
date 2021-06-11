package com.codegym.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Factorial

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //write your code here
        BigInteger prod = BigInteger.ONE;
        if (n < 0) {
            prod = BigInteger.ZERO;
        }

        else {
            for (int x = 1; x <= n; x++) {
                prod = prod.multiply(BigInteger.valueOf(x));
            }
        }

        return prod.toString();
    }
}
