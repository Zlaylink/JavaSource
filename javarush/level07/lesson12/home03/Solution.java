package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> integers = new ArrayList<Integer>();
        for(int i = 0; i < 20; i++){
            integers.add(Integer.parseInt(reader.readLine()));
        }
        int  maximum = integers.get(0);
        int  minimum = integers.get(0);

        for(int i = 1; i < integers.size(); i++){
            if (integers.get(i) > maximum)
                maximum = integers.get(i);
            else if (integers.get(i) < minimum)
                minimum = integers.get(i);
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
