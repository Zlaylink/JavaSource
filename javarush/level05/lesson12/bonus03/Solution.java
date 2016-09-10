package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int maximum = Integer.MIN_VALUE;
        if (N<=0)
            System.out.println("Введите число больше 0");
        else if (N>0)
        {
            while (N > 0)
            {

                for (int i = 0; i < N + 1; i++) ;
                {
                    int M = Integer.parseInt(reader.readLine());

                    if (M == 0)
                    {
                        maximum = M;
                    } else if (M > maximum)
                        maximum = M;
                }
                N--;
            }

        }
        System.out.println(maximum);
    }

}
