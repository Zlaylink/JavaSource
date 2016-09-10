package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Zlayl on 30.08.2016.
 * Zlaylink@gmail.com
 */
public class StatisticEventManager
{
    private StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticEventManager ourInstance = new StatisticEventManager();

    public static StatisticEventManager getInstance()
    {
        return ourInstance;
    }

    private StatisticEventManager()
    {
    }

    public void register(EventDataRow data)
    {
        if (data == null) return;
        statisticStorage.put(data);
    }

    public TreeMap<Date, Double> getAdInfo()
    {
        TreeMap<Date, Double> adInfo = new TreeMap<>(Collections.<Date>reverseOrder()); //мап информация дата - заработок
        Date date;

        for (EventDataRow eventDataRow : statisticStorage.getList(EventType.SELECTED_VIDEOS))
        {
            VideoSelectedEventDataRow selectedVideo = (VideoSelectedEventDataRow) eventDataRow;
            date = getDate(selectedVideo.getDate());

            if (adInfo.containsKey(date))
            {
                adInfo.put(date, adInfo.get(date) + ((double) selectedVideo.getAmount() * 0.01d));
            } else
            {
                adInfo.put(date, ((double) selectedVideo.getAmount() * 0.01d));
            }
        }
        return adInfo;
    }

    public TreeMap<Date, TreeMap<String, Integer>> getCookNameTotalTimeByDate()
    {
        TreeMap<Date, TreeMap<String, Integer>> mapTimeByDate = new TreeMap<>(Collections.<Date>reverseOrder());

        Date date;
        String cookName;
        int totalDuration;

        for (EventDataRow eventDataRow : statisticStorage.getList(EventType.COOKED_ORDER))
        {
            CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow) eventDataRow;
            date = getDate(cookedOrder.getDate());

            cookName = cookedOrder.getCookName();
            totalDuration = cookedOrder.getTime();
            //не выводим тех поваров, которые не работали
            if (totalDuration == 0)
                continue;

            totalDuration = totalDuration % 60 == 0 ? totalDuration / 60 : totalDuration / 60 + 1;

            if (mapTimeByDate.containsKey(date))
            {
                TreeMap<String, Integer> cookNameWithDuration = mapTimeByDate.get(date);
                if (cookNameWithDuration.containsKey(cookName))
                {
                    cookNameWithDuration.put(cookName, cookNameWithDuration.get(cookName) + totalDuration);
                } else
                {
                    cookNameWithDuration.put(cookName, totalDuration);
                }
            } else
            {
                TreeMap<String, Integer> cookNameWithDuration = new TreeMap<>();
                cookNameWithDuration.put(cookName, totalDuration);
                mapTimeByDate.put(date, cookNameWithDuration);
            }
        }
        return mapTimeByDate;
    }

    private Date getDate(Date date)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> statStorage = new HashMap<>();

        private StatisticStorage()
        {
            for (EventType eventType : EventType.values())
            {
                statStorage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private List<EventDataRow> getList(EventType eventType)
        {
            return statStorage.get(eventType);
        }

        private void put(EventDataRow data)
        {
            if (data == null) return;
            statStorage.get(data.getType()).add(data);
        }
    }
}
