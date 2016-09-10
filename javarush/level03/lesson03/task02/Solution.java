package com.javarush.test.level03.lesson03.task02;

/* Конвертер валют
Реализуйте метод convertEurToUsd, переводящий евро в доллары по заданному курсу.
Вызовите его дважды в методе main с любыми параметрами. Результаты выведите на экран, каждый раз с новой строки.
Подсказка:
Расчет выполняется по формуле: долларСША = евро * курс
*/
public class Solution
{
    public static void main(String[] args) {
        convertEurToUsd(75,1.2);
        convertEurToUsd(75,2.2);//напишите тут ваш код
    }

    public static double convertEurToUsd(int eur, double course){
        double dollar=eur * course;

        System.out.println(dollar);
        return dollar;//напишите тут ваш код
    }
}