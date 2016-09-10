package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        int z = Integer.parseInt(reader.readLine());
        int a = 0, b = 0;
        if (x != Math.abs(x))
            a = a + 1;
            if (y != Math.abs(y))
                a = a + 1;
                if (z != Math.abs(z))
                    a = a + 1;
                else if (x == Math.abs(x))
                    b = b + 1;
                if (y == Math.abs(y))
                    b = b + 1;
                    if (z == Math.abs(z))
                        b = b + 1;


            System.out.println("количество отрицательных чисел: " + a);
            System.out.print("количество положительных чисел: " + b);

    }
}
