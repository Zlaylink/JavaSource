package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {

        char[] chars = string.toCharArray();
        int spaces = 0;
        int lastIndexSpace = 0;
        label:
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == ' ')
            {
                spaces++;
                if (spaces == 5)
                {
                    lastIndexSpace = i;
                    break label;
                }
            }
        }
        if (spaces < 5) throw new TooShortStringException();
        return string.substring(string.indexOf(" ") + 1, lastIndexSpace);
    }

    public static class TooShortStringException extends Exception
    {
    }
}
