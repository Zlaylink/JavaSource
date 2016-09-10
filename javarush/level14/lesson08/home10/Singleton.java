package com.javarush.test.level14.lesson08.home10;

/**
 * Created by Zlayl on 21.06.2016.
 */
public class Singleton
{
    private static Singleton instance;
    private Singleton() { }
    private static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
