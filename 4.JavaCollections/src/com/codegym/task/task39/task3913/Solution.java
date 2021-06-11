package com.codegym.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\logs"));
        //LogParser logParser = new LogParser(Paths.get("Z:\\01\\fileserver\\eugen\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        System.out.println(logParser.execute("get ip for user = \"Eduard Bentley\""));
        System.out.println(logParser.execute("get date for event = \"LOGIN\" and date between \"11.12.2013 0:00:00\" and \"07.01.2021 20:22:55\""));
        System.out.println(logParser.execute("get ip for status = \"ERROR\" and date between \"03.11.2014 12:56:22\" and \"29.2.31020 5:4:8\""));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));
        System.out.println(logParser.execute("get ip"));

    }
}