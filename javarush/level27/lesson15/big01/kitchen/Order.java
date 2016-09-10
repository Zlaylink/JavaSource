package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Zlayl on 29.08.2016.
 * Zlaylink@gmail.com
 */
public class Order
{
    private Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    public Tablet getTablet()
    {
        return tablet;
    }

    protected void initDishes() throws IOException
    {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime()
    {
        int duration = 0;
        for (Dish dish : dishes)
            duration += dish.getDuration();
        return duration;
    }

    @Override
    public String toString()
    {
        if (dishes.isEmpty())
            return "";
        return "Your order: " + dishes + " of " + tablet;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }
}
