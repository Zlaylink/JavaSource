package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] arr5 = {1,2,3,4,5};
        int[] arr2 = {6,7};
        int[] arr4 = {8,9,10,11};
        int[] arr7 = {12,13,14,15,16,17,18};
        int[] arr0 = {};

        list.add(arr5);
        list.add(arr2);
        list.add(arr4);
        list.add(arr7);
        list.add(arr0);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
