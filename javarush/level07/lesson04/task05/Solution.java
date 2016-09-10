package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] integers = new int[20];
        int[] integers1 = new int[10];
        int[] integers2 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<integers.length; i++){
            String s = reader.readLine();
            integers[i] = Integer.parseInt(s);
        }

        System.arraycopy(integers,0,integers1,0,integers.length/2);
        System.arraycopy(integers,integers.length/2,integers2,0,integers.length/2);

        for (int j = 0; j<integers2.length; j++){
        System.out.println(integers2[j]);
        }
    }
}
