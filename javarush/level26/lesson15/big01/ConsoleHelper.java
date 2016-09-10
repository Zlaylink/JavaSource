package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Zlayl on 22.08.2016.
 * Zlaylink@gmail.com
 */
public class ConsoleHelper
{
    static private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.common_en");

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static void printExitMessage()
    {
        writeMessage(res.getString("the.end"));
    }

    public static String readString() throws InterruptOperationException
    {
        String str = "";
        try
        {
            str = reader.readLine();
            if (str.equalsIgnoreCase("EXIT"))
                throw new InterruptOperationException();
        }
        catch (IOException e)
        {
            //do nothing
        }
        return str;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = readString();
        while (currencyCode.length() != 3 || currencyCode == null)
        {
            writeMessage(res.getString("invalid.data"));
            currencyCode = readString();
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String input;
        while (true)
        {
            input = readString();
            if (input != null && input.matches("\\d+ \\d+"))
            {
                return input.split(" ");
            }
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));

        writeMessage(String.format("%s - %d, %s - %d, %s - %d, %s - %d",
                res.getString("operation.INFO"), Operation.INFO.ordinal(),
                res.getString("operation.DEPOSIT"), Operation.DEPOSIT.ordinal(),
                res.getString("operation.WITHDRAW"), Operation.WITHDRAW.ordinal(),
                res.getString("operation.EXIT"), Operation.EXIT.ordinal()));

        while (true)
        {
            try
            {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }
}
