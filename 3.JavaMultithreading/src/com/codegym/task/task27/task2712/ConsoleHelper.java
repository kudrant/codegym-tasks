package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Please select your dishes. To finish enter 'exit'");
        writeMessage(Dish.allDishesToString());
        List<Dish> selectedDishes = new ArrayList<>();
        String entredDish;
        boolean isFound;

        while (!(entredDish = readString()).equalsIgnoreCase("exit")) {
            isFound = false;
            if (entredDish.isEmpty()) {
                writeMessage("You entered an empty string");
                writeMessage("Please select your dishes. To finish enter 'exit");
                writeMessage(Dish.allDishesToString());
                continue;
            }
            for (Dish dish: Dish.values()
                 ) {
                if (entredDish.equalsIgnoreCase(dish.name())) {
                    selectedDishes.add(dish);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                writeMessage("There is no such dish");
                writeMessage("Please select your dishes. To finish enter 'exit");
                writeMessage(Dish.allDishesToString());
            }
        }
        return selectedDishes;
    }
}
