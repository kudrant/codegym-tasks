package com.codegym.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Read online about the median of a sample

*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        double median;

        int arLength = array.length;      // check if total number of scores is even
        if (arLength % 2 == 0) {         // calculate average of middle elements
            median = ((double) array[arLength / 2] + array[arLength / 2 - 1]) / 2;
        } else {             // get the middle element
            median = (double) array[arLength / 2];
        }

        Comparator<Integer> compareMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {

                long result = Math.round(Math.abs(i1 - median) - Math.abs(i2 - median));
                return (int)result;
            }
        };

        Arrays.sort(array, compareMedian);

        return array;
    }
}
