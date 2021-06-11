package com.codegym.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Mastering the static block

*/

public class Solution {
    public static void main(String[] args) {

    }
    public static CanFly result;
    static {
        //write your code here
        reset();

    }



    public static void reset() {
        //write your code here

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String flyingItem = reader.readLine();
            if (flyingItem.equals("helicopter")) {
                result = new Helicopter();
            }
            else if (flyingItem.equals("plane")) {
                int numPas = Integer.parseInt(reader.readLine());
                result = new Plane(numPas);
            }
            reader.close();


        }
        catch (IOException e) {
            e.getStackTrace();
        }

    }
}
