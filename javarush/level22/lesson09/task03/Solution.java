package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());
        br.close();
        StringBuilder sb = new StringBuilder();
        while (reader.ready())
        {
            sb.append((char) reader.read());
        }
        reader.close();
        String[] buffer = sb.toString().replaceAll("\\n", " ").split(" ");
        StringBuilder result = getLine(buffer);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1) return new StringBuilder(words[0]);

        int counterLettersMatches = 0;
        while (counterLettersMatches != words.length - 1)
        {
            Collections.shuffle(Arrays.asList(words));
            counterLettersMatches = 0;
            for (int i = 0; i < words.length - 1; i++)
            {
                if (words[i].substring(words[i].length() - 1).equalsIgnoreCase(words[i + 1].substring(0, 1)))
                    counterLettersMatches++;
            }
        }
        for (String i : words) sb.append(i + " ");
        return new StringBuilder(sb.toString().trim());
    }
}
