package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] list = s.toCharArray();
        char a1 = list[0];
        if (!(Character.isSpaceChar(a1)))     // проверяем, является ли он пробелом
            a1 = Character.toUpperCase(a1);        // если нет - toUpperCase

        String newString = Character.toString(a1);   // создаем новую строку, в которую будем заносить символы

        for (int i = 1; i < list.length; i++){    // проверка остальных символов после первого
            char a = list[i];                // берем тестируемый символ
            char aPrevious = list[i - 1];    // берем символ, предыдущий тестируемому

            if ( Character.isSpaceChar(aPrevious) && (!(Character.isSpaceChar(a))) )  // если предыдущий символ - пробел, а текущий - нет
                a = Character.toUpperCase(a);                                             // текущий символ - toUpperCase

            newString = newString + Character.toString(a);    // заносим каждый протестированный символ в новую строку
        }                                                     // конец проверки

        System.out.println(newString);


    }


}
