package com.codegym.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Yet another adapter

*/

public class Solution {

    public static void main(String[] args) {

        String line = "John Michael Peterson 12 31 1950";
        String[] lineItems = line.split(" ");
        String dateStr = lineItems[3] + " " + lineItems[4] + " " + lineItems[5];
        Date date1 = new Date();

        try { date1 = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(dateStr); }
        catch (ParseException e) { System.out.println("ParseException was caught: " + e.getMessage()); }

        Person person = new Person(lineItems[2], lineItems[0], lineItems[1], date1);
        System.out.println(person);

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String line = this.fileScanner.nextLine();
            String[] lineItems = line.split(" ");
            String dateStr = lineItems[3] + " " + lineItems[4] + " " + lineItems[5];
            Date date1 = new Date();

            try { date1 = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(dateStr); }
            catch (ParseException e) { System.out.println("ParseException was caught: " + e.getMessage()); }

            Person person = new Person(lineItems[2], lineItems[0], lineItems[1], date1);
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();

        }
    }
}
