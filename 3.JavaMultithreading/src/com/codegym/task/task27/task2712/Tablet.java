package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.ad.AdvertisementManager;
import com.codegym.task.task27.task2712.ad.NoVideoAvailableException;
import com.codegym.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            //ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {

                try {
                    //System.out.println(order.getTotalCookingTime());
                    new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                }catch (NoVideoAvailableException e) {
                    logger.log(Level.INFO, "No video is available for the following order: " + order);
                }

                setChanged();
                notifyObservers(order);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
