package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfatherName = reader.readLine(); //вводим имя дедушки
        Cat catGrandFather = new Cat(grandfatherName);

        String grandmotherName = reader.readLine(); //вводим имя бабушки
        Cat catGrandMother = new Cat(grandmotherName);

        String fatherName = reader.readLine(); //вводим имя отца
        Cat catFather = new Cat(fatherName, catGrandFather, null);

        String motherName = reader.readLine(); //вводим имя мамы
        Cat catMother = new Cat(motherName, null, catGrandMother);

        String sonName = reader.readLine(); //вводим имя сына
        Cat catSon = new Cat(sonName, catFather, catMother);

        String daughterName = reader.readLine(); //вводим имя дочери
        Cat catDaughter = new Cat(daughterName, catFather,  catMother);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parent;
        private Cat parent1;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.parent = mother;
            this.parent1 = father;
        }


        @Override
        public String toString()
        {
            if (parent == null && parent1 == null)
                return "Cat name is " + name + ", no mother" + ", no father";
            else if (parent == null && parent1 != null)
                return "Cat name is " + name + ", no mother" + ", father is " + parent1.name;
            else if (parent != null && parent1 == null)
                return "Cat name is " + name + ", mother is " + parent.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + parent.name + ", father is " + parent1.name;
        }
    }

}
