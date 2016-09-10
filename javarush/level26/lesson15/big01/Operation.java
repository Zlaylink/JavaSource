package com.javarush.test.level26.lesson15.big01;


/**
 * Created by Zlayl on 22.08.2016.
 * Zlaylink@gmail.com
 */
public enum Operation
{
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i){
        switch (i){
            case 0:
                throw new IllegalArgumentException();
            case 1:
                return INFO;
            case 2:
                return DEPOSIT;
            case 3:
                return WITHDRAW;
            case 4:
                return EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
