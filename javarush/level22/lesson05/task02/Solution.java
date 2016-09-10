package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        char[] chars = string.toCharArray();
        int count = 0;
        int tabIndex = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '\t')
            {
                count++;
                if (count == 2)
                    tabIndex = i;
            }
        }
        if (count < 2) throw new TooShortStringException();
        return string.substring(string.indexOf("\t") + 1, tabIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
