package com.codegym.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long amountPaid;
    private int impressionsRemaining; // number of impressions remaining
    private int duration; // in seconds
    private long amountPerImpression;

    public Advertisement(Object content, String name, long amountPaid, int impressionsRemaining, int duration) {
        this.content = content;
        this.name = name;
        this.amountPaid = amountPaid;
        this.impressionsRemaining = impressionsRemaining;
        this.duration = duration;
        //checking if we have impressions remaining
        this.amountPerImpression = impressionsRemaining > 0 ? amountPaid / impressionsRemaining : 0;
    }


    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerImpression() {
        return amountPerImpression;
    }

    public int getImpressionsRemaining() {
        return impressionsRemaining;
    }

    public void revalidate() {
        if (impressionsRemaining <= 0)
            throw new UnsupportedOperationException();
        else
            impressionsRemaining--;
    }


    @Override
    public String toString() {
        return "Displaying " + name + "... " + amountPerImpression + ", " + amountPerImpression * 1000L / duration;
    }
}
