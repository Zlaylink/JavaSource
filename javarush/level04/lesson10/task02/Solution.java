package com.javarush.test.level04.lesson10.task02;

import java.io.*;

/* 10 чисел наоборот
Вывести на экран числа от 10 до 1 используя цикл while.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int x=10;
        while (x>=1)
            System.out.print(x-- +" ");

    }
}
