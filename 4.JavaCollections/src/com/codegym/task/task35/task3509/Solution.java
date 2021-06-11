package com.codegym.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics

*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //write your code here
        ArrayList<T> tArrayList = new ArrayList<>(elements.length);
        for (T element: elements
             ) {
            tArrayList.add(element);
        }
        return tArrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //write your code here
        HashSet<T> tHashSet = new HashSet<>(elements.length);
        for (T element: elements
        ) {
            tHashSet.add(element);
        }
        return tHashSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //write your code here
        if (keys.size() != values.size())
            throw new IllegalArgumentException();
        HashMap<K, V> hashMap = new HashMap<>(keys.size());
        for (int i = 0; i < keys.size(); i++) {
            hashMap.put(keys.get(i), values.get(i));
        }
        return hashMap;
    }
}
