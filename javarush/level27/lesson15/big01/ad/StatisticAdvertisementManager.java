package com.javarush.test.level27.lesson15.big01.ad;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Zlayl on 05.09.2016.
 * Zlaylink@gmail.com
 */
public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private static AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance()
    {
        return ourInstance;
    }

    private StatisticAdvertisementManager()
    {
    }

    public Set<Advertisement> getActiveVideoSet()
    {
        Set<Advertisement> activeVideoSet = new TreeSet<>(new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement advertisement : advertisementStorage.list())
        {
            if (advertisement.getHits() > 0)
                activeVideoSet.add(advertisement);
        }
        return activeVideoSet;
    }

    public Set<Advertisement> getArchivedVideoSet()
    {
        Set<Advertisement> archivedVideoSet = new TreeSet<>(new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement advertisement : advertisementStorage.list())
        {
            if (advertisement.getHits() == 0)
                archivedVideoSet.add(advertisement);
        }
        return archivedVideoSet;
    }
}
