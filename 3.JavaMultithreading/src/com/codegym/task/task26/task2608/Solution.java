package com.codegym.task.task26.task2608;

/* 
A wise man thinks once before speaking twice

*/
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        Integer result1 = 0;
        synchronized(result1)  {
            result1 = var1 + var2;
        }

        return result1;
    }

    public int getSumOfVar3AndVar4() {
        Integer result2 = 0;
        synchronized (result2) {
            result2 = var1 + var2;
        }

        return result2;

    }

    public static void main(String[] args) {

    }
}
