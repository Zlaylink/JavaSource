package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
   private String name;
    private int age;
    private String sex;
    public void initialize(String name){
        this.name = name;
    }
    public void initialize(String name, int age){
        this.age = age;
        String string = this.age + name;
    }
    public void initialize(String name, int age, String sex){
        this.age = age;
        String string = this.age + name;
        String string1 = this.age + name + sex;

    }
}
