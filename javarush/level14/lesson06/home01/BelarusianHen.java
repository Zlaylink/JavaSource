package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Zlayl on 16.06.2016.
 */
public class BelarusianHen extends Hen implements Country
{
    int getCountOfEggsPerMonth(){
        return 96;
    }
    String getDescription(){
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
