package com.codegym.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) throws ParseException {
        // Start here

        switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i += 3) {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
                    Date d = sdf.parse(args[i + 2]);
                    synchronized (allPeople) {
                        if (args[i + 1].equals("m"))
                            allPeople.add(Person.createMale(args[i], d));
                        else
                            allPeople.add(Person.createFemale(args[i], d));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;

            case "-u":
                for (int i = 1; i < args.length; i += 4) {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
                    Date d = sdf.parse(args[i + 3]);
                    synchronized (allPeople) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setBirthDate(d);
                        person.setName(args[i + 1]);
                        switch (args[i + 2]) {
                            case "m":
                                person.setSex(Sex.MALE);
                                break;
                            case "f":
                                person.setSex(Sex.FEMALE);
                        }
                    }
                }
                break;

            case "-d":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        allPeople.remove(Integer.parseInt(args[i]));
                        Person person = Person.createMale(null, null);
                        person.setSex(null);
                        allPeople.add(Integer.parseInt(args[i]), person);
                    }
                }
                break;

            case  "-i":
                for (int i = 1; i < args.length ; i++) {
                    int index = Integer.parseInt(args[i]);
                    synchronized (allPeople) {
                        Person person = allPeople.get(index);
                        String name = person.getName();
                        String sex = "";
                        if (person.getSex() == Sex.MALE)
                            sex = "m";
                        else
                            sex = "f";
                        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
                        System.out.println(name + " " + sex + " " + sdf.format(person.getBirthDate()));
                    }
                }
        }
    }
}
