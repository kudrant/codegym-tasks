package com.codegym.task.task27.task2712.ad;

import com.codegym.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/* PREVIOUS TASK
We need an exception that will help us handle the situation where we are unable to choose commercials.

        1. Create an unchecked NoVideoAvailableException in the ad package.

        2. Let's take a closer look at the void processVideos() method in AdvertisementManager.
        2.1. Remove the code that displays "calling the processVideos method"
        The method should:
        2.2. Choose a list of available videos that maximizes revenues. (Don't do this yet—we'll do it later).
        2.3. If there are no advertising videos that can be shown to the customer, then throw a NoVideoAvailableException, which you will need to catch (think about where the best place to do this would be), and log the following phrase with logging level Level.INFO "No video is available for the following order: " + order
        2.4. Display all the chosen commercials in order of decreasing cost per impression in cents. The secondary sort order is by increasing the cost per impression per second of commercial in thousandths of a cent
        Use the Collections.sort method
        (Again, don't do this yet—we'll do it later).
        Example for [Water]:

        Displaying First Video... 50, 277

        where "First Video" is the name of the commercial
        where 50 is the cost per impression in cents
        where 277 is the cost per impression per second of commercial in thousandths of a cent (equal to 0.277 cents)
        Use the methods of the Advertisement class.
        2.5. In the Advertisement class, create a void revalidate() method. This method should:
        2.5.1. Throw an UnsupportedOperationException if the number of impressions is not positive.
        2.5.2. Decrement the number of remaining impressions.
*/

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private List<Advertisement> mostProfitableVideosList = new ArrayList<>();
    private long totalRevenueOfMostProfitableVideosList = 0;
    private int timeSeconds;
    //private int timeLeft;
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
        //this.timeLeft = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException{

        List<Advertisement> availableVideos = new ArrayList<>(); //videos that fit restictions (not exceed total cooking time)
        List<Advertisement> videosToShow = new ArrayList<>(); //initial list of videos for recursion
        if (storage.list().isEmpty()) throw new NoVideoAvailableException();

        for (Advertisement ad: storage.list() // Selecting the videos from storage with the duration not longer than cooking time
             ) {
            if(ad.getDuration() <= timeSeconds && ad.getImpressionsRemaining() > 0)
                availableVideos.add(ad);
        }
        //videosToShow = new ArrayList<>(availableVideos);
        // Check if videosToShow is not empty
        if (availableVideos.isEmpty())
            throw new NoVideoAvailableException();
        // - totalDuration(initialList);
        videosToShow = selectBestVideosList(videosToShow, availableVideos, 0);
        if (videosToShow.isEmpty())
            throw new NoVideoAvailableException();

        Collections.sort(videosToShow, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement ad1, Advertisement ad2) {
                int result = Long.compare(ad1.getAmountPerImpression(), ad2.getAmountPerImpression());
                if (result == 0)
                    result = Long.compare(ad1.getAmountPerImpression() / ad1.getDuration(), ad2.getAmountPerImpression() / ad2.getDuration());
                return result;
            }
        });
        Collections.reverse(videosToShow);
        for (Advertisement ad: videosToShow
             ) {
            ConsoleHelper.writeMessage(ad.toString());
            ad.revalidate();
        }
    }

//    public void getAllVideosSets(List<Advertisement> videos)
//    {
//        if (videos.size() > 0)
//           // CheckSet(videos);
//
//        for (int i = 0; i < videos.size(); i++)
//        {
//            List<Advertisement> newSet = new ArrayList<>(videos);
//
//            newSet.remove(i);
//
//            getAllVideosSets(newSet);
//        }
//
//    }

    private List<Advertisement> selectBestVideosList (List<Advertisement> initialList, List<Advertisement> availableVideos, int recursionStartIndex) {
        List<Advertisement> result = new ArrayList<>();
        int timeLeft = timeSeconds - totalDuration(initialList);
        Advertisement ad;

        for (int i = recursionStartIndex; i < availableVideos.size(); i++) {

            ad = availableVideos.get(i);
            if ((ad.getDuration() <= timeLeft) && (ad.getImpressionsRemaining() > 0) && (!initialList.contains(ad))) {
                initialList.add(ad);
                result = selectBestOfTwoLists(initialList, selectBestVideosList(initialList, availableVideos, i));
            }
        }


        return result;
    }

    private List<Advertisement> selectBestOfTwoLists(List<Advertisement> initialList, List<Advertisement> currentList) {
        List<Advertisement> result;
        if (totalAmount(initialList) > totalAmount(currentList))
            result = initialList;
        else if (totalAmount(initialList) < totalAmount(currentList))
            result = currentList;
        else {
            if (totalDuration(initialList) > totalDuration(currentList))
                result = initialList;
            else if (totalDuration(initialList) < totalDuration(currentList))
                result = currentList;
            else {
                if (initialList.size() > currentList.size())
                    result = initialList;
                else result = currentList;
            }

        }
        return result;
    }

    private int totalAmount(List<Advertisement> list) {
        int result = 0;
        for (Advertisement ad: list
             ) {
            result += ad.getAmountPerImpression();
        }
        return result;
    }

    private int totalDuration(List<Advertisement> list) {
        int result = 0;
        for (Advertisement ad: list
             ) {
            result += ad.getDuration();
        }
        return result;
    }



}
