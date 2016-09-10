package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Zlayl on 30.08.2016.
 * Zlaylink@gmail.com
 */
public class NoAvailableVideoEventDataRow implements EventDataRow
{
    private int totalDuration; //время приготовления заказа в секундах
    private Date currentDate; //текущее время

    public NoAvailableVideoEventDataRow(int totalDuration)
    {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType()
    {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate()
    {
        return currentDate;
    }

    @Override
    public int getTime()
    {
        return totalDuration;
    }
}
