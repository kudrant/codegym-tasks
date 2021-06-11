package com.codegym.task.task10.task1013;

/* 
Human class constructors

*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Write your variables and constructors here
        private  String name;
        private  String eyecolor;
        private  int age;
        private int height;
        private int weight;
        private String haircolor;

        public Human(int age, String haircolor) {
            this.age = age;
            this.haircolor = haircolor;
        }


        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(int age, String haircolor, int height) {
            this.age = age;
            this.haircolor = haircolor;
            this.height = height;

        }

        public Human(int age, String haircolor, int weight, String eyecolor) {
            this.age = age;
            this.haircolor = haircolor;
            this.weight =weight;
            this.eyecolor = eyecolor;
        }

        public Human(String name, int age, String eyecolor, int weight, String haircolor ) {
            this.name = name;
            this.age = age;
            this.eyecolor = eyecolor;
            this.weight = weight;
            this.haircolor = haircolor;
        }

        public Human(String name, int age, int height, int weight, String haircolor, String eyecolor ) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.haircolor = haircolor;
            this.eyecolor = eyecolor;
        }

        public Human(String name, int age, int height, String eyecolor) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.eyecolor = eyecolor;
        }

        public Human(String name, int age, int weight) {
            this.name =name;
            this.age = age;
            this.weight = weight;
        }

        public Human(String name, int age, int height, int weight) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
        public Human (int age, String eyecolor, int height, String haircolor, String name){
            this.age =age;
            this.eyecolor = eyecolor;
            this.height = height;
            this.haircolor = haircolor;
            this.name = name;
            // Write your variables and constructors here
        }

    }
}
