package com.codegym.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); // 15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); // 10 min
//        add(new Advertisement(someContent, "Fourth Video", 3000, 50, 2 * 60)); //2 min
//        add(new Advertisement(someContent, "Fifth Video", 89, 21, 1 * 60)); //1 min
//        add(new Advertisement(someContent, "Sixth Video", 500, 10, 4 * 60)); //4 min
//        add(new Advertisement(someContent, "Seventh Video", 1000, 1, 5 * 60)); //5 min
//        add(new Advertisement(someContent, "Eighth Video", 19, 2, 9 * 60)); //9 min
//        add(new Advertisement(someContent, "Ninth Video", 295, 3, 20 * 60)); //02 min

    }

    public static AdvertisementStorage getInstance() {
        if (instance == null)
            instance = new AdvertisementStorage();
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
