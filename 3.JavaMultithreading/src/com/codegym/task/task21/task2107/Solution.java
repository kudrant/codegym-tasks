package com.codegym.task.task21.task2107;

import java.io.ObjectInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Deep cloning of a map

*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        Solution clone = (Solution) super.clone();
        clone.users = new LinkedHashMap<>();
        for (Map.Entry<String, User> entry: users.entrySet()
             ) {
            clone.users.put(entry.getKey(), entry.getValue());
        }
        return clone;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
