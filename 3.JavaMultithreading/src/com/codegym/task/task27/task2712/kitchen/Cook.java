package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;


    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object arg) { //
        Order order = (Order) arg;
        //Start cooking - Your order: [Soup, Juice, Water] from Tablet{number=5}, cooking time 23 min
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + " min");
        setChanged();
        notifyObservers(arg);
    }

    @Override
    public String toString() {
        return name;
    }
}
