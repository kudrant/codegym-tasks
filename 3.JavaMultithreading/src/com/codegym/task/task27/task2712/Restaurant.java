package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Cook;
import com.codegym.task.task27.task2712.kitchen.Order;
import com.codegym.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

public class Restaurant {


    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        Waiter waiter = new Waiter();

        tablet.addObserver(cook);
        cook.addObserver(waiter);
        tablet.createOrder();
    }
}
