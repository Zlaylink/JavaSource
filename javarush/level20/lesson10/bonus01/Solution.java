package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{

    public static void main(String args[])
    {
        Long t0 = System.currentTimeMillis();
        int[] numbers = getNumbers(100000000);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int number : numbers) System.out.println(number);
    }

    public static int[] getNumbers(int N)
    {
        List<Integer> armstongNumbers = new ArrayList<>();
        for (int i = 1; i <= N; i++)
        {
            int summa = 0;
            int tmp = i;
            byte length = (byte) (Math.log10(i) + 1);
            while (tmp != 0)
            {
                for (int k = 0; k < length; k++)
                {
                    int number = tmp % 10;
                    int degree = 1;
                    for (int j = 0; j < length; j++)
                    {
                        degree = degree * number;
                    }
                    summa += degree;
                    tmp = tmp / 10;
                }
                if (i == summa)
                    armstongNumbers.add(i);
            }
        }
        int[] result = new int[armstongNumbers.size()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = armstongNumbers.get(i);
        }
        return result;
    }


}
