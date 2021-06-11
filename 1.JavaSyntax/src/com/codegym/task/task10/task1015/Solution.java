package com.codegym.task.task10.task1015;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Array of string lists

*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //write your code here
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("123");
        list1.add("234");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("345");
        list2.add("456");

        ArrayList<String>[] arrayLists = new ArrayList[2];
        arrayLists[0] = list1;
        arrayLists[1] = list2;

        return arrayLists;

    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}