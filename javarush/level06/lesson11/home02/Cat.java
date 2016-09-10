package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public Cat() {
    }
    public static ArrayList<Cat> cats = new ArrayList<Cat>();

    public static void main(String[] args) {
        int i=0;
        while (i != 10){
            Cat cat = new Cat();
            cats.add(cat);
            i++;
        }
        printCats();
    }

    public static void printCats() {
        System.out.println(Cat.cats);
    }
}
