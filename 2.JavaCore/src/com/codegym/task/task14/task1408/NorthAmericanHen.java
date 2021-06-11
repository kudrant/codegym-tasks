package com.codegym.task.task14.task1408;

public class NorthAmericanHen extends Hen {
    @Override
    public int getMonthlyEggCount() {
        return 30;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " I come from " + Continent.NORTHAMERICA + ". I lay " + getMonthlyEggCount() + " eggs a month.";
    }
}
