package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Zlayl on 22.08.2016.
 * Zlaylink@gmail.com
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try
            {
                int amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0)
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));

                if (manipulator.isAmountAvailable(amount))
                {
                    Map<Integer, Integer> output = manipulator.withdrawAmount(amount);
                    for (Map.Entry<Integer, Integer> pair : output.entrySet())
                    {
                        ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                    break;
                } else ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
            catch (ConcurrentModificationException ignore)
            {
                //do nothing
            }
        }
    }
}