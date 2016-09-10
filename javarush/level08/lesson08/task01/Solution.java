package com.javarush.test.level08.lesson08.task01;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        Set<String> set = new HashSet<String>();
        Collections.addAll(set,"Лошадь","Лень","Лист","Лоск","Липа","Ласта","Линолеум","Лось","Лекарство","Лава","Луч","Литр","Лицо","Лиса","Личинка","Ласточка","Лампочка","Люстра","Лыжи","Лак");
        return (HashSet<String>)set;


    }
}
