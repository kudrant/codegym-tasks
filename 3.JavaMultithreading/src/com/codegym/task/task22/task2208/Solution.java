package com.codegym.task.task22.task2208;


import java.util.HashMap;
import java.util.Map;

/* 
Build a WHERE query

*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> params1 = new HashMap<>();
        params1.put("name", "Johnson");
        params1.put("country", "United States");
        params1.put("city", "Los Angeles");
        params1.put("age", null);

        getQuery(params1);


    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry: params.entrySet()
             ) {
            if (entry.getValue() == null || entry.getValue() == null)
                continue;
            if (entry.getValue().equals("null"))
                continue;

            sb.append(entry.getKey());
            sb.append(" = '");
            sb.append(entry.getValue());
            sb.append("' and ");
        }

        String result = sb.toString();
        if (result.length() == 0)
            return "";
        result = result.substring(0, result.length() - 5);
        System.out.println(result);
        return result;
    }
}
