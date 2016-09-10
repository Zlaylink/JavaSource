package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Zlayl on 16.06.2016.
 */
public class UkrainianHen extends Hen implements Country
{
    int getCountOfEggsPerMonth(){
        return 56;
    }
    String getDescription(){
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
