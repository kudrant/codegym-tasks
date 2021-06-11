package com.codegym.task.task14.task1410;

/* 
Wine tasting

*/

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getCelebrationName());
        System.out.println(getBubblyWine().getCelebrationName());
        System.out.println(getWine().getCelebrationName());
    }

    public static Drink getDeliciousDrink() {
        Drink drink = new Wine();
        return drink;
    }

    public static Wine getWine() {
        Wine wine = new Wine();
        return wine;

    }

    public static Wine getBubblyWine() {
        Wine bubblyWine = new BubblyWine();
        return bubblyWine;

    }
}
