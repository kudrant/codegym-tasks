package com.codegym.task.task24.task2408;

import java.text.SimpleDateFormat;

public abstract class SuperDog {
    protected String getSuperQuotes(String name) {

        return " *** " + name + " *** ";
    }

    protected SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd-MMM-yyyy");
}
