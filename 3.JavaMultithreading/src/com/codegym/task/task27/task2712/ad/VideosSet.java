package com.codegym.task.task27.task2712.ad;

import java.util.List;

public class VideosSet {
    private List<Advertisement> videos;
    private long totalRevenue;
    private int totalDuration;

    public VideosSet(List<Advertisement> videos, long revenue, int totalDuration) {
        this.videos = videos;
        this.totalRevenue = revenue;
        this.totalDuration = totalDuration;
    }
}
