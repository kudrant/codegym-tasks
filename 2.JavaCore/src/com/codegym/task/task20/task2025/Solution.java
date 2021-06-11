package com.codegym.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/*
Number algorithms

*/
public class Solution {
    static TreeSet<Long> numbers;
    static long[][] pows;
    static int digits[];
    public static void genpow(int m){
        pows = new long[10][m];
        for(int i = 0; i < 10; i++){
            long p =1;
            for(int j = 0; j < m; j++){
                p *= i;
                pows[i][j] = p;
            }
        }
    }

    public static long[] getNumbers(long N) {
        if(N <= 0)return new long[0];

        int digCount = 1 + (int)Math.log10(N);
        System.out.println(digCount);
        if(N == 0) digCount = 1;


        genpow(digCount +1);
        numbers = new TreeSet<>();
        for(int i = 1; i <= digCount; i++){
            try{
                search(i, 0,0, 0);
            }catch (Exception e){
                System.out.println("Error for number: " + i);
            }
        }
        Iterator<Long> iter = numbers.iterator();
        while (iter.hasNext()){
            long l = iter.next();
            if( l>= N) iter.remove();
        }
        long[] result = new long[numbers.size()];
        int i = 0;
        for(long l: numbers){
            result[i] = l;
            i++;
        }
        return result;
    }

    public static void search(int N, int d, long pow, int index){
        if(d == N+1){
            if(check(pow)){
                numbers.add(pow);
            }
            //return;
        }else {
            for(int i = index; i< 10; i++){
                try{
                    search(N, d+1, pow+pows[i][N-1], i);
                }catch (Exception e){

                }
            }
        }
    }



    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        long arr[] = getNumbers(922399);
        //System.out.println(System.currentTimeMillis() - start);
        for(long l: arr){
            System.out.println(l);
        }
        System.out.println(arr.length);

    }



    public static boolean check(long number){
        if(number == 0) return false;
        long temp = number;
        digits = new int[10];
        int n = 0;
        long sum = 0;
        while (temp > 0){
            int digit = (int)(temp%10);
            digits[digit]++;
            n++;
            temp /=10;
        }
        for(int i = 0; i < 10; i++){
            sum += digits[i]*pows[i][n -1];
        }

        if(sum == number)return true;

        return false;
    }

}