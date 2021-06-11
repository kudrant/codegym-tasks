package com.codegym.task.task14.task1420;

/* 
GCD

*/

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a,b, maxDivisor;

        try {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
            if (a <= 0)
                throw new NumberFormatException("number must be positive");
            if (b <= 0)
                throw new NumberFormatException("number must be positive");
            maxDivisor = 1;
            if (a <= b) {
                for (int i = 2; i <= a; i++) {
                    if (a % i == 0 && b % i == 0)
                        maxDivisor = i;
                } 
            }
            else {
                for (int i = 2; i <= b; i++) {
                    if (a % i == 0 && b % i == 0)
                        maxDivisor = i;
                }
            }
            System.out.println(maxDivisor);

        }
        catch (NumberFormatException e) {
            throw e;
        }





    }

}
