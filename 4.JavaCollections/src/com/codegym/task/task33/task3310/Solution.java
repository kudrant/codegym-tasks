package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String str: strings
             ) {
            result.add(shortener.getId(str));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long key: keys
             ) {
            result.add(shortener.getString(key));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        //6.2.3.1. Display the name of the class strategy. The name must not include the package name.
        Helper.printMessage(strategy.getClass().getSimpleName());
        //6.2.3.2. Generate a test set using Helper and the specified number of elements (elementsNumber).
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }
        //6.2.3.3. Create a Shortener object using the passed strategy.
        Shortener shortener = new Shortener(strategy);

        //6.2.3.4. Measure and display the time required to run the getIds method for the given strategy
        // and the given set of elements. Display time in milliseconds. When measuring the method's execution time,
        // you can ignore the processor switching to other threads, as well as the time spent on the call itself,
        // returning values, and calling methods to get the time (date). Measure time using Date objects.
        Date startTime = new Date();
        Set<Long> idSet = getIds(shortener, strings);
        Date endTime = new Date();
        long timePassed = endTime.getTime() - startTime.getTime();
        Helper.printMessage(Long.toString(timePassed));

        //6.2.3.5. Measure and display the time required to run the getStrings method for a given strategy
        // and the set of identifiers obtained in the previous clause.
        startTime = new Date();
        Set<String> stringSet = getStrings(shortener, idSet);
        endTime = new Date();
        timePassed = endTime.getTime() - startTime.getTime();
        Helper.printMessage(Long.toString(timePassed));

        //6.2.3.6. Check whether the contents of the set of generated strings and the set returned by getStrings
        // method are the same. If the sets are the same, then display "The test passed.". Otherwise, display "The test failed.".

        if(strings.equals(stringSet))
            Helper.printMessage("The test passed.");
        else
            Helper.printMessage("The test failed.");



    }

    public static void main(String[] args) {
        StorageStrategy strategyTest = new HashMapStorageStrategy();
        testStrategy(strategyTest, 10000);
    }
}
