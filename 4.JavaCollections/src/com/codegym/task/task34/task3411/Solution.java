package com.codegym.task.task34.task3411;

/* 
Tower of Hanoi

*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        if (numRings == 0) return;
        moveRing(a, c, b, numRings - 1);
        System.out.printf ("from %s to %s\n", a, b);
        moveRing(c, b, a, numRings - 1);


        //write your code here
    }
}