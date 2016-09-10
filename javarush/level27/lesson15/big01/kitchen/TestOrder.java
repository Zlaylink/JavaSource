package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Zlayl on 05.09.2016.
 * Zlaylink@gmail.com
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        int random = ThreadLocalRandom.current().nextInt(1, Dish.values().length);

        for (int i = 0; i < random; i++)
        {
            int number = (int) (Math.random() * (Dish.values().length));
            dishes.add(Dish.values()[number]);
        }
    }
}
