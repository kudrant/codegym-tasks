package com.codegym.task.task39.task3913;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry {
    public String ip;
    public String name;
    public Date date;
    public Event event;
    public Integer task = null;
    public Status status;

    public LogEntry(String line) {
        this.parseString(line);
    }

    public void parseString(String line) {
        String[] data = line.split("\t");
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        this.ip = data[0];
        this.name = data[1];
        try {
            this.date = df.parse(data[2]);
        } catch (ParseException e) {
            this.date = null;
        }
        String[] eventDetails = data[3].split(" ");
        this.event = Event.valueOf(eventDetails[0]);
        if (eventDetails.length > 1) this.task = Integer.parseInt(eventDetails[1]);
        this.status = Status.valueOf((data[4]));

    }

    public boolean isInDateRange(Date after, Date before) {
        boolean isAfter = after == null || this.date.after(after);
        boolean isBefore = before == null || this.date.before(before) ;

        return isAfter && isBefore;
    }
}
