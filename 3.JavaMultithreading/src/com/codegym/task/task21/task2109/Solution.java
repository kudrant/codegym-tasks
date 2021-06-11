package com.codegym.task.task21.task2109;

/* 
Prevent cloning

*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
           // super(i, j);
            this.name = name;
        }

        public B clone() throws CloneNotSupportedException{
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return this.name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public C clone() {
            return new C(0, 0, null);
        }
    }

    public static void main(String[] args) {

    }
}
