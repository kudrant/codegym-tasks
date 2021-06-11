package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.Tablet;
import com.codegym.task.task27.task2712.ConsoleHelper;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        int result = 0;
        for (Dish dish: dishes
             ) {
            result += dish.getDuration();
        }
        return result;
    }

    public boolean isEmpty() {
        return  (dishes.isEmpty());
    }

    @Override
    public String toString() {
        if (dishes.isEmpty())
            return "";
        else {
            return "Your order: " + dishes + " from " + tablet;
        }
    }
}
