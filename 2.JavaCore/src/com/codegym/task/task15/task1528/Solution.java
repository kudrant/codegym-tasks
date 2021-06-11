package com.codegym.task.task15.task1528;

/* 
OOP: The Euro is money too

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Euro().getAmount());
    }

    public static abstract class Money {
        abstract double getMoney();

        public Object getAmount() {
            return getMoney();
        }
    }

    // Add your code below
    public static class Euro extends Money {
        double amount = 123d;

        public Object getAmount(){
            return this.amount;
        }

        public double getMoney() {
            return amount;
        }
    }
}
//
//public class Solution {
//    public static void main(String[] args) {
//        System.out.println(new Euro().getAmount());
//    }
//
//    public static abstract class Money {
//        abstract double getMoney();
//
//        public Object getAmount() {
//            return getMoney();
//        }
//    }
//
//    // Add your code below
//
//
//    public static class Euro extends Money {
//
//        private double amount = 123d;
//
//        public Object  getMoney() {
//            return this;
//        }
//
//        @Override
//        public Euro getAmount() {
//            return this.amount;
//        }
//
//
//    }
//}
