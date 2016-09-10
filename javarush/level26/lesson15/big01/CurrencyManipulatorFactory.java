package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zlayl on 22.08.2016.
 * Zlaylink@gmail.com
 */
public final class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory()
    {

    }

    private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (!manipulators.containsKey(currencyCode))
        {
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        }
        return manipulators.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }
}
