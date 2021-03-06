package com.codegym.task.task13.task1315;

/* 
Tom, Jerry and Spike

*/

public class Solution {
    public static void main(String[] args) {

    }

    // Can move
    public interface CanMove {
        void move();
    }

    // Can be eaten
    public interface Edible {
        void beEaten();
    }

    // Can eat
    public interface CanEat {
        void eat();
    }

    public static class Dog implements CanEat, CanMove {
        @Override
        public void eat() {}

        @Override
        public void move() {}
    }

    public static class Cat implements CanEat, CanMove, Edible {

        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }

        @Override
        public void eat() {

        }
    }

    public static class Mouse implements CanMove, Edible {

        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }
    }
}