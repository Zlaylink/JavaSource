package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;


/**
 * Created by Zlayl on 22.08.2016.
 * Zlaylink@gmail.com
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> amount : denominations.entrySet())
        {
            totalAmount += amount.getKey() * amount.getValue();
        }
        return totalAmount;
    }

    public boolean hasMoney()
    {
        return getTotalAmount() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> tmpDenominations = new HashMap<>(denominations);
        Map<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
        ArrayList<Integer> denomination = new ArrayList<>(denominations.keySet());
        Collections.sort(denomination, Collections.reverseOrder());
        int tmpExpectedAmount = expectedAmount;

        for (Integer currentDenomination : denomination)
        {
            int key = currentDenomination;
            int value = tmpDenominations.get(key);
            while (true)
            {
                if (tmpExpectedAmount < key || value <= 0)
                {
                    tmpDenominations.put(key, value);
                    break;
                }
                tmpExpectedAmount -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else result.put(key, 1);
            }
        }
        if (tmpExpectedAmount != 0) throw new NotEnoughMoneyException();

        denominations.clear();
        denominations.putAll(tmpDenominations);

        return result;
    }
}
