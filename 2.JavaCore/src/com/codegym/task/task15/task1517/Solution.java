package com.codegym.task.task15.task1517;

/* 
Static modifiers and exceptions

*/

import java.io.IOException;

public class Solution {
    public static int A = 0;

    static {
        // Throw an exception here
        if (1 < 2)
            throw new NullPointerException();
        else
            A = 0;

    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
