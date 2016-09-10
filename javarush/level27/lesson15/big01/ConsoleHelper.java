package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlayl on 29.08.2016.
 * Zlaylink@gmail.com
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    private static String readString() throws IOException
    {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException, IllegalArgumentException
    {

        List<Dish> dishesForOrder = new ArrayList<>();

        writeMessage("Выберите блюдо:");
        writeMessage(Dish.allDishesToString());
        while (true)
        {
            String order = null;
            try
            {
                order = readString();
                if (order.equalsIgnoreCase("EXIT"))
                    break;
                dishesForOrder.add(Dish.valueOf(order));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(order + " is not detected");
            }
        }
        return dishesForOrder;
    }
}
