package com.codegym.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("Belka", 3, 0);
        Horse horse2 = new Horse("Strelka", 3, 0);
        Horse horse3 = new Horse("Tarelka", 3, 0);
        List<Horse> currentHorses = new ArrayList<>();
        currentHorses.add(horse1);
        currentHorses.add(horse2);
        currentHorses.add(horse3);
        game = new Hippodrome(currentHorses);

        game.run();
        game.printWinner();

    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (int i = 1; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > winner.getDistance())
                winner = horses.get(i);
        }

        return winner;
    }

    public void printWinner() {
        System.out.println("The winner is " + getWinner().getName() + "!");
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {

            move();
            print();
            Thread.sleep(200);
        }

    }
    public void  move() {
        for (Horse horse: horses
        ) {
            horse.move();
        }

    }
    public void print() {
        for (Horse horse: horses
        ) {
            horse.print();

        }
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
        
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
