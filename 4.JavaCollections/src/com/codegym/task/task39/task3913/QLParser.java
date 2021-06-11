package com.codegym.task.task39.task3913;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QLParser<R> {
    //        private static final String REGEXP = "(?:get (ip|user|date|event|status))(?:$|(?: for (ip|user|date|event|status) = \"(.*?)\"))";
    private static final String REGEXP = "(?:get (ip|user|date|event|status))(?:$|(?: for (ip|user|date|event|status) = \"(.*?)\"))?(?:$| and date between \"(.*?)\" and \"(.*?)\")?";
    //    private static final String REGEXP = "(?:get\\s([a-z]+))(?:$|(?:\\sfor\\s([a-z]+)\\s=\\s\"([a-zA-Z\\s]+|\\d{1,2}\\.\\d{1,2}\\.(?:\\d{4}|\\d{2})\\s\\d{1,2}:\\d{1,2}:\\d{1,2})\"))";
//    private static final String REGEXP = "(?:get\\s([a-z]+))(?:$|(?:\\sfor\\s([a-z]+)\\s=\\s\"([a-zA-Z\\s]+|\\d{1,2}\\.\\d{1,2}\\.(?:\\d{4}|\\d{2})\\s\\d{1,2}:\\d{1,2}:\\d{1,2})\"))(?:$|\\sand\\sdate\\sbetween\\s\"(\\d{1,2}\\.\\d{1,2}\\.(?:\\d{4}|\\d{2})\\s\\d{1,2}:\\d{1,2}:\\d{1,2})\"\\sand\\s\"(\\d{1,2}\\.\\d{1,2}\\.(?:\\d{4}|\\d{2})\\s\\d{1,2}:\\d{1,2}:\\d{1,2})\")";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private String QLGetValue = null;
    private String QLForKey = null;
    private String QLForValue = null;
    private String QLBetweenAfter = null;
    private String QLBetweenBefore = null;

    public QLParser(String QLString) {
        this.matchParts(QLString);
    }

    private void matchParts(String query) {
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(query);
        if (matcher.matches()) {
            this.QLGetValue = matcher.group(1);
            this.QLForKey = matcher.group(2);
            this.QLForValue = matcher.group(3);
            this.QLBetweenAfter = matcher.group(4);
            this.QLBetweenBefore = matcher.group(5);
        }
    }

    public R mapper(LogEntry entry) {
        if (this.QLGetValue != null) {
            switch (this.QLGetValue) {
                case "ip": {
                    return (R) entry.ip;
                }
                case "user": {
                    return (R) entry.name;
                }
                case "date": {
                    return (R) entry.date;
                }
                case "event": {
                    return (R) entry.event;
                }
                case "status": {
                    return (R) entry.status;
                }
            }
        }
        return (R) entry;
    }

    public boolean filter(LogEntry entry) {
        boolean result = true;
        if (this.QLForKey != null) {
            result = filterFor(entry);
        }
        if (QLBetweenAfter != null && QLBetweenBefore != null) {
            result = result && filterAfterAndBefore(entry);
        }
        return result;
    }

    public boolean filterFor(LogEntry entry) {
        if (this.QLForKey != null) {
            switch (this.QLForKey) {
                case "user": {
                    return entry.name.equals(this.QLForValue);
                }
                case "date": {
                    try {
                        Date date = DATE_FORMAT.parse(this.QLForValue);
                        return entry.date.equals(date);
                    } catch (ParseException e) {
                        return false;
                    }
                }
                case "event": {
                    return entry.event.equals(Event.valueOf(this.QLForValue.toUpperCase()));
                }
                case "status": {
                    return entry.status.equals(Status.valueOf(this.QLForValue.toUpperCase()));
                }
                case "ip": {
                    return entry.ip.equals(this.QLForValue);
                }
            }
        }
        return true;
    }

    public boolean filterAfterAndBefore(LogEntry entry) {
        if (QLBetweenAfter != null && QLBetweenBefore != null) {
            try {
                Date after = DATE_FORMAT.parse(this.QLBetweenAfter);
                Date before = DATE_FORMAT.parse(this.QLBetweenBefore);
                return entry.isInDateRange(after, before);
            } catch (ParseException e) {
                System.out.println("Unable to parse date filter");
            }
        }
        return true;
    }

}
