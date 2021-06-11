package com.codegym.task.task25.task2502;

import java.util.*;

/* 
Don't take the car to the shop!

*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            // Init wheels here
            wheels = new ArrayList<>();
            String[] wheelsArray = loadWheelNamesFromDB();
            if (wheelsArray.length != 4)
                throw new IllegalArgumentException();

            for (String wheel: wheelsArray
                 ) {

                switch (wheel) {
                    case "FRONT_LEFT":
                        if (wheels.contains(Wheel.FRONT_LEFT))
                            throw new IllegalArgumentException();
                        wheels.add(Wheel.FRONT_LEFT);
                        break;
                    case "FRONT_RIGHT":
                        if (wheels.contains(Wheel.FRONT_RIGHT))
                            throw new IllegalArgumentException();
                        wheels.add(Wheel.FRONT_RIGHT);
                        break;
                    case "BACK_LEFT":
                        if (wheels.contains(Wheel.BACK_LEFT))
                            throw new IllegalArgumentException();
                        wheels.add(Wheel.BACK_LEFT);
                        break;
                    case "BACK_RIGHT":
                        if (wheels.contains(Wheel.BACK_RIGHT))
                            throw new IllegalArgumentException();
                        wheels.add(Wheel.BACK_RIGHT);
                        break;
                    default:
                        throw new IllegalArgumentException();

                }
            }


        }

        protected String[] loadWheelNamesFromDB() {
            // This method returns mock data
            //return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
            //return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT", "BACK_MIDDLE"};
            //return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT"};
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_RIGHT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        System.out.println(new Car().wheels);
    }
}
