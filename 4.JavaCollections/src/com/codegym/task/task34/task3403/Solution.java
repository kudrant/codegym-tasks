package com.codegym.task.task34.task3403;

/* 
Factorization using recursion

*/
public class Solution {
    public void recurse(int n) {
        for (int i = 2; i <= n ; i++) {
            if (n % i == 0) {
                if (i != n) {
                    System.out.print(i + " ");
                    recurse(n / i);
                }
                else
                    System.out.println(i);
                break;
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
    }
}