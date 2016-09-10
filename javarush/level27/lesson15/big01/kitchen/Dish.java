package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Zlayl on 29.08.2016.
 * Zlaylink@gmail.com
 */
public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString(){
        StringBuilder sb = new StringBuilder();
        sb.append(Dish.values()[0]);
        for (int i = 1; i < Dish.values().length; i++){
            sb.append(", ").append(Dish.values()[i]);
        }
        return sb.toString();
    }

}
