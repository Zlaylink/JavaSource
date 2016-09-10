package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Zlayl on 21.06.2016.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName(){
        return "USD";
    }
}
