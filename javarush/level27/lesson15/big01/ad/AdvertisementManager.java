package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Zlayl on 29.08.2016.
 * Zlaylink@gmail.com
 */
public class AdvertisementManager
{
    private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        List<Advertisement> optimalAdList = getOptimalAdList(powerLists(storage.list()));

        if (optimalAdList.isEmpty())
            throw new NoVideoAvailableException();

        Collections.sort(optimalAdList, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                if (result != 0) return result;

                long totalCostOfDuration1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long totalCostOfDuration2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

                return Long.compare(totalCostOfDuration1, totalCostOfDuration2);
            }
        });

        int totalTime = 0; //общая продолжительность показа отобранных рекламных роликов
        int totalAmount = 0; //сумма денег в копейках

        for (Advertisement ad : optimalAdList)
        {
            totalTime += ad.getDuration();
            totalAmount += ad.getAmountPerOneDisplaying();
        }

        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(optimalAdList, totalAmount, totalTime)); //регистрируем событие

        for (Advertisement ad : optimalAdList)
        {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    ad.getName(),
                    ad.getAmountPerOneDisplaying(),
                    ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
            ad.revalidate();
        }

    }

    private List<List<Advertisement>> powerLists(List<Advertisement> storage)
    {
        List<List<Advertisement>> lists = new ArrayList<>();
        if (storage.isEmpty())
        {
            lists.add(new ArrayList<Advertisement>());
            return lists;
        }
        List<Advertisement> list = new ArrayList<>(storage);
        Advertisement head = list.get(0);
        List<Advertisement> rest = new ArrayList<>(list.subList(1, list.size()));
        for (List<Advertisement> adList : powerLists(rest))
        {
            List<Advertisement> newList = new ArrayList<>();
            newList.add(head);
            newList.addAll(adList);
            lists.add(newList);
            lists.add(adList);
        }
        return lists;

    }

    private List<Advertisement> getOptimalAdList(List<List<Advertisement>> powerLists)
    {
        List<Advertisement> optimalAdList;

        Iterator<List<Advertisement>> iterator = powerLists.iterator();

        while (iterator.hasNext())
        {
            List<Advertisement> adList = iterator.next();

            int duration = 0;
            boolean isHitsZero = false;

            for (Advertisement ad : adList)
            {
                duration += ad.getDuration();

                if (ad.getHits() <= 0)
                {
                    isHitsZero = true;
                }
            }

            if (duration > timeSeconds || isHitsZero)
            {
                iterator.remove();
            }
        }

        Collections.sort(powerLists, new Comparator<List<Advertisement>>()
        {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2)
            {
                int totalTime1 = 0, totalTime2 = 0;
                long totalAmountOfMoney1 = 0, totalAmountOfMoney2 = 0;

                for (Advertisement ad : o1)
                {
                    totalTime1 += ad.getDuration();
                    totalAmountOfMoney1 += ad.getAmountPerOneDisplaying();
                }

                for (Advertisement ad : o2)
                {
                    totalTime2 += ad.getDuration();
                    totalAmountOfMoney2 += ad.getAmountPerOneDisplaying();
                }

                int result1 = Long.compare(totalAmountOfMoney2, totalAmountOfMoney1);
                if (result1 != 0) return result1;

                int result2 = Integer.compare(totalTime2, totalTime1);
                if (result2 != 0) return result2;

                return Integer.compare(o1.size(), o2.size());
            }
        });

        optimalAdList = powerLists.get(0);
        return optimalAdList;
    }
}
