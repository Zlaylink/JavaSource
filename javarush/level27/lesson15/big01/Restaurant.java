package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Zlayl on 29.08.2016.
 * Zlaylink@gmail.com
 */
public class Restaurant
{
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException
    {
        List<Tablet> tablets = new ArrayList<>();

        Cook cookAmigo = new Cook("Amigo");
        cookAmigo.setQueue(ORDER_QUEUE);
        Cook cookDiego = new Cook("Diego");
        cookDiego.setQueue(ORDER_QUEUE);


        Waitor waitor = new Waitor();
        cookAmigo.addObserver(waitor);
        cookDiego.addObserver(waitor);

        for (int i = 1; i < 6; i++)
        {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(ORDER_QUEUE);
            tablets.add(tablet);
        }

        Thread cookAmigoThread = new Thread(cookAmigo);
        cookAmigoThread.start();
        Thread cookDiegoThread = new Thread(cookDiego);
        cookDiegoThread.start();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }

        thread.interrupt();

        while ((cookAmigo.isBusy()) || (cookDiego.isBusy()))
        {
            Thread.sleep(1);
        }

        cookAmigoThread.interrupt();
        cookDiegoThread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
