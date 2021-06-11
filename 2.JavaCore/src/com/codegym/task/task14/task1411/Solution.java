package com.codegym.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, loser, coder and programmer

*/

public class Solution implements Person{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key;
        ArrayList<String> allowedKeys = new ArrayList<>();
        allowedKeys.add("user");
        allowedKeys.add("loser");
        allowedKeys.add("coder");
        allowedKeys.add("programmer");

        //ArrayList<String> enteredKeys = new ArrayList<>();

        // Here's the loop for reading the keys. Item 1
        while (true) {
            key = reader.readLine();
            if (allowedKeys.contains(key)) {


                switch (key) {
                    case ("user"):
                        person = new User();
                        break;
                    case ("loser"):
                        person = new Loser();
                        break;
                    case ("coder"):
                        person = new Coder();
                        break;
                    case ("programmer"):
                        person = new Programmer();
                        break;
                }
                doWork(person);
            }
                //enteredKeys.add(key);
            else break;
        }


            // Create an object. Item 2
          /*  for (String eKey: enteredKeys
                 ) {
                switch (eKey) {
                    case ("user"):
                        person = new User();
                        break;
                    case ("loser"):
                        person = new Loser();
                        break;
                    case ("coder"):
                        person = new Coder();
                        break;
                    case ("programmer"):
                        person = new Programmer();
                        break;
                }
                doWork(person);

            }

            doWork(person); // Call doWork
*/

    }

    public static void doWork(Person person) {
        // Item 3
        if (person instanceof User)
            ((User) person).live();
        if (person instanceof Loser)
            ((Loser) person).doNothing();
        if (person instanceof Coder)
            ((Coder) person).writeCode();
        if (person instanceof Programmer)
            ((Programmer) person).enjoy();

    }
}
