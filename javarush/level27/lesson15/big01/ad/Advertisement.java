package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Zlayl on 29.08.2016.
 * Zlaylink@gmail.com
 */
public class Advertisement
{
    private Object content; //видео
    private String name; //имя
    private long initialAmount; //начальная сумма, стоимость рекламы в копейках
    private int hits; //количество оплаченных показов
    private int duration; //продолжительность в секундах
    private long amountPerOneDisplaying; //стоимость одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public int getHits()
    {
        return hits;
    }

    public String getName()
    {
        return name;
    }

    int getDuration()
    {
        return duration;
    }

    long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    public void revalidate()
    {
        if (hits <= 0) throw new UnsupportedOperationException();
        hits--;
        if (hits == 1) amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;
    }
}
