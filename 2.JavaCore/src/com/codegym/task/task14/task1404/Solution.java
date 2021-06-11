package com.codegym.task.task14.task1404;

/* 
Cats

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String catKey = reader.readLine();
        while (!(catKey.equals(""))) {
            list.add(catKey);
            catKey = reader.readLine();
        }
        ArrayList<Cat> cats = new ArrayList<>();

        for (String cat: list
             ) {
            System.out.println(CatFactory.getCatByKey(cat));
            //cats.add(get)
        }
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("boss".equals(key)) {
                cat = new MaleCat("Big Boy");
            } else if ("miss".equals(key)) {
                cat = new FemaleCat("Missy");
            } else if ("smudge".equals(key)) {
                cat = new FemaleCat("Smudgey");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "I'm " + getName() + ", an alley cat";
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "I'm a cat powerhouse named " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "I'm a cute kitty named " + getName();
        }
    }
}
