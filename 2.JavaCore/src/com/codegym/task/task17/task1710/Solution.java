package com.codegym.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
        //allPeople.add(Person.createMale("Washington", new Date()));  // id=2


    }

    public static void main(String[] args) throws ParseException {
        // Start here
        if(args[0].equals("-c")) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
            Date d = sdf.parse(args[3]);
            if(args[2].equals("m"))
                allPeople.add(Person.createMale(args[1], d));
            else
                allPeople.add(Person.createFemale(args[1], d));
            System.out.println(allPeople.size()-1);
        }

        if(args[0].equals("-u")) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
            Date d = sdf.parse(args[4]);
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setBirthDate(d);
            person.setName(args[2]);
            switch (args[3]) {
                case "m":
                    person.setSex(Sex.MALE);
                    break;
                case "f":
                    person.setSex(Sex.FEMALE);
            }
        }
        if (args[0].equals("-d")) {
            allPeople.remove(Integer.parseInt(args[1]));
            Person person = Person.createMale(null, null);
            person.setSex(null);
            allPeople.add(Integer.parseInt(args[1]), person);
        }
        if (args[0].equals("-i")) {
            int index = Integer.parseInt(args[1]);
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
