package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;

import java.io.IOException;

/**
 * Created by Zlayl on 04.09.2016.
 * Zlaylink@gmail.com
 */
public class Aggregator
{
    private static Provider provider = new Provider(new HHStrategy());
    static Controller controller = new Controller(provider);

    public static void main(String[] args) throws IOException
    {
        controller.scan();
    }
}
