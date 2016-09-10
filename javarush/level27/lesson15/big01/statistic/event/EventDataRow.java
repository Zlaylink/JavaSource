package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Zlayl on 30.08.2016.
 * Zlaylink@gmail.com
 */
public interface EventDataRow
{
    EventType getType(); //получить тип события
    Date getDate(); //получить дату создания записи
    int getTime(); //получить время (продолжительность)
}
