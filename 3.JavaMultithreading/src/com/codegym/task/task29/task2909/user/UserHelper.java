package com.codegym.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnna = new User("Anna", "Larsen", 10);
    private User userRoman = new User("Roman", "Crouch", 30);

    public void printUsers() {
        userAnna.printInfo();
        userAnna.printAdditionalInfo();

        userRoman.printInfo();
        userRoman.printAdditionalInfo();
    }



    public int calculateAverageAge() {
        //int age = 28;
        //User userGeorge = new User("George", "Carp", age);

        return (userAnna.getAge() + userRoman.getAge() + 28) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasJob, boolean hasHouse) {
//        base.set(base.get() + age / 100);
//        base.set((int) (base.get() * (hasJob ? 1.1 : 0.9)));
//        base.set((int) (base.get() * (hasHouse ? 1.1 : 0.9)));
//
        return (int) ((base.get() + age / 100) * (hasJob ? 1.1 : 0.9) * (hasHouse ? 1.1 : 0.9));
    }

    public String getBossName(User user) {
        return user.getBoss();
    }
}