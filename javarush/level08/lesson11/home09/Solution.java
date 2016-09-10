package com.javarush.test.level08.lesson11.home09;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        Date da = new Date();

        SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy");
        String dateTime = format.format(da).toUpperCase();
        isDateOdd(dateTime);
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);
        yearStartTime.setDate(1);
        yearStartTime.setMonth(0);

        SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy");
        Date dq = format.parse(date);
        long maTimeDistance = dq.getTime() - yearStartTime.getTime();

        long msDay = 24 * 60 * 60 * 1000;

        int dayCount = (int) (maTimeDistance / msDay);

        if (dayCount % 2 == 0)
            return false;
        else
            return true;
    }
}
