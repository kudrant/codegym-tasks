package com.codegym.task.task21.task2112;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Kind Emma and the summer holidays

*/

public class Month {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Brimage", df.parse("JUNE 2 1982"));
        map.put("Mosley", df.parse("AUGUST 15 1986"));
        map.put("Williams", df.parse("MARCH 2 1960"));
        map.put("Heard", df.parse("JULY 30 1970"));
        map.put("McMillian", df.parse("SEPTEMBER 28 1956"));
        map.put("Dejarnette", df.parse("DECEMBER 25 1972"));
        map.put("Streeter", df.parse("JUNE 30 1980"));
        map.put("Albert", df.parse("FEBRUARY 7 2011"));
        map.put("Whitfield", df.parse("JULY 3 2014"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            int monthNumber;
            Map.Entry<String,Date> pair = iterator.next();
            Calendar cal = Calendar.getInstance();
            cal.setTime(pair.getValue());
            monthNumber = cal.get(Calendar.MONTH);
            if (monthNumber >= 5 && monthNumber <= 7)
                map.remove(pair.getKey());
        }


    }

    public static void main(String[] args) throws ParseException {
        removeAllSummerPeople(createMap());

    }

}
