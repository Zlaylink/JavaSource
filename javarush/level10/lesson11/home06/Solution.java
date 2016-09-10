package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
       String name, fathersname, mothersname,catsname;
        int age, fathersage;
        boolean sex;
        public Human(String name){
            this.name = name;
        }
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Human(String name, boolean sex){
            this.name = name;
            this.sex = sex;
        }
        public Human(boolean sex, int age){
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, String fathersname, int fathersage){
            this.name = name;
            this.fathersname = fathersname;
            this.fathersage = fathersage;
        }
        public Human(String name, String mothersname){
            this.name = name;
            this.mothersname = mothersname;
        }
        public Human(String name, String mothersname, boolean sex){
            this.name = name;
            this.mothersname = mothersname;
            this.sex = sex;
        }
        public Human(String name, String fathersname, int fathersage, boolean sex){
            this.name = name;
            this.fathersname = fathersname;
            this.fathersage = fathersage;
            this.sex = sex;
        }
        public Human(String name, String fathersname, String mothersname){
            this.name = name;
            this.fathersname = fathersname;
            this.mothersname = mothersname;
        }
        public Human(String name, String fathersname, String mothersname, String catsname){
            this.name = name;
            this.fathersname = fathersname;
            this.mothersname = mothersname;
            this.catsname = catsname;
        }

    }
}
