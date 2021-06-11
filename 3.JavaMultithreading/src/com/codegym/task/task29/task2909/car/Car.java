package com.codegym.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    static public final int MAX_TRUCK_SPEED = 80;
    static public final int MAX_SEDAN_SPEED = 120;
    static public final int MAX_CABRIOLET_SPEED = 90;


    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    protected Car(){}

    public Car(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case 0:
                return new Truck(numberOfPassengers);
            case 1:
                return new Sedan(numberOfPassengers);
            case 2:
                return new Cabriolet(numberOfPassengers);
            default:
                throw new IllegalArgumentException("No such type");
        }
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        int start = date.compareTo(summerStart);
        int end = date.compareTo(summerEnd);
        if (start >= 0 && end <= 0 )
            return true;
        else
            return false;
    }

    public void fill(double numberOfGallons) {
        if (numberOfGallons < 0)
            throw new IllegalArgumentException("Number of gallons is negative");
        fuel += numberOfGallons;

    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        double consumption;
        if (isSummer(date, summerStart, summerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersThatCanBeCarried() {
        if (canPassengersBeCarried())
            return numberOfPassengers;
        else return 0;
    }

    private boolean canPassengersBeCarried() {
        if (isDriverAvailable() && fuel > 0)
            return true;
        else return false;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengerBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengerBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}