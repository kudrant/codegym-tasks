package com.codegym.task.task33.task3310.tests;

import com.codegym.task.task33.task3310.Helper;
import com.codegym.task.task33.task3310.Shortener;
import com.codegym.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startTime = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        Date endTime = new Date();
        return (endTime.getTime() - startTime.getTime());
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startTime = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date endTime = new Date();
        return (endTime.getTime() - startTime.getTime());
    }

    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<Long> hashMapStrategyIds = new HashSet<>();
        Set<Long> hashBiMapStrategyIds = new HashSet<>();
        Set<String> hashMapStrategyStrings = new HashSet<>();
        Set<String> hashBiMapStrategyStrings = new HashSet<>();

        Set<String> origStrings = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long hashMapStrategyTime = getTimeToGetIds(shortener1, origStrings, hashMapStrategyIds);
        long hashBiMapStrategyTime = getTimeToGetIds(shortener2, origStrings, hashBiMapStrategyIds);

        Assert.assertTrue(hashMapStrategyTime > hashBiMapStrategyTime);

        long hashMapStrategyStringTime = getTimeToGetStrings(shortener1, hashMapStrategyIds, origStrings);
        long hashBiMapStrategyStringTime = getTimeToGetStrings(shortener2, hashBiMapStrategyIds, origStrings);

        Assert.assertEquals(hashMapStrategyStringTime, hashBiMapStrategyStringTime, 30);


    }
}
