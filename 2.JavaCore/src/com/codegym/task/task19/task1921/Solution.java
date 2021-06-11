package com.codegym.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
John Johnson

*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            Date birthDate = null;
            while (reader.ready()) {
                String [] line = reader.readLine().split(" ");
                int maxID = line.length - 1;
                String year = line[maxID];
                String day = line[maxID - 1];
                String month = line[maxID - 2];
                SimpleDateFormat formatter = new SimpleDateFormat("MM dd yyyy");
                birthDate = formatter.parse(month + " " + day + " " +  year);

                String name = "";
                for (int i = 0; i < maxID - 2; i++) {
                    name += line[i] + " ";
                }
                name = name.substring(0, name.length() - 1);
                Person person = new Person(name, birthDate);
                System.out.println(person.getName() + " " + person.getBirthDate());
                PEOPLE.add(person);
            }
            reader.close();





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
