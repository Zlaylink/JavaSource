package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            list.add(data);
        }
        int[] repeats = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            repeats [i] = 0;
            for (int j = 0; j < list.size(); j++){
                if (list.get(i).equals(list.get(j)))
                    repeats[i]++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int value : repeats){
            if (value > max)
                max = value;
        }
        for (int i = 0; i < list.size(); i++){
            if (!result.contains(list.get(i)) && repeats[i] == max)
                result.add(list.get(i));
        }
        for (int output : result)
            System.out.println(output + " ");
        reader.close();
        fileInputStream.close();
    }
}
