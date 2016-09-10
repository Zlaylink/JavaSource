package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        int allNumbers[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int w = 0; w < 10; w++)
        {
            for (int q = 0; q < 10; q++)
            {
                System.out.print((allNumbers[q]+1) * (allNumbers[w]+1) + " ");
            }
            System.out.println();
        }
    }

}