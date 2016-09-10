package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Zlayl on 22.08.2016.
 * Zlaylink@gmail.com
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
