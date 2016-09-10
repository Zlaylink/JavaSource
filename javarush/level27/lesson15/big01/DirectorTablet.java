package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Zlayl on 30.08.2016.
 * Zlaylink@gmail.com
 */
public class DirectorTablet
{
    private DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); //формат даты

    /**
     * какую сумму заработали на рекламе, сгруппировать по дням
     */
    public void printAdvertisementProfit()
    {
        Map<Date, Double> adInfo = StatisticEventManager.getInstance().getAdInfo();

        double totalAmount = 0d;
        ConsoleHelper.writeMessage("");
        for (Map.Entry<Date, Double> date_Amount : adInfo.entrySet())
        {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", format.format(date_Amount.getKey()), date_Amount.getValue()));
            totalAmount += date_Amount.getValue();
        }

        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", totalAmount));
        ConsoleHelper.writeMessage("");
    }

    /**
     * загрузка (рабочее время) повара, сгруппировать по дням
     */

    public void printCookWorkloading()
    {
        Map<Date, TreeMap<String, Integer>> cooksInfo = StatisticEventManager.getInstance().getCookNameTotalTimeByDate();

        for (Map.Entry<Date, TreeMap<String, Integer>> date : cooksInfo.entrySet())
        {
            ConsoleHelper.writeMessage(format.format(date.getKey()));

            for (Map.Entry<String, Integer> cookName_duration : date.getValue().entrySet())
            {
                ConsoleHelper.writeMessage(String.format("%s - %d min", cookName_duration.getKey(), cookName_duration.getValue()));
            }
        }
    }

    /**
     * список активных роликов и оставшееся количество показов по каждому
     */
    public void printActiveVideoSet()
    {
        for (Advertisement advertisement : StatisticAdvertisementManager.getInstance().getActiveVideoSet())
        {
            ConsoleHelper.writeMessage(String.format("%s - %d", advertisement.getName(), advertisement.getHits()));
        }
    }

    /**
     * список НЕактивных роликов (с оставшемся количеством показов равным нулю)
     */
    public void printArchivedVideoSet()
    {
        for (Advertisement advertisement : StatisticAdvertisementManager.getInstance().getArchivedVideoSet())
        {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
