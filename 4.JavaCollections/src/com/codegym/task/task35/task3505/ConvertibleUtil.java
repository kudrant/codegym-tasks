package com.codegym.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertibleUtil {

    public static <T extends Convertible> Map  convert(List<T> list) {
        Map result = new HashMap();
        for(T item: list)
            result.put(item.getKey(), item);

        return result;
    }
}