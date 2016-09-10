package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Zlayl on 29.08.2016.
 * Zlaylink@gmail.com
 */
public class Cook extends Observable implements Runnable
{
    private String name;
    private volatile boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    public boolean isBusy()
    {
        return busy;
    }

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public void startCookingOrder(Order order)
    {
        busy = true;
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order, order.getTotalCookingTime()));

        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),
                name,
                order.getTotalCookingTime() * 60,
                order.getDishes())); //регистрируем событие для повара

        try
        {
            Thread.sleep(order.getTotalCookingTime() * 10);
        }
        catch (InterruptedException e)
        {
        }

        setChanged();
        notifyObservers(order);
        busy = false;
    }

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            try
            {
                startCookingOrder(queue.take());
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {

            }
        }
    }
}
