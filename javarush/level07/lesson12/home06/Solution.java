package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human grandFather = new Human("дед Алексей", true, 55);
        Human grandFather1 = new Human("дед Лев", true, 54);
        Human grandMother = new Human("баба Люба", false, 51);
        Human grandMother1 = new Human("баба Лида", false, 52);
        Human father = new Human("отец Леха", true, 38, grandFather, grandMother);
        Human mother = new Human("мама Оля", false, 38, grandFather1, grandMother1);
        Human son = new Human("сын Петя", true, 4, father, mother);
        Human son1 = new Human("сын Коля", true, 4, father, mother);
        Human daughter = new Human("дочь Киса", false, 5, father, mother);

        System.out.println(grandFather.toString());
        System.out.println(grandFather1.toString());
        System.out.println(grandMother.toString());
        System.out.println(grandMother1.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son.toString());
        System.out.println(son1.toString());
        System.out.println(daughter.toString());


    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
