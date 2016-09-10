package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Zlayl on 24.08.2016.
 * Zlaylink@gmail.com
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));

            String cardNumber = ConsoleHelper.readString();
            String pinCode = ConsoleHelper.readString();

            if (validCreditCards.containsKey(cardNumber))
            {
                if (validCreditCards.getString(cardNumber).equals(pinCode))
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            } else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            break;
        }
    }
}
