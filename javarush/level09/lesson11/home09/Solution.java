package com.javarush.test.level09.lesson11.home09;

import com.sun.org.apache.bcel.internal.classfile.StackMapEntry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Cat cat1 = new Cat("Whisky");
        Cat cat2 = new Cat("Ricky");
        Cat cat3 = new Cat("Rocky");
        Cat cat4 = new Cat("Max");
        Cat cat5 = new Cat("Reddy");
        Cat cat6 = new Cat("Teddy");
        Cat cat7 = new Cat("Roman");
        Cat cat8 = new Cat("Frisky");
        Cat cat9 = new Cat("Chip");
        Cat cat10 = new Cat("Snow");



        Map<String,Cat> map = new HashMap<String, Cat>();
        map.put(cat1.name,cat1);
        map.put(cat2.name,cat2);
        map.put(cat3.name,cat3);
        map.put(cat4.name,cat4);
        map.put(cat5.name,cat5);
        map.put(cat6.name,cat6);
        map.put(cat7.name,cat7);
        map.put(cat8.name,cat8);
        map.put(cat9.name,cat9);
        map.put(cat10.name,cat10);

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> cats = new HashSet<Cat>(map.values());
        return cats;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
