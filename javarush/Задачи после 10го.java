package com.javarush.test.level13.lesson02.task01;

/* Пиво
1. Подумай, какой из двух интерфейсов нужно реализовать в классе Beer.
2. Добавь к классу Beer этот интерфейс и реализуйте все нереализованные методы.
3. Подумай, как связаны переменная  READY_TO_GO_HOME и метод isReadyToGoHome.
4. Верни значение переменной READY_TO_GO_HOME в методе isReadyToGoHome.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    public interface Drink
    {
        void askMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcohol extends Drink
    {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public static class Beer
    {

    }
}

package com.javarush.test.level13.lesson02.task02;

/* Пиво: возвращение
Добавь к классу AlcoholicBeer интерфейс Drink и реализуй все нереализованные методы.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Drink beer = new AlcoholicBeer();
        System.out.println(beer.toString());
    }

    public interface Drink
    {
        boolean isAlcoholic();
    }

    public static class AlcoholicBeer
    {
        @Override
        public String toString()
        {
            if (isAlcoholic()) {
                return "Напиток алкогольный";
            }
            else {
                return "Напиток безалкогольный";
            }

        }

    }
}



package com.javarush.test.level13.lesson02.task03;

/* Пиво и кола
Реализуй интерфейс Drink в классах Beer и Cola.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        print(new Beer());
        print(new Cola());

    }

    private static void print(Drink drink)
    {
        System.out.println(drink.getClass().getSimpleName());
    }

    public interface Drink
    {
        boolean isAlcoholic();
    }

    public static class Beer
    {
    }

    public static class Cola
    {
    }
}



package com.javarush.test.level13.lesson02.task04;

/* Selectable и Updatable
1. Создай класс Screen.
2. Реализуй в нем интерфейсы Selectable с методом onSelect, Updatable с методом refresh.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    interface Selectable
    {
        void onSelect();
    }

    interface Updatable
    {
        void refresh();
    }

    //напишите тут ваш класс
}




package com.javarush.test.level13.lesson02.task05;

/* 4 ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.
Объявление интерфейсов не изменять.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {

        System.out.println(new Dream().HOBBIE.toString());
        System.out.println(new Hobbie().toString());

    }

        interface Desire
        {
        }

        interface Dream
        {
            private static Hobbie HOBBIE = new Hobbie();
        }

        class Hobbie extends Desire implements Dream
        {
            static int INDEX = 1;

            @Override
            public String toString()
            {
                INDEX++;
                return "" + INDEX;
            }
        }

}


package com.javarush.test.level13.lesson02.task06;

/* Баг в initializeIdAndName
1. Подумать, что в программе неправильно.
2. Вынести реализацию метода initializeIdAndName в класс User.
3. initializeIdAndName в классе User должен возвращать тип User.
4. Поправить программу, чтобы компилировалась и работала.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(Matrix.NEO);
        System.out.println(Matrix.TRINITY);
    }

    static class Matrix
    {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
        public static DBObject TRINITY = new User().initializeIdAndName(2, "Trinity");
    }

    interface DBObject
    {
        DBObject initializeIdAndName(long id, String name) {
            this.id = id;
            this.name = name;
            return this;
        }
    }

    static class User implements DBObject
    {
        long id;
        String name;

        @Override
        public String toString()
        {
            return String.format("User has name %s, id = %d", name, id);
        }
    }

}


package com.javarush.test.level13.lesson02.task07;

/* Параметризованый интерфейс
В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

    class StringObject //допишите здесь ваш код
    {
    }
}


package com.javarush.test.level13.lesson02.task08;

/* Жив или нет
1. Создай интерфейс Person.
2. Добавь в него метод isAlive(), который проверяет, жив человек или нет.
3. Подумай, какой тип должен возвращать этот метод.
4. Создай интерфейс Presidentable.
5. Унаследуй интерфейс Presidentable от интерфейса Person.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }
}



package com.javarush.test.level13.lesson02.task09;

/* Наследование интерфейса
1. Создать интерфейс Movable с методом speed.
2. Метод speed возвращает значение типа Double и не принимает параметров.
3. Создать и унаследовать интерфейс Runable от интерфейса Movable.
4. Добавить в интерфейс Runable метод speed.
5. Метод speed возвращает значение типа Double и принимает один параметр типа Runable.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }
}


package com.javarush.test.level13.lesson02.task10;

/* CleverMan и SmartGirl
1. Добавь интерфейсы Secretary и Boss к классам CleverMan и SmartGirl. По одному на каждый. Подумай, кому какой.
2. Унаследуй  интерфейсы Secretary и Boss от интерфейсов Person и Workable так,
чтобы все методы у классов CleverMan и SmartGirl оказались объявленными в каком-то интерфейсе.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    interface Person
    {
        void use(Person person);
        void startToWork();
    }

    interface Workable
    {
        boolean wantGetExtraWork();
    }

    interface Secretary
    {
    }

    interface Boss
    {
    }

    class CleverMan
    {
        public void use(Person person)
        {
            person.startToWork();
        }

        public void startToWork()
        {
        }

        public boolean wantGetExtraWork()
        {
            return true;
        }
    }

    class SmartGirl
    {
        public void use(Person person)
        {
        }

        public void startToWork()
        {
        }
    }
}


package com.javarush.test.level13.lesson04.task01;

/* Переводчик с английского
1. Создать класс EnglishTranslator, который наследуется от Translator.
2. Реализовать все абстрактные методы.
3. Подумай, что должен возвращать метод getLanguage.
4. Программа должна выводить на экран "Я переводчик с английского".
5. Метод main менять нельзя.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        EnglishTranslator englishTranslator = new EnglishTranslator();
        System.out.println(englishTranslator.translate());
    }

    public static abstract class Translator
    {
        public abstract String getLanguage();

        public String translate()
        {
            return "Я переводчик с " + getLanguage();
        }
    }

}


package com.javarush.test.level13.lesson04.task02;

/* Исправление кода
Исправить код так, чтобы программа выполнялась и выводила "Я переводчик с английского".
Метод main менять нельзя!
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Translator translator = new Translator();
        System.out.println(translator.translate());
    }

    public abstract static class Translator
    {
        public String translate()
        {
            return "Я переводчик с английского";
        }
    }


}



package com.javarush.test.level13.lesson04.task03;

import java.awt.*;

/* Интерфейс Animal
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
3. Создавать дополнительные классы и удалять методы нельзя!
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    public interface Animal
    {
        Color getColor();
    }

    public static class Fox
    {
        public String getName()
        {
            return "Fox";
        }
    }
}


package com.javarush.test.level13.lesson04.task04;

import java.awt.*;

/* Класс BigFox
1. Исправь класс BigFox так, чтобы программа компилировалась.
2. Метод main менять нельзя.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {

        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());

    }

    public interface Animal
    {
        Color getColor();
    }

    public static abstract class Fox implements Animal
    {
        public String getName() {
            return "Fox";
        }
    }

    //add your code below
    public static class BigFox
    {
        public Color () {
            return Color.GRAY;
        }
    }

}


package com.javarush.test.level13.lesson06.task01;

/* Dog, Cat и Mouse
1. Создать классы Dog, Cat и Mouse.
2. Реализовать интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution
{

    public interface Moveable //может двигаться
    {
        void move();
    }

    public interface Eatable  //может быть съеден
    {
        void eaten();
    }

    public interface Eat  //может кого-нибудь съесть
    {
        void eat();
    }
}



package com.javarush.test.level13.lesson11.home01;

/* Некорректные строки
Удали все некорректные строки в интерфейсе Button.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(SimpleObject.NAME);
        System.out.println(Button.NAME);
    }

    interface SimpleObject
    {
        String NAME = "SimpleObject";
        void onPress();
    }

    interface Button extends SimpleObject
    {

        final String NAME = "Submit";
        public void onPress();
        protected void onPress();
        void onPress();
        private void onPress();

        protected String onPress(Object o);
        String onPress(Object o);
        private String onPress(Object o);

    }
}



package com.javarush.test.level13.lesson11.home02;

/* Погода
1. В классе Today реализовать интерфейс Weather.
2. Подумай, как связан параметр String type с методом getWeatherType().
3. Интерфейсы Weather и WeatherType уже реализованы.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FROZEN));
    }

    static class Today
    {
        private String type;

        Today(String type)
        {
            this.type = type;
        }

        @Override
        public String toString()
        {
            return String.format("%s for today", this.getWeatherType());
        }
    }
}

package com.javarush.test.level13.lesson11.home02;

public interface WeatherType
{
    String CLOUDY = "Cloudy";
    String FOGGY = "Foggy";
    String FROZEN = "Frozen";
}

package com.javarush.test.level13.lesson11.home02;

public interface Weather
{
    String getWeatherType();
}



package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
    }
}


package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        
    }
}


package com.javarush.test.level13.lesson11.home05;

/* Neo
1. Реализовать интерфейс DBObject в классе User.
2. Реализовать метод initializeIdAndName так, чтобы программа работала и выводила на экран "User has name Neo, id = 1".
3. Метод toString и метод main менять нельзя.
4. Подумай, что должен возвращать метод initializeIdAndName в классе User.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(Matrix.NEO);
    }


    static class Matrix
    {
       public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject
    {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User
    {
        long id;
        String name;

        @Override
        public String toString()
        {
            return String.format("User has name %s, id = %d", name, id);
        }
    }

}


package com.javarush.test.level13.lesson11.home06;

/* Исправление ошибок
1. Переделай наследование в классах и интерфейсах так, чтобы программа компилировалась и продолжала делать то же самое.
2. Класс Hobbie должен наследоваться от интерфейсов Desire, Dream.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        System.out.println(Dream.HOBBIE.toString());
        System.out.println(new Hobbie().INDEX);
    }

    interface Desire
    {
    }

    interface Dream implements Hobbie
    {
        static Hobbie HOBBIE = new Hobbie();
    }

    static class Hobbie extends Desire, Dream
    {
        static int INDEX = 1;

        @Override
        public String toString()
        {
            INDEX++;
            return "" + INDEX;
        }
    }

}



package com.javarush.test.level13.lesson11.home07;

/* Интерфейс SimpleObject
1. Создай класс StringObject.
2. В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
3. Программа должна компилироваться.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

}


package com.javarush.test.level13.lesson11.home08;

/* Интерфейс Updatable в классе Screen
Реализовать интерфейс Updatable в классе Screen.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    interface Selectable
    {
        void onSelect();
    }

    interface Updatable extends Selectable
    {
        void refresh();
    }

    class Screen
    {

    }
}


package com.javarush.test.level13.lesson11.home09;

import java.awt.*;

/* Один метод в классе
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
3. Методы удалять нельзя!
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    public interface Animal
    {
        Color getColor();

        Integer getAge();
    }

    public static class Fox
    {
        public String getName()
        {
            return "Fox";
        }
    }
}


package com.javarush.test.level13.lesson11.home10;

import java.awt.*;

/* Компиляция программы
1. Исправь классы Fox и BigFox так, чтобы программа компилировалась. Задача не предполагает создания экземпляров базового класса.
2. Метод main менять нельзя.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
       Fox bigFox = new BigFox();
       System.out.println(bigFox.getName());
       System.out.println(bigFox.getColor());
    }

    public interface Animal
    {
        Color getColor();
    }

      public static class Fox implements Animal
      {
          public String getName() {
              return "Fox";
          }
      }

    public abstract static class BigFox
    {

    }

}

package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
    }
}


package com.javarush.test.level13.lesson11.bonus02;

import java.util.ArrayList;
import java.util.List;

/* Репка
Сказка Репка:
1. Реализовать интерфейс RepkaItem в классе Person.
2. В классе Person реализовать метод pull(Person person), который выводит фразу типа '<name> за <person>'. Пример:
Бабка за Дедку
Дедка за Репку
3. Исправить логическую ошибку цикла в методе tell класса RepkaStory.
4. Выполнить метод main и наслаждаться сказкой!
*/

public class Solution
{
    public static void main(String[] args)
    {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }
}

package com.javarush.test.level13.lesson11.bonus02;

public class Person
{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }
}

package com.javarush.test.level13.lesson11.bonus02;

public interface RepkaItem
{
    public String getNamePadezh();
}

package com.javarush.test.level13.lesson11.bonus02;

import java.util.List;

public class RepkaStory
{
    static void tell(List<Person> items) {

        Person first;
        Person second;
        for (int i = items.size() - 1; i > 0; i--) {
            first = items.get(i - 1);
            second = items.get(i);
            first.pull(second);
        }
    }
}


package com.javarush.test.level14.lesson02.task01;

/* Bingo
Исправь строчку 'Object o = new Pet();' в методе main так, чтобы программа вывела "Bingo!"
*/

public class Solution
{
    public static void main(String[] args)
    {
        Object o = new Pet();
        boolean isCat = o instanceof Cat;
        boolean isTiger = o instanceof Tiger;
        boolean isPet = o instanceof Pet;

        printResults(isCat, isTiger, isPet);
    }

    private static void printResults(boolean cat, boolean tiger, boolean pet)
    {
        if (cat && tiger && pet) System.out.println("Bingo!");
    }

    static class Pet
    {
    }

    static class Cat extends Pet
    {
    }

    static class Tiger extends Cat
    {
    }

}


package com.javarush.test.level13.lesson11.bonus03;

/* Битва роботов
1 Разобраться в том, что тут написано.
2 http://info.javarush.ru/uploads/images/00/00/07/2014/08/12/50f3e37f94.png
3 Смириться со своей участью и продолжить разбираться в коде.
4 ...
5 Порадоваться, что мы все поняли.

6 Изменить код согласно новой архитектуре и добавить новую логику:
6.1 Сделать класс AbstractRobot абстрактным, вынести логику атаки и защиты из Robot в AbstractRobot.
6.2 Отредактировать класс Robot учитывая AbstractRobot.
6.3 Расширить класс BodyPart новой частью тела "грудь".
6.4 Добавить новую часть тела в реализацию интерфейсов Attackable и Defensable (в классе AbstractRobot).

7 http://info.javarush.ru/uploads/images/00/00/07/2014/08/12/3b9c65580b.png
*/

public class Solution
{
    public static void main(String[] args)
    {
        Robot amigo = new Robot("Амиго");
        Robot enemy = new Robot("Сгибальщик-02");

        doMove(amigo, enemy);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
    }

    public static void doMove(AbstractRobot robotFirst, AbstractRobot robotSecond) {
        BodyPart attacked = robotFirst.attack();
        BodyPart defenced = robotFirst.defense();
        System.out.println(String.format("%s атаковал робота %s, атакована %s, защищена %s",
                robotFirst.getName(), robotSecond.getName(), attacked, defenced));
    }
}


package com.javarush.test.level13.lesson11.bonus03;

public interface Attackable
{
    BodyPart attack();
}


package com.javarush.test.level13.lesson11.bonus03;

public interface Defensable
{
    BodyPart defense();
}


package com.javarush.test.level13.lesson11.bonus03;

public class Robot implements Attackable, Defensable
{
    private static int hitCount;
    private String name;

    public Robot(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public BodyPart attack()
    {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1)
        {
            attackedBodyPart =  BodyPart.ARM;
        } else if (hitCount == 2)
        {
            attackedBodyPart =  BodyPart.HEAD;
        } else if (hitCount == 3)
        {
            hitCount = 0;
            attackedBodyPart =  BodyPart.LEG;
        }
        return attackedBodyPart;
    }

    public BodyPart defense()
    {
        BodyPart defencedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1)
        {
            defencedBodyPart =  BodyPart.HEAD;
        } else if (hitCount == 2)
        {
            defencedBodyPart =  BodyPart.LEG;
        } else if (hitCount == 3)
        {
            hitCount = 0;
            defencedBodyPart =  BodyPart.ARM;
        }
        return defencedBodyPart;
    }
}


package com.javarush.test.level13.lesson11.bonus03;

public class AbstractRobot
{
}


package com.javarush.test.level13.lesson11.bonus03;

public final class BodyPart
{
    final static BodyPart LEG = new BodyPart("нога");
    final static BodyPart HEAD = new BodyPart("голова");
    final static BodyPart ARM = new BodyPart("рука");

    private String bodyPart;

    private BodyPart(String bodyPart)
    {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString()
    {
        return this.bodyPart;
    }
}


package com.javarush.test.level14.lesson02.task02;

/* Bingo-2
Исправь строчку 'Cat o = new Cat();' так, чтобы программа вывела "Bingo!"
*/

public class Solution
{
    public static void main(String[] args)
    {
        Cat o = new Cat();

        boolean isCat = o instanceof Cat;
        boolean isMoveable = o instanceof Moveable;
        boolean isTom = o instanceof TomCat;

        if (isCat && isMoveable && isTom) System.out.println("Bingo!");

    }

    interface Moveable
    {
    }

    static class Cat
    {
    }

    static class TomCat extends Cat implements Moveable
    {

    }
}


package com.javarush.test.level14.lesson04.task01;

/* Building и School
1. Расставь правильно наследование между Building(здание) и School(здание школы).
2. Подумай, объект какого класса должны возвращать методы getSchool и getBuilding.
3. Измени null на объект класса Building или School.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool()
    {
        //измените null на объект класса Building или School
        return null;
    }

    public static Building getBuilding()
    {
        //измените null на объект класса Building или School
        return null;
    }

    static class School /*Add your code here*/
    {
        @Override
        public String toString()
        {
            return "School";
        }
    }

    static class Building /*Add your code here*/
    {
        @Override
        public String toString()
        {
            return "Building";
        }
    }
}


package com.javarush.test.level14.lesson04.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Коты
1. Считывать строки(параметры) с консоли, пока пользователь не введет пустую строку(Enter).
2. Каждый параметр соответствует имени кота.
Для каждого параметра:
3. Создать объект cat класса Cat, который равен коту из getCatByKey(String параметр).
4. Вывести на экран cat.toString().
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Add your code here
    }

    static class CatFactory
    {

        static Cat getCatByKey(String key)
        {
            Cat cat = null;
            if ("vaska".equals(key))
            {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key))
            {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key))
            {
                cat = new FemaleCat("Кисюлька");
            } else
            {
                cat = new Cat(key);
            }

            return cat;
        }
    }

    static class Cat
    {
        private String name;

        protected Cat(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return this.name;
        }

        public String toString()
        {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat
    {
        MaleCat(String name)
        {
            super(name);
        }

        public String toString()
        {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat
    {
        FemaleCat(String name)
        {
            super(name);
        }

        public String toString()
        {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}



package com.javarush.test.level14.lesson04.task03;

/* Food
1. Реализовать интерфейс Selectable в классе Food.
2. Метод onSelect() должен писать в консоль "food is selected".
3. Подумай, какие методы можно вызвать для переменной food и какие для selectable.
4. В методе foodMethods вызови методы onSelect, eat, если это возможно.
5. В методе selectableMethods вызови методы onSelect, eat, если это возможно.
6. Явное приведение типов не использовать.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Food food = new Food();
        Selectable selectable = new Food();
        Food newFood = (Food) selectable;

        foodMethods(food);
        selectableMethods(selectable);
    }

    public static void foodMethods(Food food)
    {
        //тут добавьте вызов методов для переменной food
    }

    public static void selectableMethods(Selectable selectable)
    {
        //тут добавьте вызов методов для переменной selectable
    }

    interface Selectable
    {
        void onSelect();
    }

    static class Food
    {
        public void eat()
        {
            System.out.println("food is eaten");
        }
    }
}



package com.javarush.test.level14.lesson04.task04;

/* Без ошибок
Инициализировать объект obj таким классом, чтобы метод main выполнился без ошибок.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Object obj = //Add your code here

        Mouse mouse = (Mouse) obj;
        GreyMouse greyMouse = (GreyMouse) mouse;
        Jerry jerry = (Jerry) greyMouse;

        printClasses(obj, mouse, greyMouse, jerry);

    }

    public static void printClasses(Object obj, Mouse mouse, GreyMouse greyMouse, Jerry jerry)
    {
        System.out.println(jerry.getClass().getSimpleName());
        System.out.println(greyMouse.getClass().getSimpleName());
        System.out.println(mouse.getClass().getSimpleName());
        System.out.println(obj.getClass().getSimpleName());
    }

    static class Mouse
    {
    }

    static class GreyMouse extends Mouse
    {
    }

    static class Jerry extends GreyMouse
    {
    }
}


package com.javarush.test.level14.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Player and Dancer
1. Подумать, что делает программа.
2. Изменить метод haveRest так, чтобы он вызывал метод
- play, если person имеет тип Player
- dance, если person имеет тип Dancer
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = null;
        String key;
        while (!(key = reader.readLine()).equals("exit"))
        {
            if ("player".equals(key))
            {
                person = new Player();
            } else if ("dancer".equals(key))
            {
                person = new Dancer();
            }
            haveRest(person);
        }
    }

    public static void haveRest(Person person)
    {
        //Add your code here
    }

    interface Person
    {
    }

    static class Player implements Person
    {
        void play()
        {
            System.out.println("playing");
        }
    }

    static class Dancer implements Person
    {
        void dance()
        {
            System.out.println("dancing");
        }
    }
}


package com.javarush.test.level14.lesson06.home01;

/* Куриная фабрика
Написать Фабрику(Factory) по производству кур(Hen)
1. Создать класс Hen
1.1. Сделать его абстрактным
1.2. Добавить в класс абстрактный метод  int getCountOfEggsPerMonth()
1.3. Добавить в класс метод String getDescription(), который возвращает строку "Я курица."

2. Создать класс RussianHen, который наследуется от Hen
3. Создать класс UkrainianHen, который наследуется от Hen
4. Создать класс MoldovanHen, который наследуется от Hen
5. Создать класс BelarusianHen, который наследуется от Hen

6. В каждом из четырех последних классов написать свою реализацию метода getCountOfEggsPerMonth.
Методы должны возвращать количество яиц в месяц от данного типа куриц.

7. В каждом из четырех последних классов написать свою реализацию метода getDescription.
Методы должны возвращать строку вида:
<getDescription() родительского класса>  + <" Моя страна - Sssss. Я несу N яиц в месяц.">
где Sssss - название страны
где N - количество яиц в месяц

8. В классе HenFactory реализовать метод getHen, который возвращает соответствующую стране породу кур
9. Все созданные вами классы должны быть в отдельных файлах
*/

public class Solution
{
    public static void main(String[] args)
    {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //add your code here
            return hen;
        }
    }


}
package com.javarush.test.level14.lesson06.home01;

public interface Country
{
    String UKRAINE = "Ukraine";
    String RUSSIA = "Russia";
    String MOLDOVA = "Moldova";
    String BELARUS = "Belarus";
}





package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        {
        //создаем объект, пункт 2

        doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person)
    {
        // пункт 3
    }
}

package com.javarush.test.level14.lesson08.home03;

public interface Person
{
    public static class User implements Person
    {
        void live()
        {
            System.out.println("Usually I just live");
        }
    }

    public static class Looser implements Person
    {
        void doNothing()
        {
            System.out.println("Usually I do nothing");
        }
    }

    public static class Coder implements Person
    {
        void coding()
        {
            System.out.println("Usually I create code");
        }
    }

    public static class Proger implements Person
    {
        void enjoy()
        {
            System.out.println("Wonderful life!");
        }
    }

}


package com.javarush.test.level14.lesson08.home04;

/* Реализовать метод printMainInfo
1. Напиши реализацию метода printMainInfo, чтобы:
1.1. Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
1.2. Если в метод передают объект типа Movable, у этого объекта вызывался метод move.
2. Метод main менять нельзя.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object)
    {
        
    }

    static interface Movable
    {

        void move();
    }

    static class Circle implements Movable
    {

        public void draw()
        {
            System.out.println("can be drawn");
        }

        public void move()
        {
            System.out.println("can be moved");
        }

    }

    static interface Drawable
    {
        void draw();
    }

    static class Rectangle implements Drawable
    {
        public void draw()
        {
            System.out.println("can be drawn");
        }

        public void move()
        {
            System.out.println("can be moved");
        }
    }
}


package com.javarush.test.level14.lesson08.home05;

/* Computer
1. Создай интерфейс CompItem.
2. Добавь в него метод String getName().
3. Создай классы Keyboard, Mouse, Monitor, которые реализуют интерфейс CompItem.
4. Метод getName() должен возвращать имя класса, например, для класса Keyboard будет "Keyboard".
5. Создай класс Computer.
6. В класс Computer добавь приватное поле типа Keyboard.
7. В класс Computer добавь приватное поле типа Mouse.
8. В класс Computer добавь приватное поле типа Monitor.
9. Создай конструктор в классе Computer используя комбинацию клавиш Alt+Insert внутри класса (команда Constructor).
10 Внутри конструктора инициализируйте все три поля (переменных) класса
11. Создай геттеры для полей класса Computer (в классе используй комбинацию клавиш Alt+Insert и выбери команду Getter).
12. Все созданные классы и интерфейс должны быть в отдельных файлах.
13. Класс Solution менять нельзя.
*/

public class Solution
{

    public static void main(String[] args)
    {
        Computer computer = new Computer();
        if (isWork(computer.getKeyboard()) &&
                isWork(computer.getMonitor()) &&
                isWork(computer.getMouse()))
        {
            System.out.println("Work!");
        }
    }

    public static boolean isWork(CompItem item)
    {
        System.out.println(item.getName());
        return item.getName() != null && item.getName().length() > 4;
    }

}

package com.javarush.test.level14.lesson08.home06;

/* MovieFactory
Расширение функционала по аналогии, чтение с консоли:
1. Разобраться, что программа умеет делать.
2. Все классы должны быть внутри класса Solution.
3. Добавить классы Cartoon, Thriller.
4. Разобраться, как мы получаем объект класса SoapOpera по ключу "soapOpera".
Аналогично получению объекта SoapOpera сделать:
5. Добавить в MovieFactory.getMovie получение объекта Cartoon для ключа "cartoon".
6. Добавить в MovieFactory.getMovie получение объекта Thriller для ключа "thriller".

7. Считать с консоли несколько ключей (строк).
7.1. Ввод заканчивается, как только вводится строка не совпадающая с одной из: "cartoon", "thriller", "soapOpera".
8. Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1. Получить объект используя MovieFactory.getMovie и присвоить его переменной movie.
8.2. Вывести на экран movie.getClass().getSimpleName().
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //ввести с консоли несколько ключей (строк), пункт 7

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory
    {

        static Movie getMovie(String key)
        {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key))
            {
                movie = new SoapOpera();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie
    {
    }

    static class SoapOpera extends Movie
    {
    }

    //Напишите тут ваши классы, пункт 3
}



package com.javarush.test.level14.lesson08.home07;

import java.util.ArrayList;
import java.util.List;

/* Клининговый центр
Клининговый центр
1. Реализовать метод cleanAllApartaments.
Для каждого объекта из apartaments:
2. Для однокомнатных квартир (Apt1Room) вызвать метод clean1Room.
т.е. если объект типа Apt1Room, то вызвать у него метод clean1Room.
3. Для двухкомнатных квартир (Apt2Room) вызвать метод clean2Rooms
т.е. если объект типа Apt2Room, то вызвать у него метод clean2Rooms.
4. Для трехкомнатных квартир (Apt3Room) вызвать метод clean3Rooms
т.е. если объект типа Apt3Room, то вызвать у него метод clean3Rooms.
*/
public class Solution
{
    public static void main(String[] args)
    {
        List<Apartament> apartaments = new ArrayList<Apartament>();
        apartaments.add(new Apt1Room());
        apartaments.add(new Apt2Room());
        apartaments.add(new Apt3Room());

        cleanAllApartaments(apartaments);
    }

    public static void cleanAllApartaments(List<Apartament> apartaments)
    {
        //написать тут вашу реализацию пунктов 1-4
    }

    static interface Apartament
    {
    }

    static class Apt1Room implements Apartament
    {
        void clean1Room()
        {
            System.out.println("1 room is cleaned");
        }
    }

    static class Apt2Room implements Apartament
    {
        void clean2Rooms()
        {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class Apt3Room implements Apartament
    {
        void clean3Rooms()
        {
            System.out.println("3 rooms are cleaned");
        }
    }
}


package com.javarush.test.level14.lesson08.home08;

/* Исправление ошибок
1. Подумать, как связаны интерфейсы Swimable(способен плавать) и Walkable(способен ходить) с классом OceanAnimal(животное океана).
2. Расставить правильно наследование интерфейсов и класса OceanAnimal.
3. Подумать, как могут быть связаны классы  Orca(Косатка), Whale(Кит), Otter(Выдра) с классом OceanAnimal.
4. Расставить правильно наследование между классами Orca, Whale, Otter и классом OceanAnimal.
5. Подумать, какой класс должен реализовать интерфейс Walkable и добавить интерфейc этому классу.
6. Подумать, какое животное еще не умеет плавать и добавить ему интерфейс Swimable.
*/

public class Solution
{
    public static void main(String[] args)
    {
/*
        Swimable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
*/
    }

    public static void test(Swimable animal)
    {
        animal.swim();
    }

    static interface Walkable
    {
        void walk();
    }

    static interface Swimable
    {
        void swim();
    }

    static abstract class OceanAnimal
    {
        public void swim()
        {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.swimming();
        }

        private void swimming()
        {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimable getCurrentAnimal();
    }

    static class Orca
    {
    }

    static class Whale
    {

    }

    static class Otter
    {

    }
}



package com.javarush.test.level14.lesson08.home09;

import java.util.ArrayList;
import java.util.List;

/* Валюты
1. Реализуй метод getAmount в классе Money:
1.1. Подумай, какого типа нужно создать приватную переменную, если метод getAmount будет ее возвращать.
1.2. Создай приватную переменную этого типа и верни ее в методе getAmount.
1.3. В конструкторе присвой ей значение, полученное параметром.
2. В отдельном файле создай класс Hrivna.
3. Наследуй класс Hrivna от класса Money.
4. В классе Hrivna реализуй метод getCurrencyName, который возвращает "HRN".
5. В отдельном файле создай класс USD.
6. Наследуй класс USD от класса Money.
7. В классе USD реализуй метод getCurrencyName, который возвращает "USD".
8. Подумай, объекты каких классов можно добавить в список(лист) allMoney.
9. Добавь в конструктор класса Person заполнение листа allMoney объектами всех возможных классов.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney())
        {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person
    {
        public String name;

        Person(String name)
        {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //Add your code here
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney()
        {
            return allMoney;
        }
    }
}







package com.javarush.test.level14.lesson08.home10;

import java.util.LinkedList;
import java.util.List;

/* Исправить 4 ошибки
Исправить 4 ошибки в конструкторе NotIncapsulatedClass и отрефактори код
1. В класе NotIncapsulatedClass создать private методы initList(List<Number> list), printListValues, processCastedObjects.
2. Метод initList должен заполнять значениями входящий параметр list:
- найди нужный блок кода в конструкторе, в котором list заполняется значениями
- перенеси его в метод initList
- верни заполненный list.
3. Метод printListValues должен принимать параметр list и вывести в консоль все элементы из списка list:
- метод ничего не возвращает
- найди нужный блок кода в конструкторе, в котором в цикле из списка list выводятся в консоль все значения
- перенеси его в метод printListValues
- исправь 2 ошибки в этом методе.
4. Метод processCastedObjects:
- входящий параметр метода имеет тип List<Number> list
- метод ничего не возвращает
- найди нужный блок кода в конструкторе, в котором в цикле для каждого объекта из списка list проверяется его тип
- перенеси этот блок в метод processCastedObjects
- исправь 2 ошибки в этом методе
- учти, что для объекта типа Float нужно вывести "Is float value defined? " + [Float_object].isNaN()
- учти, что для объекта типа Double нужно вывести "Is double value infinite? " + [Double_object].isInfinite().
*/

public class Solution
{
    public static void main(String[] args)
    {
        new NotIncapsulatedClass();
    }

    public static class NotIncapsulatedClass
    {
        public NotIncapsulatedClass()
        {
            List<Number> list = new LinkedList<Number>();
            //1
            list.add(new Double(1000f));
            list.add(new Double("123e-445632"));
            list.add(new Float(-90 / -3));
            list.remove(new Double("123e-445632"));

            //2 - Исправь 2 ошибки
            for (int i = 0; i <= list.size(); i--)
            {
                System.out.println(list.get(i));
            }

            //3
            for (Number object : list)
            {
                //Исправь 2 ошибки
                if (object instanceof Float)
                {
                    Double a = (Double) object;
                    System.out.println("Is float value defined? " + a.isNaN());
                } else if (object instanceof Double)
                {
                    Float a = (Float) object;
                    System.out.println("Is double value infinite? " + a.isInfinite());
                }
            }
        }
    }
}

package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

    }
}

package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/


public class Solution
{
    public static void main(String[] args) throws Exception
    {
     
    }
}



package com.javarush.test.level14.lesson08.bonus03;

/* Singleton
Класс является синглтоном (реализует паттерн(шаблон) Singleton), если позволяет создать всего один объект своего типа.

Реализовать Singleton pattern:
1. Создай класс Singleton в отдельном файле.
2. Добавь в него статический метод getInstance().
3. Метод getInstance должен возвращать один и тот же объект класса Singleton при любом вызове метода getInstance.
4. Подумай, каким образом можно запретить создание других объектов этого класса.
5. Сделай все конструкторы в классе Singleton приватными (private).

6. В итоге должна быть возможность создать объект (экземпляр класса) ТОЛЬКО используя метод getInstance.
*/
public class Solution
{
    public static void main(String[] args)
    {
    }
}

package com.javarush.test.level15.lesson02.task01;

/* ООП - Расставить интерфейсы
1. Добавить все возможные интерфейсы из Movable, Sellable, Discountable в класс Clothes.
2. Реализовать их методы.
*/

public class Solution {
    public static interface Movable {
        boolean getAllowedAction(String name);
    }

    public static interface Sellable {
        Object getAllowedAction(String name);
    }

    public static interface Discountable {
        Object getAllowedAction();
    }

    public static class Clothes {
    }
}


package com.javarush.test.level15.lesson02.task02;

/* ООП - наследование животных
1. Создать public static класс Goose(Гусь).
2. Создать public static класс Dragon(Дракон).
3. Унаследовать класс Goose от BigAnimal или SmallAnimal, подумать, какой логически больше подходит.
4. Унаследовать класс Dragon от BigAnimal или SmallAnimal, подумать, какой логически больше подходит.
5. В классах Goose и Dragon переопределить метод String getSize(), расширить видимость до максимальной.
6. В классе Goose метод getSize должен возвращать строку "Гусь маленький, " + [getSize родительского класса].
7. В классе Dragon метод getSize должен возвращать строку "Дракон большой, " + [getSize родительского класса].
*/

public class Solution {
    //добавьте классы Goose и Dragon тут

    public static class BigAnimal {
        protected String getSize() {
            return "как динозавр";
        }
    }

    public static class SmallAnimal {
        String getSize() {
            return "как кошка";
        }
    }
}





package com.javarush.test.level15.lesson02.task03;

/* ООП - машинки
1. Для вывода использовать можно только переменные из класса Constants.
2. В классе Ferrari реализуйте метод printlnDesire, чтобы он выводил на экран "Я хочу ездить на Феррари".
3. В классе Lanos реализуйте метод printlnDesire, чтобы он выводил на экран "Я хочу ездить на Ланосе".
4. Создайте public static класс LuxuriousCar(РоскошнаяМашина).
5. Создайте public static класс CheapCar(ДешеваяМашина).
6. Унаследуйте Ferrari и Lanos от CheapCar и LuxuriousCar, подумайте, какой класс для кого.
7. В классе LuxuriousCar реализуйте метод printlnDesire, чтобы он выводил на экран "Я хочу ездить на роскошной машине".
8. В классе CheapCar реализуйте метод printlnDesire, чтобы он выводил на экран "Я хочу ездить на дешевой машине".
9. В класах LuxuriousCar и CheapCar для метода printlnDesire расставьте различными способами модификаторы доступа так,
чтобы в классах Ferrari и Lanos выполнялось расширение видимости.
*/

public class Solution {
    public static void main(String[] args) {
        new Solution.LuxuriousCar().printlnDesire();
        new Solution.CheapCar().printlnDesire();
        new Solution.Ferrari().printlnDesire();
        new Solution.Lanos().printlnDesire();
    }

    public static class Ferrari {
        public void printlnDesire() {
            //add your code here
        }
    }

    public static class Lanos {
        public void printlnDesire() {
            //add your code here
        }
    }

    public static class Constants {
        public static String WANT_STRING = "Я хочу ездить на ";
        public static String LUXURIOUS_CAR = "роскошной машине";
        public static String CHEAP_CAR = "дешевой машине";
        public static String FERRARY_NAME = "Феррари";
        public static String LANOS_NAME = "Ланосе";
    }
}


package com.javarush.test.level15.lesson02.task04;

/* ООП - книги
1. Создайте public static класс MarkTwainBook, который наследуется от Book. Имя автора [Mark Twain]. Параметр конструктора - имя книги.
2. В классе MarkTwainBook реализуйте все абстрактные методы.
3. Для метода getBook расширьте тип возвращаемого результата.
4. Создайте по аналогии AgathaChristieBook. Имя автора [Agatha Christie].
5. В классе Book реализуйте тело метода getOutputByBookType так, чтобы он возвращал:
5.1. agathaChristieOutput для книг Агаты Кристи;
5.2. markTwainOutput для книг Марка Твена.
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    public abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getName();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ", " + getBook().getName() + " is a detective";
            String markTwainOutput = getBook().getName() + " book was written by " + author;

            String output = "output";
            //Add your code here

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }
}

package com.javarush.test.level15.lesson02.task05;

import java.util.ArrayList;
import java.util.List;

/* ООП - исправь ошибки в наследовании
Исправь метод containsBones и всю связанную с ним логику так, чтобы:
1. Поведение программы осталось прежним, т.е. она должна выдавать то же самое, что и выдает сейчас
2. Метод containsBones должен возвращать тип Object и значение "Yes" вместо true, "No" вместо false
*/

public class Solution {
    public static interface Alive {
        boolean containsBones();
    }

    public static class BodyPart implements Alive {
        private String name;

        public BodyPart(String name) {
            this.name = name;
        }

        public boolean containsBones() {
            return true;
        }

        public String toString() {
            return containsBones() ? name + " содержит кости" : name + " не содержит кости";
        }
    }

    public static class Finger extends BodyPart {
        private boolean isFoot;
        public Finger(String name, boolean isFoot) {
            super(name);
            this.isFoot = isFoot;
        }

        public boolean containsBones() {
            return super.containsBones() && !isFoot;
        }
    }
    public static void main(String[] args)
    {
        printlnFingers();
        printlnBodyParts();
        printlnAlives();
    }

    private static void printlnAlives() {
        System.out.println(new BodyPart("Рука").containsBones());
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Рука"));
        bodyParts.add(new BodyPart("Нога"));
        bodyParts.add(new BodyPart("Голова"));
        bodyParts.add(new BodyPart("Тело"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() {
        List<Finger> fingers = new ArrayList<Finger>(5);
        fingers.add(new Finger("Большой", true));
        fingers.add(new Finger("Указательный", true));
        fingers.add(new Finger("Средний", true));
        fingers.add(new Finger("Безымянный", false));
        fingers.add(new Finger("Мизинец", true));
        System.out.println(fingers.toString());
    }
}

package com.javarush.test.level15.lesson04.task01;

/* Что-то лишнее
1. Программа должна выводить следующее:
Это double
Это Object
Это double
Это Integer
Это double

2 Удалите реализации всех лишних методов
*/

public class Solution {
    public static void main(String[] args) {
        print((short) 1);
        print((Number) 1);
        print(1);
        print((Integer) 1);
        print((int) 1);
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

    public static void print(int i) {
        System.out.println("Это Integer");
    }

    public static void print(Short i) {
        System.out.println("Это Object");
    }

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

    public static void print(Double i) {
        System.out.println("Это double");
    }

    public static void print(float i) {
        System.out.println("Это Double");
    }
}

package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}

package com.javarush.test.level15.lesson04.task03;

/* ООП - Перегрузка - убираем лишнее
1. Подумайте, какая из реализаций метода print будет вызвана.
2. Удалите все лишние реализации метода print.
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
    }

    public static void print(byte b) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(double d) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(float f) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(char c) {
        System.out.println("Я буду Java прогером!");
    }
}

package com.javarush.test.level15.lesson04.task04;

/* Мужчина или женщина?
1. В методе main создать 2 человека man и woman. man с типом Man, woman с типом Woman.
2. Изменить метод printName так, чтобы он выполнялся для man и woman.
3. Реализация метода printName должна быть одна.
*/

public class Solution {
    public static void main(String[] args) {
        man = new Man();
        woman = new Woman();

        printName(man);
        printName(woman);
    }

    public static void printName(Man man) {

    }

    public static class Human {

    }

    public static class Man extends Human {

    }

    public static class Woman extends Human {

    }
}

package com.javarush.test.level15.lesson04.task05;

/* Все лишнее - прочь!
Убрать в методе main лишние строки, для которых метод add нереализован.
*/

public class Solution {
    public static void main(String[] args) {
        add((short) 1, 2f);
        add(1, 2);
        add(2d, 2);
        add("1",2d);
        add((byte) 1, 2d);
    }

    public static void add(int i, int j) {
        System.out.println("Integer addition");
    }

    public static void add(int i, double j) {
        System.out.println("Integer and double addition");
    }

    public static void add(double i, double j) {
        System.out.println("Double addition");
    }
}

package com.javarush.test.level15.lesson06.task01;

import java.io.Serializable;

/* Максимально простой код 1
Упрости код - убери все наследования и реализации, которые и так будут добавлены автоматически при компиляции
PS: Взаимосвязь между объектами me и zapp - Has-a (использует): http://ru.wikipedia.org/wiki/Has-a
*/

public class Solution {
    public static void main(String[] args) {
        JuniorJavaDev me = new JuniorJavaDev();
        System.out.println(me.askHubert("What do you think about level15.lesson06.task01?"));
        System.out.println(me.askZapp("When will be the next update?"));
    }

    public interface SpecificSerializable extends Serializable {
    }

    public static class JavaDev extends Object implements SpecificSerializable {
        String answerQuestion(String question) {
            return String.format("I'll be thinking of [%s]", question);
        }
    }

    public static class JuniorJavaDev extends Object, JavaDev implements SpecificSerializable {
        JavaDev zapp = new JavaDev();
        JavaDev hubert = new JavaDev();

        String askZapp(String question) {
            return zapp.answerQuestion(question);
        }

        String askHubert(String question) {
            return hubert.answerQuestion(question);
        }
    }
}

package com.javarush.test.level15.lesson06.task02;

/* Максимально простой код 2
Посмотри, что, связанное с конструкторами, может быть добавлено при компиляции, но в этой программе уже присутствует.
Упрости код - удали все конструкторы и вызовы конструкторов супер-классов, которые создаются и добавляются автоматически.

PS: Взаимосвязь между объектами классов NakedCat и NormalCat, SiamCat - Is-a (наследование): http://en.wikipedia.org/wiki/Is-a
http://cs7002.vk.me/c7007/v7007577/1411a/_dAiEola310.jpg
*/

public class Solution {
    public static void main(String[] args) {
        SiamCat simka = new SiamCat("Simka");
        NakedCat nakedSimka = simka.shave();
    }

    public static class NakedCat {
        public NakedCat() {
            super();
        }
    }

    public static class NormalCat extends NakedCat {
        public NormalCat() {
            super();
        }

        public NormalCat(String name) {
            System.out.println("My name is " + name);
        }

        public NakedCat shave() {
            return this;
        }
    }

    public static class SiamCat extends NormalCat {
        public SiamCat(String name) {
            super(name);
        }
    }
}


package com.javarush.test.level15.lesson06.task03;

/* Максимально простой код 3
Упрости код:
- убери всё то, что будет генерироваться автоматически при компиляции
- убери все наследования классов, которые и так будут добавлены автоматически при компиляции
- убери все конструкторы, которые создаются и добавляются автоматически.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public interface Runnable {

    }

    public class Machine extends Object implements Runnable {
        public Machine() {
            super();
        }
    }

    public class Car extends Machine implements Runnable {
        public Car() {
            super();
        }
    }
}


package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
}

package com.javarush.test.level15.lesson09.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Статики 2
1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.
3. Закрыть поток ввода методом close().
*/

public class Solution {
    public static int A;
    public static int B;

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}

package com.javarush.test.level15.lesson09.task04;

/* Статики и исключения
В статическом блоке выбросьте RuntimeException
В результате класс не загрузится, и вы увидите сообщение об ошибке вместо значения переменной B

Exception in thread "main" java.lang.ExceptionInInitializerError
at java.lang.Class.forName0(Native Method)
at java.lang.Class.forName(Class.java:186)
at com.intellij.rt.execution.application.AppMain.main(AppMain.java:113)
Caused by: java.lang.RuntimeException:
at com.javarush.test.level15.lesson09.task04.Solution.clinit(Solution.java:22)

Hint: Нужно погуглить причину, если получилось следующее:
java: initializer must be able to complete normally
java: unreachable statement
*/

public class Solution {
    public static int A = 0;

    static {
        //throw an exception here - выбросьте эксепшн тут
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}

package com.javarush.test.level15.lesson09.task03;

/* Статики 3
1. Создать 7 public полей класса. Убедитесь, что они инициализируются дефолтными значениями.
intVar с типом int
doubleVar с типом double
DoubleVar с типом Double
booleanVar с типом boolean
ObjectVar с типом Object
ExceptionVar с типом Exception
StringVar с типом String
2. В методе main вывести их значения в заданном порядке.
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level15.lesson09.task05;

/* Статики 4
Внутри статического блока:
1. Создайте класс Cat
2. Внутри Cat создайте поле класса String name = "Пушок"
3. Создайте объект класса Cat - myCat
4. Присвойте статическому объекту Object cat объект, созданный в п.3
5. Выведите в консоль myCat.name
*/

public class Solution {
    public static Object cat;
}

package com.javarush.test.level15.lesson12.home01;


import java.io.IOException;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}


package com.javarush.test.level15.lesson12.home02;

/* Тренировка мозга
Найти логическую ошибку: метод doAction в реализации интерфейса Movable должен выдавать "moving".
Исправьте ошибку, при необходимости измените (отрефакторите) интерфейс Movable.
Результат вывода в консоль должен быть:
flying
moving
*/

public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements Flyable, Movable {
        @Override
        public void doAction() {
            System.out.println("flying");
        }
    }

    public static class Util {
        static void fly(Flyable animal) {
            animal.doAction();
        }

        static void move(Movable animal) {
            animal.doAction();
        }
    }

    public static interface Flyable {
        void doAction();
    }

    public static interface Movable {
        void doAction();
    }
}

package com.javarush.test.level15.lesson12.home03;

import java.math.BigDecimal;

/* ООП - перегрузка
1.В классе Tree перегрузи метод info(Object s) два раза так, чтобы получилось три метода info(Object s), info(Number s), info(String s).
1.1. Разберись в методе info(Object s). Сделай по аналогии функционал новых методов.
1.2. Например, для метода info(Number s) результат может быть таким "Дерево № 123 , метод Number, параметр Short".
2. В блоке 2 должен вызываться метод info(Object s).
3. В блоке 3 должен вызываться метод info(Number s).
4. В блоке 4 должен вызываться метод info(String s).
*/

public class Solution {
    public static void main(String[] args) {
        //Блок 2.
        //Вызов для Object (задание 2)
        new Tree().info((Object)new Integer("4"));
        new Tree().info((Object)new Short("4"));
        new Tree().info((Object)new BigDecimal("4"));

        //Блок 3.
        //Вызов для Number (Задание 3)
        new Tree().info(new Integer("4"));
        new Tree().info(new Short("4"));
        new Tree().info(new BigDecimal("4"));

        //Блок 4.
        //Вызов для String (Задание 4)
        new Tree().info(new String("4"));
        new Tree().info(new Integer("4").toString());
        new Tree().info(new Short("4").toString());
        new Tree().info(new BigDecimal("4").toString());
    }
}

package com.javarush.test.level15.lesson12.home04;

/* Закрепляем Singleton pattern
1. Найти в гугле пример для - Singleton pattern Lazy initialization.
2. По образу и подобию в отдельных файлах создать три синглтон класса Sun, Moon, Earth.
3. Реализовать интерфейс Planet для классов Sun, Moon, Earth.
4. В статическом блоке класса Solution вызвать метод readKeyFromConsoleAndInitPlanet.
5. Реализовать функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считать один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet, то создать соответствующий объект и присвоить его Planet thePlanet, иначе обнулить Planet thePlanet.
5.3. Сравнивать введенный параметр можно только с константами из Planet, нельзя создавать свои строки.
*/

public class Solution {
    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        thePlanet = Sun.getInstance();
    }
}

package com.javarush.test.level15.lesson12.home04;

public interface Planet {
    static String SUN = "sun";
    static String MOON = "moon";
    static String EARTH = "earth";
}


package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/


public class Solution {
	
}


package com.javarush.test.level15.lesson12.home06;

/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name
*/

public class Solution {
    static {
        System.out.println("Static block");
    }

    {
        System.out.println("non-static block");
        printAllFields(this);
    }

    public int i = 6;

    public String name = "First name";
    static {
        init();
    }

    public Solution() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.name);
        System.out.println(obj.i);
    }
}


package com.javarush.test.level15.lesson12.home07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }
}


package com.javarush.test.level15.lesson12.home07;

public class Constants {
    public static String FILE_NAME = /* add your path to source file here*/;
}




package com.javarush.test.level15.lesson12.home10;

/* ООП - наследование
Исправить класс Hrivna так, чтоб избежать ошибку StackOverflowError, класс Money менять нельзя.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        public Object getAmount() {
            return getMoney().getAmount();
        }
    }

    //add your code below - добавь код ниже
    public static class Hrivna extends Money {
        public double amount = 123d;

        public Hrivna getMoney() {
            return this;
        }
    }
}


package com.javarush.test.level15.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь 1 конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String. Параметр может быть "plane" или "helicopter".
3.2. Если параметр равен "helicopter", то статическому объекту Flyable result присвоить объект класса Helicopter.
3.3. Если параметр равен "plane", то считать второй параметр типа int, статическому объекту Flyable result присвоить объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
5. Закрыть поток ввода методом close().
*/

public class Solution {
    static {
        //add your code here - добавьте код тут
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
    }
}


package com.javarush.test.level15.lesson12.bonus01;

public interface Flyable {
    void fly();
}


package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа включая его.
Пример: 4! = factorial(4) = 1*2*3*4 = 24
1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию  factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here

        return "";
    }
}


package com.javarush.test.level15.lesson12.bonus02;

/* Template pattern
1. В отдельном файле создать класс DrinkMaker с тремя абстрактными методами:
- void getRightCup() - выбрать подходящую чашку
- void putIngredient() - положить ингредиенты
- void pour() - залить жидкостью
2. В классе DrinkMaker создать и реализовать метод void makeDrink(), который готовит напиток в такой последовательности: выбирает чашку, кладет ингредиенты, заливает жидкостью.
3. В отдельных файлах создать классы LatteMaker и TeaMaker, которые наследуются от DrinkMaker.
4. Распредели следующие фразы между всеми методами в классах LatteMaker и TeaMaker, различные фразы для различных методов.
5. Каждый метод должен выводить в консоль свою фразу не пересекаясь с другими методами.
6. Фразы:
"Заливаем водой"
"Берем чашку для латте"
"Насыпаем чай"
"Берем чашку для чая"
"Заливаем молоком с пенкой"
"Делаем кофе"
*/

public class Solution {
    public static void main(String[] args) {
    }
}


package com.javarush.test.level16.lesson03.task01;

/* My first thread
Создать public static class TestThread - нить с помощью интерфейса Runnable.
TestThread должен выводить в консоль "My first thread".
*/
public class Solution {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }
}

package com.javarush.test.level16.lesson03.task02;

/* My second thread
1. Создать public static класс TestThread унаследовавшись от класса Thread.
2. Создать статик блок внутри TestThread, который выводит в консоль "it's static block inside TestThread".
3. Метод run должен выводить в консоль "it's run method".
*/

public class Solution {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
    }
}

package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}

package com.javarush.test.level16.lesson03.task04;

/* Вывод стек-трейса
1. Создать таск - класс public static SpecialThread - на основании интерфейса Runnable
2. SpecialThread должен выводить в консоль свой стек-трейс.
Подсказка: main thread уже выводит в консоль свой стек-трейс.
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SpecialThread());
        thread.start();

        System.out.println("*****************");

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
    }
}

package com.javarush.test.level16.lesson03.task05;

import java.util.Date;

/* Поговорим о музыке?
1. Измените класс Violin так, чтоб он стал таском для нити. Используйте интерфейс MusicalInstrument
2. Реализуй необходимый метод в нити Violin. Реализация должна быть следующей:
2.1. Считай время начала игры - метод startPlaying().
2.2. Подожди 1 секунду - метод sleepNSeconds(int n), где n - количество секунд.
2.3. Считай время окончания игры - метод stopPlaying().
2.4. Выведи на консоль продолжительность игры в миллисекундах. Пример "Playing 1002 ms".
*/

public class Solution {
    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static class Violin {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " starts playing");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " stops playing");
            return new Date();
        }
    }

    public static int delay = 1000;

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }
}

package com.javarush.test.level16.lesson05.task01;

import java.util.ArrayList;
import java.util.List;

/* join
Подумайте, в каком месте и для какого объекта нужно вызвать метод join, чтобы результат выводился по-порядку
сначала для firstThread, а потом для secondThread.
Вызовите метод join в нужном месте.
Пример вывода:
firstThread : String 1
firstThread : String 2
...
firstThread : String 19
firstThread : String 20
secondThread : String 1
...
secondThread : String 20
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        PrintListThread firstThread = new PrintListThread("firstThread");
        PrintListThread secondThread = new PrintListThread("secondThread");
        firstThread.start();
        secondThread.start();
    }

    public static class PrintListThread extends Thread {
        public PrintListThread(String name) {
            super(name);
        }

        public void run() {
            printList(getList(20), getName());
        }
    }

    public static void printList(List<String> list, String threadName) {
        for (String item : list) {
            System.out.println(String.format("%s : %s", threadName, item));
        }
    }

    public static List<String> getList(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 1) return result;

        for (int i = 0; i < n; i++) {
            result.add(String.format("String %d", (i + 1)));
        }
        return result;
    }
}

package com.javarush.test.level16.lesson05.task02;

import java.util.ArrayList;
import java.util.List;

/* Horse Racing
Разберись, что делает программа.
Реализуй метод calculateHorsesFinished. Он должен:
1. Посчитать количество финишировавших лошадей и возвратить его. Используй метод isFinished().
2. Если лошадь еще не пришла к финишу (!isFinished()), то:
2.1. Вывести в консоль "Waiting for " + horse.getName().
2.2. Подождать, пока она завершит гонку. Подумай, какой метод нужно использовать для этого.
*/

public class Solution {
    public static int countHorses = 10;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart();
        while (calculateHorsesFinished(horses) != countHorses) {
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int countFinished = 0;
        //add your implementation here - добавь свою реалзацию тут
        return countFinished;
    }

    public static class Horse extends Thread {

        public Horse(String name) {
            super(name);
        }

        private boolean isFinished;

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i < 1001; i++) {   //delay
                s += new String("" + i);
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }

    public static List<Horse> prepareHorsesAndStart() {
        List<Horse> horses = new ArrayList<Horse>(countHorses);
        String number;
        for (int i = 1; i < countHorses + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        for (int i = 0; i < countHorses; i++) {
            horses.get(i).start();
        }
        return horses;
    }
}


package com.javarush.test.level16.lesson05.task03;

/* Продвижение на политических дебатах
1. Разберитесь, что делает программа.
2. Нужно сделать так, чтобы Иванов сказал больше всего речей на политических дебатах.
3. Подумай, какой метод можно вызвать у объекта ivanov, чтобы Иванов разговаривал, пока не завершится всё свободное время.
*/

public class Solution {
    public static int totalCountSpeeches = 200;
    public static int soundsInOneSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        Politic ivanov = new Politic("Иванов");
        Politic petrov = new Politic("Петров");
        Politic sidorov = new Politic("Сидоров");

        while (ivanov.getCountSpeaches() + petrov.getCountSpeaches() + sidorov.getCountSpeaches() < totalCountSpeeches) {
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politic extends Thread {
        private int countSounds;

        public Politic(String name) {
            super(name);
            start();
        }

        public void run() {
            while (countSounds < totalCountSpeeches * soundsInOneSpeech) {
                countSounds++;
            }
        }

        public int getCountSpeaches() {
            return countSounds / soundsInOneSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getCountSpeaches());
        }
    }
}


package com.javarush.test.level16.lesson05.task04;

/* Справедливость
1. Разберитесь, что делает программа.
2. Нужно сделать так, чтобы все мыши ели одновременно.
3. Подумай, какой метод позволяет альфа-самцу мыши есть первым, и почему остальные мыши ждут.
4. Удали вызов этого метода.
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Mouse alpha = new Mouse("#1");
        alpha.join();
        Mouse mouse1 = new Mouse("#2");
        Mouse mouse2 = new Mouse("#3");
    }

    public static class Mouse extends Thread {
        public Mouse(String name) {
            super(name);
            start();
        }

        public void run() {
            System.out.println(getName() + " starts eating");
            eating();
            System.out.println(getName() + " finished");
        }
    }
    private static void eating() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}


package com.javarush.test.level16.lesson05.task05;

/* Расставь вызовы методов join()
1. Разберитесь, что делает программа.
2. Расставь вызовы методов join() так, чтобы для каждой кошки выполнялось следующее:
2.1. Сначала кошка рожает котят.
2.2. Потом все котята вылазят из корзинки в произвольном порядке.
2.3. В конце кошка собирает их назад в корзинку.
2.4. Все события для одной кошки могут быть перемешаны с событями для другой кошки.
2.5. Добавить сон котят (200 мс) в investigateWorld
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Пушинка");
    }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name) {
            super(name);
            kitten1 = new Kitten("Котенок 1, мама - " + getName());
            kitten2 = new Kitten("Котенок 2, мама - " + getName());
            start();
        }

        public void run() {
            System.out.println(getName() + " родила 2 котенка");
            try {
                initAllKitten();
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
        }

        private void initAllKitten() throws InterruptedException {
            kitten1.start();
            kitten2.start();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
            System.out.println(getName() + ", вылез из корзинки");
            investigateWorld();
        }
    }

    private static void investigateWorld() {

    }
}

package com.javarush.test.level16.lesson07.task01;

/* Часы
1. Разберись, что делает программа.
2. Реализуйте логику метода printTikTak:
2.1. Через первые полсекунды должна выводиться в консоль фраза: Tik.
2.2. Через вторые полсекунды должна выводиться в консоль фраза: Tak.
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("Clock has to be stopped");
        Thread.sleep(1000);
        System.out.println("Double-check");
    }

    public static class Clock extends Thread {
        public Clock() {
            setPriority(MAX_PRIORITY);
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTikTak();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTikTak() throws InterruptedException {
            //add your code here - добавь код тут
        }
    }
}


package com.javarush.test.level16.lesson07.task02;

/* Stopwatch (Секундомер)
1. Разберись, что делает программа.
2. Реализуй логику метода doSeveralSteps так, чтобы учитывалась скорость бегуна.
2.1. Метод getSpeed() в классе Runner показывает, сколько шагов в секунду делает бегун.
Нужно, чтобы бегун действительно делал заданное количество шагов в секунду.
Если Иванов делает 4 шага в секунду, то за 2 секунды он сделает 8 шагов.
Если Петров делает 2 шага в секунду, то за 2 секунды он сделает 4 шага.
2.2. Метод sleep в классе Thread принимает параметр типа long.
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Runner ivanov = new Runner("Ivanov", 4);
        Runner petrov = new Runner("Petrov", 2);
        //на старт!
        //внимание!
        //марш!
        ivanov.start();
        petrov.start();
        Thread.sleep(2000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Stopwatch extends Thread {
        private Runner owner;
        private int stepNumber;

        public Stopwatch(Runner runner) {
            this.owner = runner;
        }

        public void run() {
            try {
                while (!isStopped) {
                    doSeveralSteps();
                }
            } catch (InterruptedException e) {
            }
        }

        private void doSeveralSteps() throws InterruptedException {
            stepNumber++;
            //add your code here - добавь код тут
            System.out.println(owner.getName() + " делает шаг №" + stepNumber + "!");
        }
    }

    public static class Runner {
        private String name;
        private double speed;
        Stopwatch stopwatch;

        public Runner(String name, double speed) {
            this.name = name;
            this.speed = speed;
            this.stopwatch = new Stopwatch(this);
        }

        public String getName() {
            return name;
        }

        public double getSpeed() {
            return speed;
        }

        public void start() {
            stopwatch.start();
        }
    }
}

package com.javarush.test.level16.lesson07.task04;

import java.util.ArrayList;
import java.util.List;

/* Обратный отсчет
1. Разберись, что делает программа.
2. Реализуй логику метода printCountdown так, чтобы каждые полсекунды выводился объект из
переменной list в обратном порядке - от переданного индекса до нуля.
Пример: Передан индекс 3
Пример вывода в консоль:
Строка 2
Строка 1
Строка 0
*/

public class Solution {
    public static volatile List<String> list = new ArrayList<String>(5);

    static {
        for (int i = 0; i < 5; i++) {
            list.add("Строка " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Countdown(3));
        t.start();
    }

    public static class Countdown implements Runnable {
        private int countFrom;

        public Countdown(int countFrom) {
            this.countFrom = countFrom;
        }

        public void run() {
            try {
                while (countFrom > 0) {
                    printCountdown();
                }
            } catch (InterruptedException e) {
            }
        }

        public void printCountdown() throws InterruptedException {
            //add your code here - добавь код тут
        }
    }
}
package com.javarush.test.level16.lesson07.task05;

/* Аэропорт
1. Разберись, что делает программа.
2. Исправь метод takingOff(взлет) - сейчас он работает оооочень долго. Взлет должен занимать 100 миллисекунд.
3. Реализуй метод waiting по аналогии с методом takingOff. Время ожидания не должно превышать время взлета.
*/
public class Solution {
    public static volatile Runway RUNWAY = new Runway();   //1 взлетная полоса

    public static void main(String[] args) throws InterruptedException {
        Plane plane1 = new Plane("Самолет #1");
        Plane plane2 = new Plane("Самолет #2");
        Plane plane3 = new Plane("Самолет #3");
    }

    public static class Plane extends Thread {
        public Plane(String name) {
            super(name);
            start();
        }

        public void run() {
            boolean  isAlreadyTakenOff = false;
            while (!isAlreadyTakenOff) {
                if (RUNWAY.getTakingOffPlane() == null) {    //если взлетная полоса свободна
                    RUNWAY.setTakingOffPlane(this);
                    System.out.println(getName() + " взлетает");
                    takingOff();//взлетает
                    System.out.println(getName() + " уже в небе");
                    isAlreadyTakenOff = true;
                    RUNWAY.setTakingOffPlane(null);
                } else if (!this.equals(RUNWAY.getTakingOffPlane())) {  //если взлетная полоса занята самолетом
                    System.out.println(getName() + " ожидает");
                    waiting(); //ожидает
                }
            }
        }
    }

    private static void waiting() {
        //add your code here - добавь код тут
    }

    private static void takingOff() {
        //fix this method - исправь этот метод
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
    }

    public static class Runway { //взлетная полоса
        private Thread t;

        public Thread getTakingOffPlane() {
            return t;
        }

        public void setTakingOffPlane(Thread t) {
            synchronized (this) {
                this.t = t;
            }
        }
    }
}
package com.javarush.test.level16.lesson10.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            try {
                //add your code here - добавьте код тут
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}


package com.javarush.test.level16.lesson10.task02;

/* Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].
Пример для countSeconds=4 : [4 3 2 1 Прервано!]
4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 : [3 2 1 Марш!]
PS: метод sleep выбрасывает InterruptedException.
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
        }
    }
}
package com.javarush.test.level16.lesson10.task03;

/* Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        

    }

    //Add your code below - добавь код ниже
    public static class TestThread{
        
    }
}


package com.javarush.test.level16.lesson10.task04;

/* А без interrupt слабо?
Разберись, как работает программа.
Сделай так, чтобы в методе ourInterruptMethod можно было сделать так, чтобы нить TestThread завершилась сама.
Нельзя использовать метод interrupt.
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {

    }

    public static class TestThread implements Runnable {
        public void run() {
            while(true) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}


package com.javarush.test.level16.lesson10.task05;

import java.util.ArrayList;
import java.util.List;

/* Один для всех, все - для одного
1. Разберись, как работает программа.
1.1. Обрати внимание, что объект Water - один для всех нитей.

2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
3. В методе run исправь значения переменных:
3.1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.
*/

public class Solution {
    public static byte countThreads = 3;
    static List<Thread> threads = new ArrayList<Thread>(countThreads);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        //add your code here - добавь код тут
    }

    private static void initThreadsAndStart() {
        Water water = new Water("water");
        for (int i = 0; i < countThreads; i++) {
            threads.add(new Thread(water, "#" + i));
        }

        for (int i = 0; i < countThreads; i++) {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String commonResource;

        public Water(String commonResource) {
            this.commonResource = commonResource;
        }

        public void run() {
            //fix 2 variables - исправь 2 переменных
            boolean isCurrentThreadInterrupted = false;
            String threadName = "";

            try {
                while (!isCurrentThreadInterrupted) {

                    System.out.println("Объект " + commonResource + ", нить " + threadName);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}


package com.javarush.test.level16.lesson13.home01;

/* Thread.currentThread - всегда возвращает текущую нить
1. В методе printMsg присвой переменной t текущую нить.
2. В методе printMsg после всех действий поставь задержку в 1 миллисекунду.
*/

public class Solution {
    static int count = 5;

    public static void main(String[] args) {
        NameOfDefferentThreads tt = new NameOfDefferentThreads();
        tt.start();
        for (int i = 0; i < count; i++) {
            tt.printMsg();
        }
    }

    public static class NameOfDefferentThreads extends Thread {
        public void run() {
            for (int i = 0; i < count; i++) {
                printMsg();
            }
        }
        public void printMsg() {
            Thread t = null;//присвой переменной t текущую нить
            String name = t.getName();
            System.out.println("name=" + name);
            //add sleep here - добавь sleep тут
        }
    }
}


package com.javarush.test.level16.lesson13.home02;

/* Последовательные выполнения нитей
1. В методе run после всех действий поставь задержку в 10 миллисекунд. Выведи "Нить прервана", если нить будет прервана.
2. Сделай так, чтобы все нити выполнялись последовательно: сначала для нити №1 отсчет с COUNT до 1, потом для нити №2 с COUNT до 1 и т.д.
Пример:
#1: 4
#1: 3
...
#1: 1
#2: 4
...
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            new SleepingThread();
            //напишите тут ваш код
        }
    }

    public static class SleepingThread extends Thread {
        private volatile int countDownIndex = COUNT;
        private static volatile int threadCount = 0;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                if (--countDownIndex == 0) return;
                //add sleep here - добавь sleep тут
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countDownIndex;
        }
    }
}



package com.javarush.test.level16.lesson13.home03;

/* Рекурсивное создание нитей
1. Измени класс GenerateThread так, чтобы он стал нитью.
2. Создай конструктор GenerateThread, который должен:
2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй countCreatedThreads.
2.2. Запустить текущую нить.
2.3. Номер первой нити должен начинается с 1.
3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods. Начни печатать toString.
3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName(). Пример: [8 created]
4. Пока количество созданных нитей меньше Solution.count метод run должен:
4.1. создать новую нить типа GenerateThread.
4.2. Вывести в консоль созданную в пункте 4.1. нить.
5. В итоге должно быть выведено в консоль 15 строк.
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread {
    }
}


package com.javarush.test.level16.lesson13.home08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Кто первый встал - того и тапки
1. Разберись, что делает программа.
1.1. Каждая нить должна читать с консоли слова. Используйте готовый static BufferedReader reader.
1.2. Используй static byte countReadStrings, чтобы посчитать, сколько слов уже считано с консоли всеми нитями.

2. Реализуйте логику метода run:
2.1. Пока нить не прервана (!isInterrupted) читайте с консоли слова и добавляйте их в поле List<String> result.
2.2. Используй countReadStrings для подсчета уже считанных с консоли слов.
*/

public class Solution {
    public static volatile byte countReadStrings;
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //read count of strings
        int count = Integer.parseInt(reader.readLine());

        //init threads
        ReaderThread consolReader1 = new ReaderThread();
        ReaderThread consolReader2 = new ReaderThread();
        ReaderThread consolReader3 = new ReaderThread();

        while (count > countReadStrings) {
        }

        consolReader1.interrupt();
        consolReader2.interrupt();
        consolReader3.interrupt();
        System.out.println("#1:" + consolReader1);
        System.out.println("#2:" + consolReader2);
        System.out.println("#3:" + consolReader3);

        reader.close();
    }

    public static class ReaderThread extends Thread {
        private List<String> result = new ArrayList<String>();

        public ReaderThread() {
            start();
        }

        public void run() {
            //add your code here - добавьте код тут
        }

        @Override
        public String toString() {
            String s = result.toString();
            return s.substring(1, s.length()-1);
        }
    }
}


package com.javarush.test.level16.lesson13.home04;

/* Последовательные выполнения нитей
1. Разберись, что делает программа.
2. Сделай так, чтоб программа сначала выводила результат нити, а когда нить завершится - продолжила метод main.
3. Пример выходных данных:
inside MyThread 0
inside MyThread 1
...
inside MyThread 9
inside main 0
inside main 1
...
inside main 9
*/

public class Solution {
    public static MyThread t = new MyThread();
    static String message = "inside main ";

    public static void main(String a[]) throws Exception {
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(message + i);
            sleep();
        }
    }

    static class MyThread extends Thread {
        String message = "inside MyThread ";

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(message + i);
                Solution.sleep();
            }
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }
}


package com.javarush.test.level16.lesson13.home05;

/* Взаимная блокировка
1. Разберись, как работает программа.
2. Не меняя классы T1 и T2 сделай так, чтобы они завершились, не обязательно успешно.
3. метод sleep не использовать.
*/

public class Solution {
    static Thread t1 = new T1();
    static Thread t2 = new T2();

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            try {
                t2.join();
                System.out.println("T1 finished");
            } catch (InterruptedException e) {
                System.out.println("T1 was interrupted");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            try {
                t1.join();
                System.out.println("T2 finished");
            } catch (InterruptedException e) {
                System.out.println("T2 was interrupted");
            }
        }
    }
}


package com.javarush.test.level16.lesson13.home06;

/* Создание по образцу
Разберись, как работает программа.
По образу и подобию CountDownRunnable создай нить CountUpRunnable, которая выводит значения в нормальном порядке - от 1 до number
*/

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new CountDownRunnable("было");
        new CountUpRunnable("стало");
    }

    //Add your code below - добавьте код ниже
    public static class CountUpRunnable {
        public CountUpRunnable(String name) {
        }
    }

    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;
        private Thread t;

        public CountDownRunnable(String name) {
            t = new Thread(this, name);
            t.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return t.getName() + ": " + countIndexDown;
        }
    }
}


package com.javarush.test.level16.lesson13.home07;

import java.util.ArrayList;
import java.util.List;

/* Поиграем?
Три человека играют в игру. Каждый игрок(Gamer) характеризуется двумя параметрами: фамилией(name) и количеством действий в секунду (rating).
Нужно вывести в консоль ход игры и определить победителя и проигравших.
Итак...
1. Разберись, что делает программа.
1.1. List<String> steps хранит последовательность действий, которое каждый игрок выполняет от 0 до последнего.
1.2. isWinnerFound показывает, найден победитель или нет.
1.3. метод sleep выбрасывает InterruptedException и принимает параметр типа long.
1.4. Игроки играют независимо друг от друга.

2. Реализуйте логику метода run так, чтобы для каждого игрока:
2.1. За 1 секунду через равные интервалы времени выводились в консоль действия, описанные в steps. Количество выведенных действий должно равняться rating.
2.2. Любой текст должен начинаться с фамилии игрока (метод getName()), потом следовать двоеточие, а затем сам текст. Пример: [Ivanov:Начало игры].
2.3. Когда игрок выполнит все действия из steps, то он считается победителем. Выведите [getName() + ":победитель!"].
2.4. Когда найден победитель, то игра останавливается, и остальные игроки считаются побежденными. Выведите для них [getName() + ":проиграл"].
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            //Add your code here - добавь код тут
        }
    }
}

package com.javarush.test.level16.lesson13.home09;

/* Только по-очереди!
1. В классе Solution создать нить public static Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используйте join

Пример:
Входные данные
a
b
c
d
e
f
Выходные данные:
a b c
d e f
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t2.start();
        System.out.println(/*print t1 result here*/);
        System.out.println(/*print t2 result here*/);
    }
    
    public static class Read3Strings extends Thread{
        
        public void run(){
            for (int i = 0; i < 3; i++)
            {
                try
                {
                    reader.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}

package com.javarush.test.level16.lesson13.home10;

import java.io.*;

/* Последовательный вывод файлов
1. Разберись, что делает программа.
2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).
3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
3.2. Метод getFileContent должен возвращать содержимое файла.
3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить последовательный вывод файлов.
4.1. Для этого добавь вызов соответствующего метода.
Ожидаемый вывод:
[все тело первого файла]
[все тело второго файла]
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        System.out.println(f.getFileContent());
    }

    
    public static interface ReadFileInterface{

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
}



package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.ImageReaderFactory;
import com.javarush.test.level16.lesson13.bonus01.common.ImageReader;
import com.javarush.test.level16.lesson13.bonus01.common.ImageTypes;

/* Factory method pattern
1. Внимательно посмотри, какие классы у тебя есть.
2. В отдельных файлах в пакете common создай классы JpgReader, PngReader, BmpReader, которые реализуют интерфейс ImageReader.
3. В отдельном файле в пакете bonus01 создай класс ImageReaderFactory с одним методом.
3.1. Подумай, как он должен называться.
3.2. Подумай, какие модификаторы должны быть у этого метода.
4. Этот метод должен:
4.1. для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG - JpgReader;
4.2. если передан неправильный параметр, то выбросить исключение IllegalArgumentException("Неизвестный тип картинки").
*/

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getReader(ImageTypes.JPG);
    }
}


package com.javarush.test.level16.lesson13.bonus01.common;

public enum ImageTypes {
    BMP,
    JPG,
    PNG;
}


package com.javarush.test.level16.lesson13.bonus01.common;

public interface ImageReader {
}

package com.javarush.test.level16.lesson13.bonus02;

import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution
{
    public static List<Thread> threads = new ArrayList<Thread>(5);
	
}
package com.javarush.test.level16.lesson13.bonus02;

public interface Message {
    void showWarning();
}



package com.javarush.test.level16.lesson13.bonus03;

/* Отдебажим все на свете
Разобраться, что делает програма.
Почитать про UncaughtExceptionHandler - это важно.
Еще раз внимательно посмотреть программу.
Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
Исправить ошибку, т.е. все должно работать. :)

Ожидаемый результат в произвольном порядке:
Нить 1: My exception message
Нить 2: My exception message
*/

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException x) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}

package com.javarush.test.level17.lesson02.task01;

import java.util.ArrayList;
import java.util.List;

/* Заметки
1. Класс Note будет использоваться нитями.
2. Создай public static нить NoteThread (Runnable не является нитью),
которая в методе run 1000 раз (index = 0-999) сделает следующие действия:
2.1. используя метод addNote добавит заметку с именем [getName() + "-Note" + index], например, при index=4
"Thread-0-Note4"
2.2. используя метод removeNote удалит заметку
2.3. в качестве первого параметра в removeNote передай имя нити - метод getName()
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static class Note {

        public static final List<String> notes = new ArrayList<String>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            }
        }
    }
}

package com.javarush.test.level17.lesson02.task02;

import java.util.ArrayList;
import java.util.List;

/* Вместе быстрее? Ща проверим :)
1. Разберись, что и как работает
2. Создай public static нить SortThread, которая в методе run отсортирует статический массив testArray используя метод sort
*/

public class Solution {
    public static int countThreads = 10;
    public static int[] testArray = new int[1000];

    static {
        for (int i = 0; i < Solution.testArray.length; i++) {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        initThreads();
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(countThreads);
        for (int i = 0; i < countThreads; i++) threads.add(new SortThread());
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
    }

}


package com.javarush.test.level17.lesson04.task01;

import java.util.ArrayList;
import java.util.List;

/* Синхронизированные заметки
1. Класс Note будет использоваться нитями. Поэтому сделай так, чтобы обращения к листу notes блокировали мютекс notes, не this
2. Все System.out.println не должны быть заблокированы (синхронизированы), т.е. не должны находиться в блоке synchronized
*/

public class Solution {
    public static class Note {

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            notes.add(index, note);
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note = notes.remove(index);
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }
}

package com.javarush.test.level17.lesson04.task02;

import java.util.ArrayList;
import java.util.List;

/* Синхронизированные заметки 2
Класс Note будет использоваться нитями. Поэтому сделай так, чтобы вcе методы были синхронизированы
*/

public class Solution {
    public static class Note {

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            notes.add(index, note);
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note = notes.remove(index);
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }
}

package com.javarush.test.level17.lesson04.task03;

import java.util.ArrayList;
import java.util.List;

/* Сад-огород
1. Создайте метод public void addFruit(int index, String fruit) - который добавляет параметр fruit в лист fruits на позицию index
2. Создайте метод public void removeFruit(int index) - который удаляет из fruits элемент с индексом index
3. Создайте метод public void addVegetable(int index, String vegetable) - который добавляет параметр vegetable в лист vegetables на позицию index
4. Создайте метод public void removeVegetable(int index) - который удаляет из vegetables элемент с индексом index
5. Класс Garden будет использоваться нитями. Поэтому сделай так, чтобы все методы блокировали мютекс this
6. Реализуй это минимальным количеством кода
*/

public class Solution {
    public static class Garden
    {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();
    }
}


package com.javarush.test.level17.lesson04.task04;

/* Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.
*/

public class Solution {
    public static class OurPresident {

        private static OurPresident president;

        private OurPresident() {
        }

        public static OurPresident getOurPresident() {
            return president;
        }
    }
}


package com.javarush.test.level17.lesson04.task05;

/* МВФ
Singleton паттерн - синхронизация в методе
IMF - это Международный Валютный Фонд
Внутри метода getFund создайте синхронизированный блок
Внутри синхронизированного блока инициализируйте переменную imf так, чтобы метод getFund всегда возвращал один и тот же объект
*/

public class Solution {
    public static class IMF {

        private static IMF imf;

        public static IMF getFund() {
            //add your code here - добавь код тут
            return imf;
        }

        private IMF() {
        }
    }
}


package com.javarush.test.level17.lesson06.task01;

import java.util.ArrayList;
import java.util.List;

/* Заметки для всех
Класс Note будет использоваться нитями.
Поэтому сделай так, чтобы лист notes находился в общей памяти
*/

public class Solution {
    public static class Note {

        public List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            notes.add(index, note);
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note = notes.remove(index);
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }
}

package com.javarush.test.level17.lesson06.task02;

/* Предложения
Не используя synchronized сделайте так, чтобы количество сделанных и принятых предложений было одинаковым.
*/

public class Solution {
    public static int proposal = 0;

    public static void main(String[] args) {
        new MakeProposal().start();
        new AcceptProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (thisProposal < 10) {
                if (thisProposal != proposal) {
                    System.out.println("Принято предложение №" + proposal);
                    thisProposal = proposal;
                }
            }
        }
    }
}

package com.javarush.test.level17.lesson10.home01;

import java.util.*;

/* Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
*/

public class Solution {
    private ArrayList<Long> original = new ArrayList<Long>();
}


package com.javarush.test.level17.lesson10.home03;

import java.util.ArrayList;
import java.util.List;

/* Аптека
Реализуй интерфейс Runnable в классах Apteka и Person.
Все нити должны работать пока не isStopped
Логика для Apteka: drugsController должен сделать закупку случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 300 мс
Логика для Person: drugsController должен сделать продажу случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 100 мс
Расставь synchronized там, где это необходимо
*/

public class Solution {
    public static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka());
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class Apteka{
        
    }

    public static class Person{
        
    }

    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(drugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
package com.javarush.test.level17.lesson10.home03;

import java.util.HashMap;
import java.util.Map;

public class DrugsController {
    public static Map<Drug, Integer> allDrugs = new HashMap<Drug, Integer>();   // <Лекарство, Количество>

    static {
        Drug panadol = new Drug();
        panadol.setName("Панадол");
        allDrugs.put(panadol, 5);

        Drug analgin = new Drug();
        analgin.setName("Анальгин");
        allDrugs.put(analgin, 18);

        Drug placebo = new Drug();
        placebo.setName("Плацебо");
        allDrugs.put(placebo, 1);
    }

    public void sell(Drug drug, int count) {
        String name = Thread.currentThread().getName();
        if (!allDrugs.containsKey(drug)) {
            System.out.println("Нет в наличии");
        }
        Integer currentCount = allDrugs.get(drug);
        if (currentCount < count) {
            System.out.println(String.format("%s хочет %s %d шт. В наличии - %d", name, drug.getName(), count, currentCount));
        } else {
            allDrugs.put(drug, (currentCount - count));
            System.out.println(String.format("%s купил(а) %s %d шт. Осталось - %d", name, drug.getName(), count, (currentCount - count)));
        }
    }

    public void buy(Drug drug, int count) {
        System.out.println("Закупка " + drug.getName() + " " + count);
        if (!allDrugs.containsKey(drug)) {
            allDrugs.put(drug, 0);
        }
        Integer currentCount = allDrugs.get(drug);
        allDrugs.put(drug, (currentCount + count));
    }
}
package com.javarush.test.level17.lesson10.home03;

public class Drug {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
package com.javarush.test.level17.lesson10.home04;

/* Синхронизированные методы
Установить модификатор synchronized только тем методам, которым необходимо.
Объект класса Solution будет использоваться нитями.
*/

public class Solution {
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    private void method0() {
        double i = method3();
    }

    protected void method1(String param1) {
        Solution solution = new Solution();
        solution.method0();
    }

    public void method2(int param1) {
        param1++;
    }

    double method3() {
        double random = Math.random();
        param += 40.7;
        return random + param;
    }

    private void method4() {
        sb.append(1).append(1).append(1).append(1);
    }

    protected void method5(String param2) {
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    public String method6(int param2) {
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    String method7(double param2) {
        return "" + param2;
    }

}


package com.javarush.test.level17.lesson10.home05;

/* Лишняя синхронизация
synchronized существенно замедляет программу, поэтому убери избыточность synchronized внутри методов
*/

public class Solution {
    char[] value;
    int count;

    public Solution append(CharSequence s) {
        synchronized (Solution.class) {
            if (s == null) {
                synchronized (this) {
                    s = "null";
                }
            }

            if (s instanceof String) {
                synchronized (this) {
                    return this.append((String) s);
                }
            }

            if (s instanceof Solution) {
                synchronized (this) {
                    return this.appendThis((Solution) s);
                }
            }
        }
        return this.append(s);
    }

    public synchronized Solution appendThis(Solution s) {
        //do something here....
        return this;
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields =
            {
                    new java.io.ObjectStreamField("value", char[].class),
                    new java.io.ObjectStreamField("count", Integer.TYPE),
                    new java.io.ObjectStreamField("shared", Boolean.TYPE),
            };

    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();
        synchronized (fields) {
            fields.put("value", value);
            fields.put("count", count);
            fields.put("shared", false);
        }
        synchronized (s) {
            s.writeFields();
        }
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        synchronized (new java.io.IOException()) {
            java.io.ObjectInputStream.GetField fields = s.readFields();
            value = (char[]) fields.get("value", null);
            count = fields.get("count", 0);
        }
    }
}


package com.javarush.test.level17.lesson10.home06;

/* Глажка
И снова быт...
Поставьте один synchronized, чтобы diana и igor гладили по-очереди, ведь утюг всего один!
Подсказка: использовать блокировку на уровне класса.
*/

public class Solution {
    public static void main(String[] args) {
        Person diana = new Person("Diana");
        Person igor = new Person("Igor");
    }

    public static class Person extends Thread { //Человек

        public Person(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            Iron iron = takeIron();
            Clothes clothes = takeClothes();
            ironing(iron, clothes);
            returnIron();
        }

        protected Iron takeIron() {
            System.out.println("Taking an Iron");
            return new Iron();
        }

        protected Iron returnIron() {
            System.out.println("Returning the Iron");
            return new Iron();
        }

        protected Clothes takeClothes() {
            return new Clothes("T-shirt");
        }

        protected void ironing(Iron iron, Clothes clothes) {
            System.out.println(getName() + "'s ironing the " + clothes.name);
        }
    }

    public static class Iron {
    } //Утюг

    public static class Clothes {//Одежда
        String name;

        public Clothes(String name) {
            this.name = name;
        }
    }
}


package com.javarush.test.level17.lesson10.home07;

import java.util.HashMap;
import java.util.Map;

/* ApplicationContext
ApplicationContext будет доступен множеству нитей.
Сделать так, чтобы данные не терялись: подумай, какое ключевое слово необходимо поставить и где.
*/

public abstract class ApplicationContext<GenericsBean extends Bean> {
    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    //Map<Name, some class implemented Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public GenericsBean getByName(String name) {
          return container.get(name);
    }

    public GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();
}

package com.javarush.test.level17.lesson10.home07;

public interface Bean {   //это интерфейс-маркер
}

package com.javarush.test.level17.lesson10.home08;

/* Банкомат
Разберись, как работает программа
Во время тестирования лог содержит следующее:
.....
Добавляем 100, на счету 1100
Добавляем 100, на счету 1200
Тратим 1000, на счету 100
Недостаточно денег
.....

Создан баг: При списании денег со счета теряются деньги
Найти и исправить ошибку
*/

public class Bankomat {

    static  BankAccount account = new BankAccount("Amigo");

    public static volatile boolean isStopped;

    public static void main(String[] args) throws InterruptedException {
        addMoney.start();
        new SpendThread();
        new SpendThread();
        new SpendThread();
        Thread.sleep(4000);
        isStopped = true;
    }

    private static Thread addMoney = new Thread() {
        @Override
        public void run() {
            while (!isStopped) {
                account.deposit("1000");            //кладем на счет
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };


    public static class SpendThread extends Thread {
        public SpendThread() {
            start();
        }

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    account.withdraw("100");             //снимаем со счета
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Недостаточно денег");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    ;
}
package com.javarush.test.level17.lesson10.home08;

public class NotEnoughMoneyException extends Exception {
}

package com.javarush.test.level17.lesson10.home08;

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;
    private String owner;

    public BankAccount(String owner) {
        this(BigDecimal.ZERO, owner);
    }

    public BankAccount(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public void deposit(BigDecimal money) {
        BigDecimal newBalance = balance.add(money);
        System.out.println("Добавляем " + money + ", на счету " + newBalance);
        balance = newBalance;
    }

    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException {
        BigDecimal newBalance = balance.subtract(money);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();

        balance = newBalance;
        System.out.println("Тратим " + money + ", на счету " + balance);
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
}



package com.javarush.test.level17.lesson10.home09;

import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        

    }

    public void joinData () throws CorruptedDataException {
		
    }
}

package com.javarush.test.level17.lesson10.home09;

import java.io.IOException;

public class CorruptedDataException extends IOException {
}




package com.javarush.test.level17.lesson10.home10;

/* Посчитаем
1. Сделай так, чтобы результат успел посчитаться для всех элементов массива values НЕ используя Thread.sleep
2. Исправь synchronized блок так, чтобы массив values заполнился значением 1
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (this) {
                    incrementCount();
                    values[getCount()]++;
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            } while (getCount() < 100);
        }
    }
}



package com.javarush.test.level17.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
    }
}


package com.javarush.test.level17.lesson10.bonus01;

import java.util.Date;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay){
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay){
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}

package com.javarush.test.level17.lesson10.bonus01;

public enum Sex {
    MALE,
    FEMALE
}


package com.javarush.test.level17.lesson10.bonus02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
    }
}


package com.javarush.test.level17.lesson10.bonus02;

import java.util.Date;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay){
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay){
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}

package com.javarush.test.level17.lesson10.bonus02;

public enum Sex {
    MALE,
    FEMALE
}




package com.javarush.test.level17.lesson10.bonus03;

/* Ресторан
1.Разберись, что делает программа. Официант почему-то не относит приготовленные блюда назад к столам :(
2.Исправь ошибку.
Подсказка: это одна строчка
*/

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter();
        Thread waiter = new Thread(waiterTarget);
        threads.add(waiter);

        Cook cookTarget = new Cook();
        Thread cook = new Thread(cookTarget);
        threads.add(cook);

        waiter.start();
        cook.start();

        Thread.sleep(2000);
        cookTarget.continueWorking = false;
        Thread.sleep(500);
        waiterTarget.continueWorking = false;
    }
}


package com.javarush.test.level17.lesson10.bonus03;

public class Waiter implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        Manager manager = Manager.getInstance();

        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ
                Dishes dishes = manager.getDishesQueue().poll();
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
            } else {                                         //берем новый заказ
                Table table = manager.getNextTable();
                Order order = table.getOrder();
                System.out.println("Получен заказ от стола №" + order.getTableNumber());
                manager.getOrderQueue().add(order);
            }
            try {
                Thread.sleep(100);  //walking to the next table
            } catch (InterruptedException e) {
            }
        }
    }
}
package com.javarush.test.level17.lesson10.bonus03;

public class Dishes {
    private byte tableNumber;

    public Dishes(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}
package com.javarush.test.level17.lesson10.bonus03;

public class Order {
    private long time;
    private byte tableNumber;

    public Order(byte tableNumber) {
        time = (long) (Math.random() * 200);
        this.tableNumber = tableNumber;
    }

    public long getTime() {
        return time;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}
package com.javarush.test.level17.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Manager {      //singleton
    private static Manager ourInstance = new Manager();

    private final List<Table> restaurantTables = new ArrayList<Table>(10);
    private int currentIndex = 0;

    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<Order>();        // очередь с заказами
    private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<Dishes>();     // очередь с готовыми блюдами

    public synchronized static Manager getInstance() {
        return ourInstance;
    }

    private Manager() {               // создаем 10 столов
        for (int i = 0; i < 10; i++) {
            restaurantTables.add(new Table());
        }
    }

    public synchronized Table getNextTable() {           // официант ходит по кругу от 1 стола к 10
        Table table = restaurantTables.get(currentIndex);
        currentIndex = (currentIndex + 1) % 10;
        return table;
    }

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public Queue<Dishes> getDishesQueue() {
        return dishesQueue;
    }
}
package com.javarush.test.level17.lesson10.bonus03;

public class Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cooking();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cooking() throws InterruptedException {
        Manager manager = Manager.getInstance();
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
        Thread.sleep(order.getTime());     // готовим блюдо
        Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо
        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));
    }
}
package com.javarush.test.level17.lesson10.bonus03;

public class Table {
    private static byte tableNumber;
    private byte number = ++tableNumber;

    public Order getOrder () {
        return new Order(number);
    }
}

package com.javarush.test.level18.lesson03.task01;


/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       
    }
}

package com.javarush.test.level18.lesson03.task02;


/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
		
	}
}


package com.javarush.test.level18.lesson03.task03;


/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
      
    }
}


package com.javarush.test.level18.lesson03.task04;

import java.io.FileInputStream;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}


package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}


package com.javarush.test.level18.lesson05.task01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Исправить ошибки
Исправить функциональность в соответствии с требованиями
Программа должна:
1. переписать все байты одного файла в другой одним куском.
2. закрывать потоки ввода-вывода
Подсказка: 4 ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

        if (inputStream.read() >= 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.reset();
        outputStream.flush();
    }
}

package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/


public class Solution {
    public static void main(String[] args) {
      
    }
}

package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
       
    }
}

package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {

    }
}


package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
		
	}
    public static class DownloadException extends Exception{

    }
}


package com.javarush.test.level18.lesson08.task01;

/* Wrapper (Decorator)
Разберись, что делает программа
Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl
*/

public class Solution {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }

}


package com.javarush.test.level18.lesson08.task02;

import java.io.*;

/* Расширяем AmigoOutputStream
Используя шаблон проектирования Wrapper (Decorator) расширьте функциональность AmigoOutputStream
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу [Вы действительно хотите закрыть поток? Д/Н]
2. Считайте строку
3. Если считанная строка равна [Д], то закрыть поток
4. Если считанная строка не равна [Д], то не закрывать поток
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

}

package com.javarush.test.level18.lesson08.task02;

import java.io.IOException;

public interface AmigoOutputStream {
    public void flush() throws IOException;

    void write(int b) throws IOException;

    void write(byte[] b) throws IOException;

    void write(byte[] b, int off, int len) throws IOException;

    void close() throws IOException;
}



package com.javarush.test.level18.lesson08.task03;

import java.io.FileOutputStream;
import java.io.IOException;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream{

    public static String fileName = "C:/tmp/result.txt";


    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}


package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName)
    {
     
	}
}

package com.javarush.test.level18.lesson08.task04;

public class UnsupportedFileNameException extends Exception {
}



package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/


public class Solution {
    public static void main(String[] args) throws IOException
    {
       
    }
}


package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/


public class Solution {
    public static void main(String[] args) throws IOException
    {
       
    }
}


package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {

    }
}


package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {

    }
}


package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

public class Solution {
    public static void main(String[] args) {
       
    }
}


package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

public class Solution {
    public static void main(String[] args) 
    {
       
    }
}


package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level18.lesson10.home08;

import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}


package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

public class Solution {
    public static void main(String[] args) {
    }
}


package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

public class Solution {
    public static void main(String[] args) {

    }

}

package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}


package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

public class Solution {
    public static void main(String[] args) {

    }
}


package com.javarush.test.level19.lesson03.task01;

/* TableAdapter
Измените класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".
Пример, "[Amigo] : DashboardTable"
*/

public class Solution {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter {

    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}


package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/


public class AdapterFileOutputStream{

}

package com.javarush.test.level19.lesson03.task02;

import java.io.IOException;

public interface AmigoStringWriter {
    public void flush() throws IOException;

    void writeString(String s) throws IOException;

    void close() throws IOException;
}



package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    public static class IncomeDataAdapter {

    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}


package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter {
     
    }
}


package com.javarush.test.level19.lesson03.task04;

import java.util.Date;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;

    public Person(String firstName, String middleName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", lastName, firstName, middleName, birthDate.toString());
    }
}

package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}



package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    public static class DataAdapter{

    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}

package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
Вывести модифицированную строку в консоль.
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
    }
    }
}

package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}

package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}


package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level19.lesson10.home03;

import java.util.ArrayList;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
    }

}

package com.javarush.test.level19.lesson10.home03;

import java.util.Date;

public class Person {
    private String name;
    private Date birthday;

    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }
}


package com.javarush.test.level19.lesson10.home04;

import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args)
    {
      
    }
}

package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {
    }
}


package com.javarush.test.level19.lesson10.home06;

import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    public static void main(String[] args) {

    }
}


package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

public class Solution {
    public static void main(String[] args) {

    }
}

package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

public class Solution {
    public static void main(String[] args) {
    }
}


package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}


package com.javarush.test.level19.lesson10.home10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* Исправить ошибку
Программа содержит всего 1 ошибку. Найди и исправь ее
*/

public class Solution {
    {
        System.out.println("it's Solution class");
    }

    public static void main(String... args) throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream("c:/output.txt");
                InputStream is = Solution.class.getClassLoader().getResourceAsStream("/user/resources/avatar.gif");
        ) {
            ;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }

            if (result instanceof A) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("it's A class");
        }
    }

    class B implements Example {
        {
            System.out.println("it's B class");
        }
    }

    class C extends A {
        {
            System.out.println("it's C class");
        }
    }
}

package com.javarush.test.level19.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        
    }

    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}



package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

public class FileConsoleWriter {

}


package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

public class Solution {
    public static void main(String[] args) {
    }
}


package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }
    }
}


package com.javarush.test.level20.lesson02.task01;

public class Asset {
    public Asset(String name) {
        this.name = name;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }
    }
}


package com.javarush.test.level20.lesson02.task02;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }

}

package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
       ();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
       
    }
}



package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }
    }
}


package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
       
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}


package com.javarush.test.level20.lesson04.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution {
    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }
}

package com.javarush.test.level20.lesson04.task01;

public class Asset {
    public Asset(String name) {
        this.name = name;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


package com.javarush.test.level20.lesson04.task02;

import java.util.ArrayList;
import java.util.List;

/* Как сериализовать JavaRush?
Сделайте так, чтобы сериализация класса JavaRush была возможной
*/
public class Solution {
    public static class JavaRush {
        public List<User> users = new ArrayList<>();
    }
}

package com.javarush.test.level20.lesson04.task02;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }

}


package com.javarush.test.level20.lesson04.task03;

import java.io.*;

/* Как сериализовать Singleton?
Два десериализованных объекта singleton и singleton1 имеют разные ссылки в памяти, а должны иметь одинаковые.
В класс Singleton добавьте один метод (погуглите), чтобы после десериализации ссылки на объекты были равны.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Singleton instance = Singleton.getInstance();

        //Serializing the singleton instance
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.tmp"));
        oos.writeObject(instance);
        oos.close();

        //Recreating the instance by reading the serialized object data store
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.tmp"));
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();

        //Recreating the instance AGAIN by reading the serialized object data store
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("singleton.tmp"));
        Singleton singleton1 = (Singleton) ois2.readObject();
        ois2.close();

        //The singleton behavior have been broken
        System.out.println("Instance reference check : " + singleton.getInstance());
        System.out.println("Instance reference check : " + singleton1.getInstance());
        System.out.println("=========================================================");
        System.out.println("Object reference check : " + singleton);
        System.out.println("Object reference check : " + singleton1);
    }

    public static class Singleton implements Serializable {
        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }
    }
}


package com.javarush.test.level20.lesson04.task04;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }
}


package com.javarush.test.level20.lesson04.task05;

import java.io.Serializable;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {
    public static class Object{
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String{
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}


package com.javarush.test.level20.lesson07.task01;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {

    public static class Apartment {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }
}

package com.javarush.test.level20.lesson07.task02;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* OutputToConsole
Класс OutputToConsole должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console by character.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int i = 8;

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            i = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole(int ii) {
            this.i = ii;
        }

        /**
         * Outputs to the console a static field of Solution class [greeting].
         * Has to use [charAt] method of String class
         */
        public void outputToConsole(int ii) {
            for (int i = 0; i < greeting.length(); i++) {} {
                System.out.write(greeting.charAt(i));
            }
        }
    }
}


package com.javarush.test.level20.lesson07.task03;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeChars(firstName);
            out.writeChars(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = in.readLine();
            lastName = in.readLine();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }
}

package com.javarush.test.level20.lesson07.task04;

import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
    }

    private final String pattern = "dd MMMM yyyy, EEEE";
    private Date currentDate;
    private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}


package com.javarush.test.level20.lesson07.task05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        System.out.println(speed * 1.5);
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}


package com.javarush.test.level20.lesson10.home01;

/* Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
*/
public class Solution {

    public class A {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }
}

package com.javarush.test.level20.lesson10.home02;

import java.io.ObjectInputStream;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {

        return null;
    }

    public class A {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}


package com.javarush.test.level20.lesson10.home03;

import java.io.Serializable;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
    }
}


package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public void Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}

package com.javarush.test.level20.lesson10.home05;

import java.io.PrintStream;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person {
        String firstName;
        String lastName;
        String fullName;
        final String greetingString;
        String country;
        Sex sex;
        PrintStream outputStream;
        Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}


package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
    }
}


package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}

package com.javarush.test.level20.lesson10.home08;

/* Правильный вывод
Расставить обращение к методам суперкласса и модификаторы доступа так, чтобы вывод на экран был следующим:

C class, method2
A class, method2
A class, method1
B class, method1

1. Из одного метода можно вызвать только один метод суперкласса.
2. Из одного метода можно вызвать только один метод класса.
3. Можно менять модификаторы доступа к методам.
*/
public class Solution {
    public static void main(String[] s) {
        A a = new C();
        a.method2();
    }

    public static class A {
        public void method1() {
            System.out.println("A class, method1");
        }

        public void method2() {
            System.out.println("A class, method2");
        }
    }

    public static class B extends A {
        public void method1() {
            System.out.println("B class, method1");
        }

        public void method2() {
            System.out.println("B class, method2");
        }
    }

    public static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2");
        }
    }
}


package com.javarush.test.level20.lesson10.home09;

import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution {
    int node;
    List<Solution> edges = new LinkedList<>();
}


package com.javarush.test.level20.lesson10.bonus01;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        int[] result = null;
        return result;
    }
}

package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        return 0;
    }
}


package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
      
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}



package com.javarush.test.level20.lesson10.bonus04;

import java.util.List;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution {
    public static void main(String[] args) {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
    }

    public String getParent(String value) {
        //have to be implemented
        return null;
    }
}


package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        return new byte[4];
    }

    public static void print(byte[] bytes) {
    }
}



package com.javarush.test.level21.lesson02.task02;

/* Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет,
содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}

package com.javarush.test.level21.lesson02.task03;

/* Все гениальное - просто!
Упростить. Переменные не переименовывать, комментарии не оставлять.
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

}


package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Solution n) {
        return n.first.equals(first) && n.last.equals(last);
    }

    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}


package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}


package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Solution) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }
}

package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}

package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
    }
}

package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }
}

package com.javarush.test.level21.lesson10.task01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* Рефакторинг
Отрефакторите метод writeZipEntriesToFile в соответствии с java7 try-with-resources.
Допускаются только текстовые коментарии.
*/
public class Solution {
    public static void writeZipEntriesToFile(String zipFileName, String outputFileName) {
        Charset charset = StandardCharsets.UTF_8;
        Path outputFilePath = Paths.get(outputFileName);

        BufferedWriter writer = null;
        ZipFile zip = null;
        try {
            zip = new ZipFile(zipFileName);
            writer = Files.newBufferedWriter(outputFilePath, charset);
            String newLine = System.getProperty("line.separator");
            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                // Берем имя файла из архива и записываем его в результирующий файл
                // Get the entry name and write it to the output file
                String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (zip != null) {
                try {
                    zip.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}


package com.javarush.test.level21.lesson10.task02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/* Освобождаем ресурсы
Реализуйте метод finalize, подумайте, что именно в нем должно быть.
Отрефакторите метод getUsers в соответствии с java7 try-with-resources.
Допускаются только текстовые коментарии.
*/
public class Solution {
    private Connection connection;

    public Solution(Connection connection) {
        this.connection = connection;
    }

    public List<User> getUsers() {
        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from USER";

        List<User> result = new LinkedList();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("DISPLAYED_NAME");
                int level = rs.getInt("LEVEL");
                int lesson = rs.getInt("LESSON");

                result.add(new User(id, name, level, lesson));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static class User {
        private int id;
        private String name;
        private int level;
        private int lesson;

        public User(int id, String name, int level, int lesson) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.lesson = lesson;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", lesson=" + lesson +
                    '}';
        }
    }
}

package com.javarush.test.level21.lesson10.task03;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Нюансы Exceptions
Классы семейства Utilizator должны утилизировать ресурсы не влияя на работу программы, т.е. программа должна отрабатывать одинаково с любым из Utilizator-ов.
На данный момент это не выполняется из-за неправильных реализаций утилизаторов. Исправьте реализацию утилизаторов.
Метод main не участвует в тестировании.
UtilizatorUtil не менять.
Стек трейс не выводить.
*/
public class Solution {
    private Utilizator utilizator;

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        Solution solution = new Solution();
        solution.setUtilizator(new Utilizator());

        Solution solution2 = new Solution();
        solution2.setUtilizator(new SpecificUtilizator());

        strings.addAll(solution.readFileContent("FakeFileName.txt"));
        strings.addAll(solution2.readFileContent("FakeFileName2.txt"));
        System.out.println("Count of strings is " + strings.size());
    }

    public List<String> readFileContent(String path) {
        List<String> strings = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(path);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String sCurrentLine;
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                strings.add(sCurrentLine);
            }
        } catch (IOException ignored) {

        } finally {
            utilizator.dispose();
        }
        return strings;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("inside finalize - before throwing");
        utilizator.dispose();   //исключения игнорируются в finalize
        System.out.println("inside finalize - after throwing");
    }

    public static class Utilizator {
        protected final UtilizatorUtil util = new UtilizatorUtil();

        public void dispose() {
            //Utilization IS successful
            util.doNothing();
        }
    }

    public static class SpecificUtilizator extends Utilizator {
        @Override
        public void dispose() {
            util.throwException();
        }
    }

    public static class UtilizatorUtil {
        public void doNothing() {
        }

        public void throwException() {
            throw new RuntimeException("It`s impossible to dispose resources!");
        }

        public void sout(String message) {
            System.out.println(message);
        }
    }
}


Задание 16
Теперь уже точно все.
Добавь вызов метода printWinner в конец метода main.
Запускай и любуйся своей первой компьютерной игрой :)


Задание 15
Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде:
Winner is <NAME>!
Пример:
Winner is Lucky!



Задание 14
Запускаем и любуемся.
У нас каждые полсекунды отображается новый кадр с ситуацией на ипподроме.
Мышкой уменьши размер консоли так, чтобы был виден только один "кадр" и на том же самом месте.
Тогда можно наблюдать забег в живую и даже покомментировать:
- Старт.
- Гомер неожиданно обходит Лаки.
- Слевин вырывается вперед.
- Вперед Лаки!
- 10 баксов на Слевина.
- Похоже Лаки сбросил жокея и расслабился.
- Гомер уверенно вырывается вперед.
- Неожиданно для всех побеждает Гомер. Вот это номер!



Задание 13
Теперь вернемся к методу print класса Horse.
Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
........Sleven                       <- лошадь Слевин
....Lucky                            <- лошадь Лаки
..........Gomer                      <- лошадь Гомер

Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
Количество точек равно distance, округленному до целого числа.



Задание 12
Осталось совсем немного - дописать класс Horse.
Каждый ход у лошади будет вызываться метод move.
Когда у лошади вызывают метод move, лошадь должна пробежать некоторую дистанцию.
Дистанция зависит от скорости лошади (speed). В самом простом варианте, выглядеть этот метод должен примерно так:
distance += speed;

Но, чтобы было интереснее, давай сделаем так, чтобы скорость все время немного менялась.
Для этого умножь speed на случайное число.
Случайное число можно получить с помощью метода Math.random()



Задание 11
С классом Hippodrome почти закончили.
Добавь в конец метода main вызов run().

Подсказка:
run() - это нестатический метод, поэтому вызвать его можно только у объекта.
А где взять объект?

Подсказка 2:
game.run();



Задание 10
Еще нужно написать метод print класса Hippodrome.
В нем тоже все просто: в цикле для каждой лошади вызываем ее метод print.
Ну, и еще выведи после цикла пару пустых строк: System.out.println() - чтобы было красивее.



Задание 9
Теперь вернемся к методам move и print. Начнем с move.
В методе move класса Hippodrome в цикле у каждой лошади мы вызываем метод move.

Да ты прав, его еще нет у класса Horse.
Поэтому в класс Horse надо добавить свой метод move :)
И метод print, кстати тоже.
Если я не говорю ничего насчет параметров метода, значит метод без параметров.
Делай все методы public, если явно не указано обратное.



Задание 8
В методе run сделай цикл от 1 до 100. Это и будет наш забег.
В теле цикла вызываем сначала move, затем print.
Чтобы весь цикл не отработал за долю секунды - добавь в него еще Thread.sleep(200);



Задание 7
Но и это еще не все - надо чтобы лошади бежали.
Добавь в класс Hippodrome методы run, move и print. Без параметров.
Метод move будет управлять движением всех лошадей.
Метод print отрисовывать их на экран.
А метод run - управлять всем этим.



Задание 6
Теперь перейдем к методу main.
Нам нужно создать в нем объект класса Hippodrome и добавить ему несколько лошадей.

Для начала:
Создай статическую переменную game типа Hippodrome.
Должно получиться что-то вроде:
public static Hippodrome game;

В методе main надо:
а) Создать объект типа Hippodrome и сохранить его в переменную game.
б) Создать три объекта "лошадь". Имена придумай сам. Начальные скорость у всех лошадей - 3, дистанция - 0.
в) Добавить созданных лошадей в список лошадей ипподрома (horses). Используйте для этого геттер.



Задание 5
Закончим написание класса "лошадь"
Добавь конструктор с параметрами (name, speed, distance).
Добавь getter'ы и setter'ы для всех полей класса Horse.
Делай все методы public, если явно не указано обратное.


Задание 4
Теперь вернемся к лошадям. У каждой лошади на скачках должны быть известны имя(name) и скорость(speed).
Наши лошади будут бежать просто определенное время (100 секунд/"шагов").
Будем определять победителя, как лошадь, пробежавшая наибольшую дистанции.

Поэтому нам понадобится хранить расстояние(distance), которое лошадь уже пробежала.
Добавь в класс Horse переменные name (String), speed (double), distance(double).



Задание 3
Раз это ипподром, то на нем должны быть лошади.
А, значит наш ипподром должен хранить список всех его лошадей.
Добавь переменную horses типа ArrayList<Horse> в класс Hippodrome.
Добавь getter для этого поля.



Задание 2
Любая программа начинается с выполнения метода main.
Добавь метод main в класс Hippodrome.



Задание 1
Сегодня мы напишем небольшую игру под названием "Ипподром".
Когда я говорю мы - я имею ввиду тебя. Я же буду работать наставником.

Для начала нам понадобятся классы "ипподром" и "лошадь".
Создай классы Hippodrome (ипподром), Horse(лошадь)




package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) {
        return null;
    }

    public static class TooShortStringException {
    }
}


package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) {
        return null;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}



package com.javarush.test.level22.lesson05.home01;

/* Нитиевые строки или строковые нити? Вот в чем вопрос.
1. Метод getPartOfString должен возвращать подстроку между первой и последней табуляцией.
2. На некорректные данные getPartOfString должен бросить исключение:
а) TooShortStringFirstThreadException, если имя трэда FIRST_THREAD_NAME.
б) TooShortStringSecondThreadException, если имя трэда SECOND_THREAD_NAME.
в) RuntimeException в других случаях.
3. Реализуйте логику трех protected методов в ThisUncaughtExceptionHandler используя вызовы соответствующих методов согласно следующему шаблону:
a) 1# : TooShortStringFirstThreadException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
б) java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : TooShortStringSecondThreadException : 2#
в) RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public String getPartOfString(String string, String threadName) {
        return null;
    }
}

package com.javarush.test.level22.lesson05.home01;

public class Task implements Runnable {
    private String initialString;
    private Solution solution;

    public Task(Solution solution, String initialString) {
        this.solution = solution;
        this.initialString = initialString;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String str = this.initialString;
        do {
            System.out.println(name + str);
        } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
    }
}
package com.javarush.test.level22.lesson05.home01;

public class TooShortStringFirstThreadException extends RuntimeException {
}
package com.javarush.test.level22.lesson05.home01;

public class TooShortStringSecondThreadException extends RuntimeException {
}
package com.javarush.test.level22.lesson05.home01;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return null;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return null;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return null;
    }
}

package com.javarush.test.level22.lesson07.task01;

/* Форматирование строки
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Для перевода каретки не используйте \n.
Должен быть вывод:
20 / 7 = 2,86
Exp = 3,33e+00
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), 20.0 / 7.0, 10.0 / 3.0));
        //должен быть вывод
        //20 / 7 = 2,86
        //Exp = 3,33e+00
    }

    public static String getFormattedString() {
        return "20 / 7 = % %Exp = %";
    }
}

package com.javarush.test.level22.lesson07.task02;

/* МНЕ нравится курс JavaRush
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Параметры должны меняться местами.
Должен быть вывод:
МНЕ нравится курс JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }
    public static String getFormattedString() {
        return "";
    }
}


package com.javarush.test.level22.lesson07.task03;

import java.util.Date;

/* Форматирование даты
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Должен быть вывод аналогичный следующему:
31:10:13 15:59:59
*/
public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59 - dd:MM:yy hh:mm:ss
    }

    public static String getFormattedString() {
        return "";
    }
}


package com.javarush.test.level22.lesson09.task01;

import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        return null;
    }
}


package com.javarush.test.level22.lesson09.task03;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        //...
        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
          return null;
    }
}

package com.javarush.test.level22.lesson13.task01;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        return null;
    }
}


package com.javarush.test.level22.lesson13.task02;

import java.io.IOException;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
    }
}

package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        return false;
    }
}

Задание 17
Я тут немножечко подправил код.
Но в целом - отлично.
Запускаем и наслаждаемся тетрисом.
P.S.
Не забудь отрегулировать высоту консоли



Задание 16
Напиши свою реализацию методов left(), right(), up(), down() в классе Figure.
Подумай, что должны делать эти методы?



Задание 15
Напиши реализацию метода step в классе Tetris.
В методе надо переместить фигурку вниз на один шаг.
Если после перемещения положить фигурку на текущее место невозможно, то:
а) поднять ее обратно (up)
б) "приземлить" ее (landed)
в) удалить все "полные линии" в объекте field
г) создать новую фигурку взамен старой.



Задание 14
Напиши реализацию метода removeFullLines в классе Field
Надо
а) удалить все строки из матрицы, которые полностью заполнены (состоят из одних единиц)
б) сместить оставшиеся строки вниз
в) создать новые строки взамен отсутствующих.

ВАЖНО!
matrix[y][x] содержит элемент с координатами (x,y)
matrix[i] содержит i-ю строку
а) Мы можем удалить стоку:
matrix[i] = null

б)Скопировать [ссылку на] строку:
matrix[i+1] = matrix[i];

в)Создать новую строку:
matrix[i] = new int[width];



Задание 13
Теперь приступим к реализации созданных методов.
Напиши реализацию метода print в классе Field
а) Метод должен выводить на экран прямоугольник.
б) Высота прямоугольника равна height, ширина - width
в) Если данная клетка пустая - вывести точку, если не пустая - английский X

Подсказка:
if (matrix[y][x]==0) ...



Задание 12
В тетрисе мы управляем движением фигурки с помощью клавиатуры.
Тут есть 4 действия:
движение влево (кнопка влево)
движение вправо (кнопка влево)
поворот фигурки (цифра 5 на доп.клавиатуре справа)
падение вниз (пробел)

Мы будем обрабатывать ввод с клавиатуры в методе run() класса Tetris.

И тут у меня для тебя две новости: хорошая и плохая
Плохая новость состоит в том, что java не позволяет считать нажатые символы с клавиатуры,
пока пользователь не нажмет enter.
Не очень удобно, правда?

Хорошая новость состоит в том, я написал специальный класс (KeyboardObserver), который позволяет обойти это ограничение.
Так что ты можешь воспользоваться им.

Есть еще и отличная новость.
Ты до сих пор отлично справлялся, поэтому я помогу тебе немного.
Я написал за тебя методы:
а) createRandomFigure в FigureFactory
б) run в Tetris

Изучи их внимательно и переходи дальше.



Задание 11
Теперь создай класс FigureFactory.
С его помощью мы будем создавать фигуры различных форм.
Пока он будет содержать только один статический метод createRandomFigure:
public static Figure createRandomFigure(int x,int y)



Задание 10
Так же нам понадобятся методы для управления фигуркой.
Добавь в класс Figure методы:
left() - для движения фигурки влево.
right() - для движения фигурки вправо.
down() - для движения фигурки вниз.
up() - для движения фигурки вверх.
downMaximum() - падение фигурки в низ до дна.
rotate() - для поворота фигурки вокруг главной диагонали.
boolean isCurrentPositionAvailable() - проверка - может ли фигурка быть помещена в текущую позицию. Для теста захардкодь результат в true.
landed() - вызывается, когда фигурка достигла дна или уперлась в другую фигурку
Все ее занятые клетки теперь должны добавиться в Field.



Задание 9
Если ты обратил внимание, мы пишем программу "сверху вниз".
Сначала решили, какие классы нам нужны. Затем - какие методы.
А потом уже начнем писать код этих методов.
Таким образом мы разбиваем большую задачу на множество маленьких.
Когда код всех методов будет готов, останется только проверить - так ли все работает, как должно быть.
И если надо - внести некоторые изменения.



Задание 8
Теперь создадим костяк класса Figure.
Этот класс будет описывать падающую фигурку.

Нам понадобятся ее координаты и форма.
За координаты будут отвечать две переменные x и y.
За форму - матрица. Двумерный массив 3x3, состоящий из единиц и нулей.
Единицей мы обозначаем что клетка есть, нулем - что она пустая.

Добавь в класс Figure два поля поля: x типа int, y типа int.
Еще добавь двумерный массив: matrix(матрица) типа int[][].
Там же добавь getter'ы для созданных переменных.
Добавь конструктор с тремя параметрами x, y, matrix.



Задание 7
Нам понадобится еще 4 метода в классе Field:
а) print() - объект будет отрисовывать на экран свое текущее состояние;
б) removeFullLines() - будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз;
в) Integer getValue(int x, int y) - возвращает значение которое находится в матрице с координатами x и y;
г) void setValue(int x, int y, int value) - устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y.



Задание 6
Теперь перейдем к классу Field.
Он будет отвечать за хранение данных о текущих занятых и свободных клетках на поле игры.
Добавь в класс Field два поля поля: width (ширина) типа int, height(высота) типа int.
Так же нам понадобится матрица - двумерный массив: matrix(матрица) типа int[][];
Там же добавь getter'ы для созданных переменных.
Добавь конструктор с двумя параметрами width и height. И не забудь про матрицу.

ВАЖНО!
Двумерный массив можно представить как массив массивов или как прямоугольную матрицу.
При этом первой координатой в массиве у нас будет номер строки, а второй - столбца.
Другими словами ячейка с координатами x, y - это matrix[y][x].



Задание 5
Теперь нужно создать объект самого Тетриса.
Добавь в класс Tetris статическую переменную game. (тип - Tetris, видимость - public)

Затем в методе main создай объект типа Тетрис и сохрани его в эту переменную.
Затем добавь вызов метода run.

Должно получиться что-то типа такого:
game = new Tetris();
game.run();



Задание 4
Так же еще нам понадобится пара методов.
Добавь в класс Tetris методы run() и step():

run() будет отвечать за всю игру.
А step() - за один шаг в игре.



Задание 3
Отлично! Теперь добавь в Tetris две переменные: field типа Field  и figure типа Figure.
С их помощью мы будем хранить информацию о текущей фигурке и о состоянии дел на "поле клеток".
Так же добавь getter'ы для созданных переменных.



Задание 2
А еще нам понадобится метод main. Как же без него.
Добавь метод main в класс Tetris



Задание 1
Давай напишем игру Тетрис.
Наш Тетрис будет состоять из двух вещей: поля из клеток и фигурки, которая падает.
Поэтому для начала создай три класса: Field(поле с клетками), Figure(фигура) и сам Tetris.


package com.javarush.test.level23.lesson02.task01;

/* Запретите наследование
Запретите наследование от класса Listener.
*/
public class Solution {

    public static class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }
}

package com.javarush.test.level23.lesson02.task02;

/* Запретите переопределение
Запретите переопределение метода onMouseDown.
*/
public class Solution {

    public static class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }
}

package com.javarush.test.level23.lesson02.task03;

/* Запретите создание экземпляров класса
Запретите создание экземпляров класса Listener.
*/
public class Solution {

    public static class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }
}

package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        return null;
    }
}


package com.javarush.test.level23.lesson04.task02;

/* Inner 2
В классе SuperUser метод getDescription должен учитывать страну и город, т.е. возвращать результат аналогичный следующему:
My name is George. I'm from the USA, Seattle.
Используйте возможности иннер класса.
*/
public class Solution {
    private String country;
    private String city;

    public Solution(String country, String city) {
        this.country = country;
        this.city = city;
    }

    /*т.к. модификатор иннер класса private, то чтобы вызвать метод getDescription из другого внешнего класса,
    нужно обернуть его вызов в какой-то public метод*/
    public String getDescriptionOfUser(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        //доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        public SuperUser(String name) {
            this.name = name;
        }

        //доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        public String getDescription() {
            return String.format("My name is %s.", this.name);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution("the USA", "Seattle");
        //внутри класса Solution (а сейчас мы внутри) к методу getDescription можно обращаться обоими способами
        System.out.println(solution.getTrickyUser("George").getDescription());
        //а из любого другого внешнего класса только так:
        System.out.println(solution.getDescriptionOfUser("George"));
    }
}

package com.javarush.test.level23.lesson04.home01;

/* Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого - обновить поле names.
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }



    class Task {
    }
}

package com.javarush.test.level23.lesson04.home01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DbMock {
    private static final List<Solution.Task> FAKE_TASKS = new ArrayList<>();
    private static final List<String> FAKE_NAMES = new ArrayList<>();

    public static List<Solution.Task> getFakeTasks(Map criteria) {
        return ViewMock.getFakeTasksCriteria().equals(criteria) ? FAKE_TASKS : null;
    }

    public static List<String> getFakeNames(Map criteria) {
        return ViewMock.getFakeNamesCriteria().equals(criteria) ? FAKE_NAMES : null;
    }
}
package com.javarush.test.level23.lesson04.home01;

import java.util.HashMap;
import java.util.Map;

public class ViewMock {
    private static final Map FAKE_TASKS_CRITERIA = new HashMap();
    private static final Map FAKE_NAMES_CRITERIA = new HashMap();

    public static Map getFakeTasksCriteria() {
        return FAKE_TASKS_CRITERIA;
    }

    public static Map getFakeNamesCriteria() {
        return FAKE_NAMES_CRITERIA;
    }
}

package com.javarush.test.level23.lesson06.task01;

/* Как выбрать нужное?
В методе main присвойте объекту Object obj экземпляр класса TEST
Константу TEST и класс TEST менять нельзя.
*/
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj = Solution.TEST;
        System.out.println(obj);
    }
}

package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("Server is not accessible for now.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("Server is not accessible for now.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("User is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("User is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("User is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("User is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }
}

package com.javarush.test.level23.lesson08.task01;

/* Напряги извилины!
Метод printName должен выводить свое собственное имя, т.е. "sout"
Сделайте минимум изменений.
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void sout() {
        new Solution("sout") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("main").sout();
    }
}

package com.javarush.test.level23.lesson08.task02;

/* Повторяем threads
Сделать так, чтобы в методе someActions вызывались только методы класса Solution.
Ожидаемый вывод в методе main:
Amigo: Mmmmm, beef
Amigo: knock knock
Amigo: Zzzzzzz...1 sec
*/
public class Solution {
    public final String name;
    public final String food;
    public final String sound;

    public Solution(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " sec");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                sleep(1000);
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution("Amigo", "beef", "knock").live();
    }
}
package com.javarush.test.level23.lesson08.home01;

import com.javarush.test.level23.lesson08.home01.vo.*;

import java.util.List;

/* Анонимность иногда так приятна!
1. В пакете vo создайте public классы User, Location, Server, Subject, Subscription, которые наследуются от NamedItem
2. В классе Solution для каждого класса создайте свой метод, который возвращает список экземпляров класса.
Например, для класса User это будет - public List<User> getUsers()
Для класса Location это будет - public List<Location> getLocations()
3. Внутри каждого такого метода создайте анонимный класс от AbstractDbSelectExecutor и вызовите его нужный метод.
Подсказка: тело метода должно начинаться так: return new AbstractDbSelectExecutor

4. Пример вывода для User и Location:
Id=5, name='User-5', description=Got by executing 'select * from USER'
Id=1, name='Location-1', description=Got by executing 'select * from LOCATION'

5. Проанализируйте пример вывода и сформируйте правильный query для всех классов.
6. Классы не должны содержать закоментированного кода.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
package com.javarush.test.level23.lesson08.home01;

import com.javarush.test.level23.lesson08.home01.vo.NamedItem;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDbSelectExecutor<T extends NamedItem> {

    public abstract String getQuery();

    /**
     * It's fake method
     *
     * @return a list of 5 fake items
     */
    public List<T> execute() {
        List<T> result = new ArrayList<>();
        //assert the query is not null
        String query = getQuery();
        if (query == null) return result;

        try {
            //generate 5 fake items
            for (int i = 1; i <= 5; i++) {
                T newItem = getNewInstanceOfGenericType();
                newItem.setId(i);
                newItem.setName(newItem.getClass().getSimpleName() + "-" + i);
                newItem.setDescription("Got by executing '" + query + "'");
                result.add(newItem);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    //reflection
    //you have to know that it is possible to create new instance of T (generic type) class by using its default constructor
    private T getNewInstanceOfGenericType() throws InstantiationException, IllegalAccessException {
        return (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
    }
}
package com.javarush.test.level23.lesson08.home01.vo;

public class NamedItem {
    private int id;
    private String name;
    private String description;

    public NamedItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


Задание 18
Отлично!
Запускаем и наслаждаемся змейкой.


Задание 17
Теперь закончим класс Shake
Надо:
а) реализовать метод checkBorders: если голова змеи за границами комнаты - змея умирает (isAlive = false)

Реализовать метод move(int dx, int dy):
б) проверить, не вылезла ли она за границу комнаты (если да, то змея умирает)
в) проверить, не совпадает ли она с уже существующими кусочками змеи (если да, то змея умирает)
г) добавить голову к змее (со стороны головы) и удалить последний кусочек из хвоста.
д) если змея поймала мышь (координаты головы совпадают с координатами мыши), то удалять кусок из хвоста не надо.


Задание 16
Продолжаем работать над методом move()
Для определения, не пересекается ли змея сама с собой, можно сделать очень простую проверку:
содержит ли список sections "новую голову змеи".
Код для этого будет выглядеть примерно так:
if (sections.contains(head))
При этом head должен быть еще не добавлен в список sections, иначе будет всегда true.
Но чтобы этот код работал, надо реализовать методы сравнения объектов (equals & hashCode) в классе SnakeSection.

Задание:
а) реализовать методы  equals &amp; hashCode в классе SnakeSection.

Сигнатура методов:
public boolean equals(Object o)
public int hashCode()

Подсказка:
Используй Alt+Insert в Intellij IDEA
В классе Snake:
б) в методе move(int dx, int dy) создать голову(кусочек змеи) с правильными координатами. Вызвать метод checkBody() и checkBorders()
в) реализовать метод checkBody: если голова змеи пересекается с ее телом (любым из кусочков) - змея умирает (isAlive = false)


Задание 15
Теперь осталось допилить змею.
Вот что я предлагаю насчет движения змеи:
Змея состоит из кусочков. Давай каждый ход просто добавлять один кусочек со стороны головы,
а самый последний - удалять. Тогда получится, что змея ползет.

Добавлять кусочек нужно рядом с текущей головой (кусочком номер 0).
С какой стороны добавлять зависит от direction (UP, DOWN, LEFT, RIGHT).
Подсказка:
а) Как добавить кусочек змеи в начало списка sections?
sections.add(0, new_section);
б) А как удалить последний?
sections.remove(sections.size()-1);

В методе move надо:
а) сделать шаг в текущем направлении (определяется direction)
б) проверить, что если змея уперлась в стену, то умереть (isAlive = false)
в) проверить, что если змея уперлась себя, то умереть (isAlive = false)
г) проверить, если змея встретила мышь - то съесть ее.



Задание 14
Теперь поработаем над методом print().
Надо:
а) вывести на экран прямоугольник из точек размером width x height.
б) тело змеи отметить символом "x"-английское
в) голову змеи нарисовать символом X-английское.
Подсказка:
а) удобно сначала создать матрицу типа int[][] с размером (height x width)
б) затем пройтись по всем объектам и отрисовать их в матрицу.
Например, тело змеи - 1, голова змеи - 2, мышь - 3.



Задание 13
Предлагаю тебе в этот раз написать специальный метод sleep().
Который будет делать паузу в зависимости от длины змеи (количества элементов в sections).
Придумай какой-нибудь хитрый алгоритм. Чтобы на первом уровне пауза была 500 миллисекунд,
а к 10 уровню постепенно уменьшилась до 300.
И ниже 200 не опускалась.



Задание 12
Добавить в метод main:
в) вызов метода createMouse().
Змея-то у нас есть, пусть и мышь будет
г) вызов метода run().
Без него ничего работать не будет. В нем вся основная логика.
Неплохо получилось, но я все-таки внесу пару правок.
Кстати, как насчет написать метод sleep?
Ты уже понял из предыдущих задач, что в методе run нужна пауза.
Но насколько я помню, скорость в змейке должна расти при росте ее длины.
Значит чем длиннее змея, тем выше скорость и меньше пауза.


Задание 11
Теперь логика управления мышью.
С мышью у нас будут происходить две вещи.
Первая - змея съест мышь.
Вторая - появляется новая мышь в случайной точке комнаты.

Надо написать и реализовать метод createMouse() в классе Room.
В этом методе мы просто должны создавать новую мышь со случайными координатами в комнате.
Как получить случайные координаты?
Это ты уже должен был знать. На всякий случай даю подсказку:
int x = (int) (Math.random() * width);

Еще понадобится метод - eatMouse(), на случай, если мышь все-таки кто-то съест :)
Пока сложной логики в этом методе не будет - просто будем вызывать метод createMouse и все.



Задание 10
Займемся методом main.
Для начала надо создать статическую переменную game типа Room. Доступ к переменной должен быть для всех классов.
Затем в методе main:
а) Создать змею - объект Snake
б) Создать комнату - объект типа Room и передать в него ширину, высоту и змею.
в) Установить змее direction равным SnakeDirection.DOWN
Чего еще не хватает? Собственно метода, в котором будет идти вся игровая логика.
И еще нужен метод, который бы отрисовывал все это на экране.
а) создать метод run()
б) создать метод print()



Задание 9
Еще остался самый главный класс - Room.
Что нам нужно для его описания?
Размеры комнаты (width и height) - раз.
Змея - два
Мышь - три.

Надо:
а) создать в классе Room переменные width & height типа int.
б) создать в классе Room переменную snake типа Snake.
в) создать в классе Room переменную mouse типа Snake. Шучу. Типа Mouse, конечно же :)
г) создать для них всех геттеры и сеттеры.
д) создать конструктор. Конструктор должен принимать три параметра: width, height и ... snake!



Задание 8
Настала очередь конструктора класса Snake.
Змея у нас будет поначалу состоять из одного кусочка - головы.
А что для него требуется?
Что необходимо передать в конструктор?
Координаты змеи, конечно же.

Надо:
а) Передать в конструктор координаты головы змеи (x и y)
б) создать в нем первый "кусочек змеи" (голову) и добавить его в коллекцию sections.
в) isAlive выставить в true
г) не забудь в конструкторе инициализировать переменную sections. В null не много-то и добавишь!
д) создать и реализовать метод int getX(). Метод должен вернуть координату Х головы змеи.
е) создать и реализовать метод int getY(). Метод должен вернуть координату Y головы змеи.
ё) еще добавить классу метод move()- он нам пригодится попозже.



Задание 7
"Кусочки змеи" мы описали, теперь займемся самой змеей.
У змеи должен быть список кусочков(SnakeSection) и голова.
Пусть головой будет просто самый первый кусочек (с номером 0).

У змеи также есть направление движения - сторона, куда она движется по умолчанию.
А еще есть состояние - жива змея или мертва.
Игра заканчивается тогда, когда змея мертва.
Надо:
а) Добавить в класс Snake переменную sections типа ArrayList<SnakeSection>.
б) Добавить переменную isAlive логического типа.
в) Добавить переменную direction типа SnakeDirection.
г) Для всех них добавить getter'ы, а для direction еще и setter.
Примечание:
Для булевских переменных геттер принято писать не как getValue(), а как isValue() - это улучшает читабельность кода.



Задание 6
Теперь займемся классом SnakeSection.
Он будет описывать один кусочек змеи.

А у каждого кусочка что есть?
Правильно! Координаты.
Добавь две переменных к классу SnakeSection: x и y типа int.
Добавь для них getter'ы и конструктор с двумя параметрами.



Задание 5
Теперь доделаем SnakeDirection.
а) Переделай его в enum: замени ключевое слово class на enum
б) Добавь 4 значения UP, DOWN, LEFT, RIGHT
Должно получиться примерно так:
public enum  SnakeDirection
{
    UP,
    RIGHT,
    DOWN,
    LEFT
}



Задание 4
Отлично. Я еще добавил KeyboardObserver на будущее.
Пригодится.

Начнем с самого простого - класса Mouse.
Мышь не будет двигаться и у нее будут только координаты и все.
Добавь две переменных к классу Mouse: x и y типа int.
Добавь для них getter'ы и конструктор с двумя параметрами.



Задание 3
Теперь самое интересное - как будет устроена змея.
Что можно сказать о змее:
а) По сути - змея это набор кусочков - клеточек. Но точно известно, что один из них - голова.
б) У змеи есть направление движения.

Так что нам еще понадобятся классы:
SnakeSection - кусочек змеи.
SnakeDirection - класс (enum) будет описывать направление движения змеи.

Создай классы SnakeSection и SnakeDirection



Задание 2
А добавь-ка еще метод main в класс Room.



Задание 1
А теперь напишем игру "змейка".
Для этого нам понадобятся:
а) собственно сама змея (класс Snake)
б) комната, в которой она будет ползать (класс Room)
в) мыши, которых она будет есть (класс Mouse)

Создай классы Snake, Room, Mouse



package com.javarush.test.level24.lesson02.task01;

/* Cloneable
Добавьте java-код, чтобы метод main отработал без исключений.
Удалять что-либо нельзя.
*/
public class Solution {

    public static void main(String[] args) throws CloneNotSupportedException {
        Test1 test1 = new Test1();
        test1.clone();

        Test2 test2 = new Test2();
        test2.clone(new Test2());

        Test3 test3 = new Test3();
        test3.c1one();

        Test4 test4 = new Test4();
        test4.clone();
    }


    public static class Test1 {
        protected Test1 clone() throws CloneNotSupportedException {
            return (Test1)super.clone();
        }
    }

    public static class Test2 extends Test1 {
        public Test2 clone(Test2 test2) throws CloneNotSupportedException {
            return (Test2)test2.clone();
        }
    }

    public static class Test3 {
        protected Object c1one() throws CloneNotSupportedException {
            return new Test3();
        }
    }

    public static class Test4 extends Test3 {
        protected Object c1one() throws CloneNotSupportedException {
            return super.c1one();
        }
    }
}

package com.javarush.test.level24.lesson02.task02;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.server.RemoteObject;
import java.util.EventListener;

/* Так-с...сопоставим
Исправьте ошибки: переместите методы clone в те классы, в которых они должны быть реализованы.
Лишние методы удалите.
*/
public class Solution {
    public static class A implements Serializable {
    }

    public static class B implements Remote {
    }

    public static class C extends ArrayDeque {
    }

    public static class D implements EventListener {
    }

    protected A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }

    protected Thread clone() throws CloneNotSupportedException {
        return (Thread) super.clone();
    }

    protected final B clone() throws CloneNotSupportedException {
        return (B) super.clone();
    }

    protected ArrayDeque clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public C clone() {
        return (C) super.clone();
    }

    protected D clone() throws CloneNotSupportedException {
        return (D) super.clone();
    }

}

package com.javarush.test.level24.lesson02.home01;

/* Создание своего интерфейса-маркера
1. Создайте интерфейс-маркер SelfInterfaceMarker
2. Создайте класс SelfInterfaceMarkerImpl, который реализует SelfInterfaceMarker
3. Добавьте в SelfInterfaceMarkerImpl минимум 2 любых различных public метода (дефолтовый public конструктор должен присутствовать)
4. Создайте исключение UnsupportedInterfaceMarkerException
5. В методе testClass класса Util: если параметр == null, то выбросьте UnsupportedInterfaceMarkerException
*/
public class Solution {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl();
        Util.testClass(obj);
    }

}
package com.javarush.test.level24.lesson02.home01;

public class Util {
/
    //пример того, как можно использовать интерфейс-маркер
    //this method is available only for a SelfInterfaceMarker implementation
    public static void testClass(SelfInterfaceMarker interfaceMarker) throws UnsupportedInterfaceMarkerException {
        for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }
    }

}


package com.javarush.test.level24.lesson04.task01;

import java.math.BigDecimal;

/* Наследование от внутреннего класса
Внутри класса Solution создайте 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуйте их от Apartments и Hall.
*/
public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }
}

package com.javarush.test.level24.lesson04.home01;

import com.javarush.test.level24.lesson04.home01.HasHeight;
import com.javarush.test.level24.lesson04.home01.HasWidth;
import com.javarush.test.level24.lesson04.home01.Point;

/* Рефакторинг
В классе Rectangle:
1. Измените методы getHeight и getWidth, чтобы они возвращали HasHeight и HasWidth соответственно.
2. Для этого внутри методов getHeight и getWidth создайте локальные классы - реализации интерфейсов.
3. Переименуйте getHeight в castToHasHeight, getWidth в castToHasWidth (на имени метода нажмите Shift+F6).
4. Уберите наследование интерфейсов в классе  Rectangle.
Методы интерфейсов не менять.
*/
public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
        System.out.println(getHeight(rectangle));
        System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        //System.out.println(getHeight(rectangle.castToHasHeight()));
        //System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(HasHeight rectangle) {
        return rectangle.getHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.getWidth();
    }


    public static class Rectangle implements HasHeight, HasWidth{
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        public double getHeight() {
            return Math.abs(point1.getY() - point2.getY());
        }

        public double getWidth() {
            return Math.abs(point1.getX() - point2.getX());
        }
    }
}
package com.javarush.test.level24.lesson04.home01;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
package com.javarush.test.level24.lesson04.home01;

public interface HasWidth {
    double getWidth();
}
package com.javarush.test.level24.lesson04.home01;

public interface HasHeight {
    double getHeight();
}


package com.javarush.test.level24.lesson04.home02;

/* Black box
1. Восстановите логику метода someAction для поля solutionAction.
2. Пример вывода смотрите коментарием к методу main.
3. Подсказка: метод someAction анонимного класса поля solutionAction должен вызвать метод сабкласса FirstClass,
если param > 0, иначе вызвать метод сабкласса SecondClass
4. Свои строки создавать нельзя.
5. Классы Action, FirstClass, SecondClass менять нельзя.
*/
public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! Changes can be here
        //!!!!! Изменения могут быть тут

        public void someAction() {
            //!!!!! All changes have to be here
            //!!!!! Все изменения должны быть только тут
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}

package com.javarush.test.level24.lesson04.home02;

public abstract class FirstClass implements Action {     //first implementation

    protected FirstClass() {
        Solution.countActionObjects++;
    }

    public void someAction() {
        System.out.println("class FirstClass, method someAction");
    }

    public abstract Action getDependantAction();
}
package com.javarush.test.level24.lesson04.home02;

public class SecondClass implements Action {   //second implementation
    public static String SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM = "\nSpecific action for anonymous SecondClass, param = ";

    private static String SECOND_CLASS_METHOD_STRING = "class SecondClass, method someAction";

    public SecondClass() {
        Solution.countActionObjects++;
    }
    protected StringBuilder sb = new StringBuilder(SECOND_CLASS_METHOD_STRING);

    public void someAction() {
        System.out.println(sb.toString());
    }
}
package com.javarush.test.level24.lesson04.home02;

public interface Action {
    void someAction();
}



package com.javarush.test.level24.lesson06.home01;

import java.util.List;

/* Реализация интерфейса используя локальный класс
В классе Cat реализуйте логику метода toSayable, которая описана в джавадоке.
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}

package com.javarush.test.level24.lesson06.home01;

/*
обратите внимание, как именно Mouse отличается от Cat
Этот класс - привычный для вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мыша пищит.";
    }
}
package com.javarush.test.level24.lesson06.home01;

public interface Sayable {
    String say();
}
package com.javarush.test.level24.lesson06.home01;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i <= 0, то вывести на экран, что кот спит. Пример, "Васька спит."'
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мыша пищит.
     * Томас говорит мяу!
     * <p/>
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {
        return null;
    }
}package com.javarush.test.level24.lesson06.home01;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает со всеми классами Cat, Mouse. А ведь Mouse отличается от Cat.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Cat("Мурзик"));
        pets.add(new Cat("Васька"));
        pets.add(new Cat("Кошка"));
        pets.add(new Mouse());
        pets.add(new Cat("Томас"));
        return pets;
    }

    public static List<Sayable> convertPetToSayable(List<Pet> pets) {
        List<Sayable> result = new LinkedList<>();
        for (Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toSayable(i));
        }
        return result;
    }
}
package com.javarush.test.level24.lesson06.home01;

public interface Pet {
    public Sayable toSayable(int i);
}






package com.javarush.test.level24.lesson06.home02;

import java.util.List;

/* Как избежать Copy+Paste
В классе Dog реализуйте логику метода toSayable, которая описана в джавадоке.
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}


package com.javarush.test.level24.lesson06.home02;

import java.text.SimpleDateFormat;

public abstract class SuperDog {
    protected String getSuperQuotes() {
        //some logic here
        return " *** ";
    }

    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy EEE");
}
package com.javarush.test.level24.lesson06.home02;

/*
обратите внимание, как именно Mouse отличается от Dog
Этот класс - привычный для вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мыша пищит.";
    }
}
package com.javarush.test.level24.lesson06.home02;

public interface Sayable {
    String say();
}
package com.javarush.test.level24.lesson06.home02;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь другому классу, не интерфейсу :)))
Класс DogPet использует 2 класса - SuperDog и Dog, разберись с getName в классе DogPet
Так намного лучше, чем Copy+Paste!
 */
public class Dog implements Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    /**
     * Если так получилось, что есть готовый класс А (тут SuperDog) с логикой, которую вы хотите использовать.
     * То возможны 3 способа:
     * 1) из класса А скопировать логику себе (это плохо, т.к. поддерживать несколько копий одного и того же кода проблематично)
     * 2) создать экземпляр класса А внутри нашего класса и использовать его, связь has-a (не всегда подходит, т.к. класс А сам по себе)
     * 3) создать внутренний класс, который наследуется от А, использовать его методы вместе с
     * методами и полями нашего класса, т.к. внутренний класс имеет доступ к своему родителю как наследник,
     * а также ко всем полям и методам включая private того класса, в который он вложен.
     * <p/>
     * Итак, разбираемся с п.3:
     * Внутри метода toSayable создайте class DogPet, который наследуется от SuperDog и реализует интерфейс Sayable
     * создайте метод private String getName(), который будет использовать логику двух классов - Dog и SuperDog.
     * Пусть этот метод возвращает имя собаки (класс Dog), которое с обеих сторон выделено getSuperQuotes (класс SuperDog)
     * Пример, " *** Барбос *** "
     * Логика метода say:
     * Если i <= 0, то используя метод getName вывести на экран, что собака спит. Пример, " *** Шарик ***  спит."
     * Иначе вывести фразу: "имя_собаки лает гааав! сегодняшняя_дата". Пример для i=3, " *** Тузик ***  лает гааав! 13-ноя-2013 Ср"
     * Для форматирования даты используйте formatter из класса SuperDog.
     * <p/>
     * <b>Пример вывода:</b>
     *  *** Барбос ***  лает гааааав! 13-ноя-2013 Ср
     *  *** Тузик ***  лает гаав! 13-ноя-2013 Ср
     *  *** Бобик ***  лает гааав! 13-ноя-2013 Ср
     * Мыша пищит.
     *  *** Шарик ***  спит.
     *
     * @param i количество букв 'а' в слове гав
     * @return экземпляр класса DogPet
     */
    public Sayable toSayable(final int i) {
       return null;
    }
}package com.javarush.test.level24.lesson06.home02;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает с классами Dog, Mouse.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Dog("Барбос"));
        pets.add(new Dog("Тузик"));
        pets.add(new Dog("Бобик"));
        pets.add(new Mouse());
        pets.add(new Dog("Шарик"));
        return pets;
    }

    public static List<Sayable> convertPetToSayable(List<Pet> pets) {
        List<Sayable> result = new LinkedList<>();
        for (Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toSayable(i));
        }
        return result;
    }
}
package com.javarush.test.level24.lesson06.home02;

public interface Pet {
    public Sayable toSayable(int i);
}



package com.javarush.test.level24.lesson06.home03;

/* Интернет-магазин продажи джинсов
1.Внутри файла Solution.java, но НЕ внутри класса Solution создайте 2 интерфейса:
1.1) Item с методами int getId(), double getPrice(), String getTM()
1.2) Jeans extends Item с методами int getLength() и int getSize()
2. В классе Util в методе getAllJeans добавьте пропущенную часть java-кода:
2.1) разберитесь в том, что уже есть в методе getAllJeans класса Util
2.2) создайте абстрактный class AbstractJeans от интерфейса Jeans с одним абстрактным методом, реализуйте остальные методы
2.3) создайте классы Levis и Denim от AbstractJeans, реализуйте оставшийся метод
2.4) в классе AbstractJeans реализуйте метод toString() используя  Alt+Insert -> toString()
2.5) метод toString класса AbstractJeans должен начинаться с имени сабкласса, например, Levis{id=1, length=34, size=6, price=150.0}
*/
public class Solution {

    public static List<Jeans> allJeans = Util.getAllJeans();

    public static void main(String[] args) {
        for (Jeans jeans : allJeans) {
            System.out.println(jeans);
        }
    }

}
package com.javarush.test.level24.lesson06.home03;

import java.util.Collection;
import java.util.LinkedList;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        //add your code here

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company ) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else
                if (Company.Denim == company) {
                    jeans = new Denim(id, length, size, price);
                } else {
                    jeans = new AbstractJeans(id, length, size, price) {
                        public String getTM() {
                            return company.fullName;
                        }
                    };
                }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis ("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;
        Company(String name) {
            this.fullName = name;
        }
    }
}


package com.javarush.test.level24.lesson09.task01;

/* Вспомним наследование
Исправить наследование во всех классах, чтобы вывод метода main был CCBAYS
*/
public class Solution {
    private class A {
        protected String value = "A";

        public A() {
            System.out.print(value);
        }
    }

    private A a = new A() {
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
            value = "Y";
            if (super.getClass().getName().contains(".Solution$")) {
                System.out.print(value);
            }
        }
    };

    public Solution() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Solution();
    }
}

interface JustAnInterface {
    public static final B B = new B();

    class B {
        public B() {
            System.out.print("B");
        }
    }
}

class C {
    public C() {
        System.out.print("C");
        B localB = B;
    }
}



package com.javarush.test.level24.lesson09.task02;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Знания - сила!
1. В методе sort написать компаратор для Stock:
1.1. Первичная сортировка по name в алфавитном порядке
1.2. Вторичная сортировка по дате без учета часов, минут, секунд (сверху самые новые), потом по прибыли от положительных к отрицательным
... open 125,64 and last 126,74 - тут прибыль = 126,74-125,64
... open 125,64 and last 123,43 - тут прибыль = 123,43-125,64
2. Разобраться с *Format-ами и исправить IllegalArgumentException. Подсказка - это одна строчка.
Пример вывода:
Fake Apple Inc.   AAPL | 17-11-2025 open 125,64 and last 123,43
Fake Oracle Corporation   ORCL | 21-08-1989 closed 0,15
*/
public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        Collections.sort(list, new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                return 0;
            }
        });
    }

    public static class Stock extends HashMap {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}


package com.javarush.test.level24.lesson09.home01;

import java.util.LinkedList;
import java.util.List;

/* Рефакторинг
Сделайте так, чтобы метод getIterator возвращал анонимный класс.
Перенесите логику LocalIterator в анонимный класс.
Меняйте только тело метода getIterator.
*/
public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {
        class LocalIterator implements Iterator {
            public LocalIterator() {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            public Iterator next() {
                return new LocalIterator();
            }
        }
        return new LocalIterator();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
package com.javarush.test.level24.lesson09.home01;

public interface Iterator {
    Iterator next();
}


Задание 20
Наслаждаемся игрой


Задание 19
Осталось совсем чуть-чуть

Реализовать метод checkBricksBump
В этом методе надо проверить - не столкнулся ли шарик с каким-нибудь из "кирпичей"
Для проверки столкновения используй метод isIntersec
Если шарик все-таки попал в кирпич, то
а) шарик отлетает в случайном направлении (0..360 градусов)
double angel = Math.random() * 360;
ball.setDirection(angel);
б) кирпич умирает - надо удалить его из списка всех кирпичей

Реализовать метод checkStandBump
В этом методе надо проверить - не ударился ли шарик о подставку
Для проверки столкновения используй метод isIntersec
Если шарик все-таки ударился о подставку, то:
шарик отлетает в случайным направлении строго вверх (80..100 градусов)
double angel = 80 + Math.random()*20;
ball.setDirection(angel);

Реализовать метод checkEndGame
Если координата y шарика больше чем высота поля игры (height), значит шарик улетел вниз за границу экрана
В этом случае надо переменную isGameOver установить в true


Задание 18
Теперь вернемся к классу Arcanoid
Реализуй методы:
а) move()
В этом методе нужно двигать все движимые объекты (stand, ball)
б) draw(Canvas canvas)
В этом методе надо вызвать метод draw всех существующих объектов, которые его имеют.


Задание 17
Но и это еще не все
Еще нужны методы:
а) move  - см. move в BaseObject
Движение доски осуществляется горизонтально, поэтому мы меняем только координату х.
Подумай, как координата х зависит от направления (direction) и скорости (speed). Реализуй зависимость.
б) draw  - см. draw в BaseObject
Его кодом я займусь сам.
в) moveLeft() - задает постоянное движение "подставки" влево
Просто присвой правильное значение переменной direction и все.
г) moveRight() - задает постоянное движение "подставки" вправо
Просто присвой правильное значение переменной direction и все.


Задание 16
И наконец "подставка"!
Ей понадобятся такие переменные
а) speed (скорость шарика) типа double
б) direction (направление движения по оси x: 1 - вправо, -1 - влево) типа double
в) создай для них геттеры


А еще с тебя конструктор, примерно вот такой:
public Stand(double x, double y)
{
    super(x,y,3);
    speed = 1;
    direction = 0;
}


Задание 15
Не поверишь, но и это еще не все.

Во-первых нужен метод setDirection
Который не только устанавливает значение переменной direction,
но и вычисляет новые значения переменных x & y
Код должен выглядеть примерно так:
this.direction = direction;
double angel = Math.toRadians(direction);
dx = Math.cos(angel) * speed;
dy = -Math.sin(angel) * speed;

Во-вторых шарик может удариться о стенку.
При этом он должен от нее отскочить.
Для этого нам понадобится еще один метод:
public void checkRebound(int minx, int maxx, int miny, int maxy)
Создай его, кодом я займусь сам



Задание 14
Чего-то не хватает:

Во-первых надо переопределить метод move(), который наследуется от BaseObject
а) объявить такой же метод как и в BaseObject, только без ключевого слова abstract
б) написать его реализацию
x должен увеличиваться на dx каждый ход
y должен увеличиваться на dy каждый ход
если шарик "заморожен", то x и y меняться не должны

Во-вторых надо переопределить метод draw(Canvas canvas)
а) объявить такой же метод как и в BaseObject, только без ключевого слова abstract
б) написать его реализацию. Выглядеть она должна примерно так:
canvas.setPoint(x, y, 'O');

В третьих надо реализовать метод start()
Именно его вызов "размораживает" шарик.
Что для этого надо сделать - это ты уже сам реши.


Задание 13
Класс Ball уже посложнее - шарик же двигается.
Нам понадобятся переменные
а) speed (скорость шарика) типа double
б) direction (направление движения в градусах: от 0 до 360) типа double
в) dx (расстояние по x, которое проходит шарик за один шаг. вычисляется на основе speed и direction) типа double.
г) dy (расстояние по y, которое проходит шарик за один шаг. вычисляется на основе speed и direction) типа double.
д) isFrozen ("истина" если шарик "заморожен" - не двигается) типа boolean
е) добавь геттеры для всех переменных этого класса

А еще сделай-ка конструктор:
а) в конструктор передаются x,y, speed, direction
б) радиус (для родительского класса) всегда равен 1
в) не забудь установить isFrozen в true - в начале игры шарик никуда не летит.


Задание 12
Теперь напишем класс Brick
Во-первых займемся конструктором и в нем точно зададим радиус всех "кирпичей".
Путь он выглядит так:
public Brick(double x, double y)
{
        super(x,y,3);
}

Еще нам нужно переопределить два метода move() и draw(Canvas canvas)
Метод move() не делает ничего (не содержит кода), т.к. кирпич никуда не двигается.

Напиши еще метод draw(Canvas canvas).
Его кодом я займусь сам.



Задание 11
Еще Canvas понадобится два метода, напиши их.
а) метод clear()
Этот метод будет очищать матрицу, чтобы на ней снова можно было рисовать.
Например заменить все символы матрицы на пробелы.

б) метод print()
Этот метод отрисовывает матрицу на экран.
Тут уже ты должен сам разобраться: вывести набор символов не так уж и сложно.
Не забудь добавить пару пустых строк в конце, чтобы матрицы выведенные в разное время не слипались.



Задание 10
Что мы будем делать с Canvas?
Мы будем рисовать на нем (в его матрице).
Поэтому нам понадобятся два метода
public void setPoint(double x, double y, char c)
public void drawMatrix(double x, double y, int[][] matrix, char c)

Первый метод - setPoint будет "ставить точку в координатах x,y цветом c".
В методе надо:
а) округлить x и y до целых чисел
б) занести в matrix[y][x] значение с
в) ничего не делать, если x<0 или y<0 или y>matrix.length или x>matrix[0].length

Второй метод - drawMatrix копирует переданную ему картинку (матрицу) в матрицу Canvas.
И не просто копирует, а начиная с координат x, y
В методе надо:
а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки
б) если значение ячейки matrix[i][j] не равно 0, то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:
 setPoint(x+j, y+i, c)



Задание 9
Теперь займемся классом Canvas.
Он у нас будет содержать матрицу(двумерный массив), куда мы будем "рисовать".
У матрицы есть ширина и высота.
А еще будем в ней хранить не числа (int), а символы (char).
Надо:
а) Добавить в класс две переменные width и height
б) Добавить в класс переменную matrix (char[][])
в) Добавить конструктор с width и height
г) Добавь геттеры для всех переменных класса
Я тут немного изменил класс BaseObject. Пройдись по классам наследникам.



Задание 8
Но и это еще не все.
Классу BaseObject нужны еще методы.
Пока это будут пустые методы draw() и move().
Классы-наследники должны будут переопределить их у себя и реализовать необходимую функциональность.
Объяви эти методы, но сделай их абстрактными.
Также сделай абстрактным сам класс BaseObject.

А еще нам нужно будет определять попал шарик в кирпич или в подставку.
Это будем делать так:
В этом же классе, создадим специальный метод: public boolean isIntersec(BaseObject o)
Он будет определять - "пересеклись" объекты или нет. Если пересеклись - возвращать true, если нет - false.

Т.к. объекты мы условно считаем кругами, то предлагаю такую формулу взаимодействия
Если центр круга одного объекта попал в круг другого, то будем считать, что они столкнулись.
Или еще проще:
дистанция_между_объектами < max (радиус_первого_объекта, радиус_второго_объекта)



Задание 7
Теперь перейдем к классу BaseObject.
Я хочу сделать несколько предложений.

Во-первых для простоты считать все объекты у нас будут круглыми.
Нет, отрисовывать их мы будем фигурными, как и раньше.
А вот при расчетах из взаимодействия исходить из того, что они круглые.
Так - гораздо проще.

Во-вторых. Пусть координаты объектов и радиус будут вещественными числами.
Это придаст плавность движениям и точность всем вычислениям.
А при отрисовке мы будем их округлять

Надо:
а) Добавь в класс BaseObject переменные x (double), y (double), radius (double)
б) Добавить геттеры и сеттеры
в) Добавь конструктор BaseObject(double x, double y, double radius)
г) Надо пройтись по все классам-наследникам и поправить у них конструкторы
Если вы пользуйтесь Intellij IDEA - Alt+Insert вам в помощь



Задание 6
У нас будут "кирпичи", "шарик" и "подставка" и у них будет много общего.
Они будут перемещаться по полю и отрисовываться.
Значит у них у всех будут координаты и размер.
А еще методы move() - для перемещения и draw() для отрисовки.

Есть интересное предложение: давай введем один базовый класс для все объектов.
Пусть это будет класс BaseObject.
А классы Ball, Stand, Brick от него наследуются.
Создай класс BaseObject и добавь его родителем к классам  Ball, Stand, Brick

Еще нам понадобится класс Canvas
Он будет ответственным за "отрисовку" объектов.
С помощью его они будут отрисовывать себя.
Вернее даже на нем, но детали я сообщу позднее.
Создай и этот класс.



Задание 5
Чего еще не хватает классу Arcanoid?
Ну во-первых ему нужен метод run(), в котором будет описана основная логика программы
Еще нужен метод move() - который будет двигать на один шаг все объекты требующие движения.
Создай методы run() и move().

Еще нам понадобится статическая переменная game типа Arcanoid, которая будет хранить ссылку
на созданный экземпляр класса Arcanoid.
Выглядеть это должно примерно так:
public static Arcanoid game;



Задание 4
Также классу Arcanoid нужно будет хранить ссылку на шарик (Ball) и "подставку" Stand.
И список "кирпичей"
Надо:
а) создать в классе Arcanoid две переменных ball типа Ball и stand типа Stand
б) добавить переменную bricks типа ArrayList<Brick>
в) добавь для них геттеры и сеттеры



Задание 3
Главному классу (Arcanoid) нужно будет хранить информацию о размерах поля, где будут происходить все действия.
Поэтому:
а) добавь ему две переменных width (ширина) типа int и height(высота) типа int
б) добавь их в конструктор класса
г) сделай для них геттеры и сеттеры



Задание 2
Добавь в класс Arcanoid метод main.



Задание 1
Давай сегодня напишем игру Арканоид.
В оригинале это выглядит примерно так http://www.youtube.com/watch?v=Th-Z6QQ5AOQ
Для начала мы напишем упрощенную версию этой игры.
У нас будут кубики, шарик и летающая "подставка", которая не дает шарику упасть.

Поэтому нам понадобятся классы:
а) Arcanoid - класс в котором происходят основные действия
б) Ball - шарик
в) Brick - "кирпичи", которые мы сбиваем шариком
г) Stand - летающая подставка

Создай их.


package com.javarush.test.level25.lesson02.task01;

/* Новые возможности!
Используя возможности enum-а реализуйте метод getLetterPosition, который должен возвращать позицию буквы (A - 1).
Не должно быть закоментированного кода.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Alphabet.G.getLetterPosition());
    }

    public enum Alphabet {
        A, B, C, D, E,
        F, G, H, I, J,
        K, L, M, N, O,
        P, Q, R, S, T,
        U, V, W, X, Y, Z;

        int getLetterPosition() {
            return -1;
        }
    }
}


package com.javarush.test.level25.lesson02.task02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}


package com.javarush.test.level25.lesson02.home01;

/* Свой enum
Реализуйте интерфейс Columnable у Column, описание методов смотрите в джавадоках.
Реализуйте логику метода Column.getVisibleColumns.
Создавать дополнительные поля нельзя.
Метод main не участвует в тестировании.
*/
public class Solution {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */
    public static void main(String[] args) {

        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("--------------------");
        Column.AccountNumber.hide();

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
    }
}

package com.javarush.test.level25.lesson02.home01;

public interface Columnable {

    /**
     * @return полное имя колонки
     */
    String getColumnName();

    /**
     * Возвращает true, если колонка видимая, иначе false
     */
    boolean isShown();

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */
    void hide();

    /**
     * Возвращает порядок константы в энуме.
     *
     * @return порядок константы в энуме
     */
    int ordinal();
}
package com.javarush.test.level25.lesson02.home01;

import java.util.LinkedList;
import java.util.List;

public enum Column {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();

        return result;
    }
}


package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
    }
}


package com.javarush.test.level25.lesson05.task02;

/* Без дураков
1. Создай private class MyUncaughtExceptionHandler, который на перехват исключения должен подождать половину секунды,
а затем вывести на экран secretKey, имя трэда и сообщение возникшего исключения.
Используй String.format(...). Пример:
super secret key, Thread-0, it's an example
2. Разберитесь в последовательности выполняемого кода и обеспечьте логирование возникновения исключения в п.1.
3. Метод main в тестировании не участвует.
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

package com.javarush.test.level25.lesson05.home01;

/* Мониторинг состояния нити
В отдельном классе создать нить LoggingStateThread,
которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        target.start();  //NEW
        Thread.sleep(100); //RUNNABLE
        target.join(100);
        Thread.sleep(400);
        target.interrupted(); //TERMINATED
        Thread.sleep(500);
    }
}

package com.javarush.test.level25.lesson07.task01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* Работать в поте лица!
Реализуйте логику метода interrupt, который должен прерывать трэд предварительно закрыв используемые ресурсы
Используйте метод super-класса в блоке finally
*/
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        //implement logic here
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {}
    }
}

package com.javarush.test.level25.lesson07.home01;

/* Не валять дурака
Восстановите логику класса TaskManipulator.
*/
public class Solution
{
    /*
     Output:
     first
     first
     second
     second
     second
     third
     fifth
     */
    public static void main(String[] args) throws InterruptedException {
        CustomThreadManipulator manipulator = new TaskManipulator();

        manipulator.start("first");
        Thread.sleep(150);
        manipulator.stop();

        manipulator.start("second");
        Thread.sleep(250);
        manipulator.stop();

        manipulator.start("third");
        Thread.sleep(50);
        manipulator.stop();

        manipulator.start("forth");
        manipulator.stop();

        manipulator.start("fifth");
        Thread.sleep(1);
        manipulator.stop();
    }
}
package com.javarush.test.level25.lesson07.home01;

public interface CustomThreadManipulator {
    public void start(String threadName);
    public void stop();
}
package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable {
    @Override
    public void run() {
    }
}


package com.javarush.test.level25.lesson07.home02;

import java.util.concurrent.*;

/* Все не так легко, как кажется
1. Почитать в инете про Socket, ThreadPoolExecutor, RunnableFuture, Callable
2. Реализуйте логику метода cancel в классе SocketTask
3. Реализуйте логику метода cancel для локального класса внутри метода newTask в классе SocketTask
*/
public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }
}
package com.javarush.test.level25.lesson07.home02;

import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        //close all resources here
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                return false;
            }
        };
    }
}
package com.javarush.test.level25.lesson07.home02;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface CancellableTask<T> extends Callable<T> {
    void cancel();

    RunnableFuture<T> newTask();
}

package com.javarush.test.level25.lesson09.task01;

/* Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны одним из вариантов:
1. Если это Error, то вывести в консоль "Нельзя дальше работать"
2. Если это Exception, то вывести в консоль "Надо обработать"
3. Если это Throwable, то вывести в консоль "ХЗ"
Реализуйте эту логику.
*/
public class Solution extends Thread {
    public Solution() {
    }
}

package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = null;    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }
}
package com.javarush.test.level25.lesson09.task03;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
    }
}


package com.javarush.test.level25.lesson11.task01;

import java.util.Random;

/* Обеспечение отсутствия прерывания важной операции
Просмотрите метод moveMoney
Если RANDOM.nextInt(5000) больше порогового значения THRESHOLD_VALUE,
то обеспечьте переуступку кванта времени (переход хода для текущей нити)
Добавьте этот код в единственное допустимое место.
*/
public class Solution {
    private static final double THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();

    public synchronized void moveMoney(Account from, Account to, int amount) {
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
    }

    private class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}
package com.javarush.test.level25.lesson11.task02;

/* Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечьте переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            System.out.println("end-" + index);
        }
    }
}


Задание 19
Поставь width & height побольше и можно играть!
Наслаждаемся игрой :)



Задание 18
Надо закончить метод draw()
Поступим по аналогии с методом move - сегодня я напишу его сам.



Задание 17
И еще немного:

Напиши метод createUfo()
Если список НЛО пуст - создай один корабль в центре сверху.

Напиши метод checkBombs()
Надо проверить - не пересеклись между собой какая-нибудь бомба и корабль.
Если пересеклись - корабль и бомба умирают  - die()
Если бомба упала за границу экрана y > height бомба тоже умирает.

Напиши метод checkRockets()
Надо проверить - не пересеклись между собой какая-нибудь ракета и НЛО
Если пересеклись - ракета и нло умирают  - die()
Если ракета улетела за границу экрана y < 0, ракета тоже умирает.

Напиши метод removeDead()
В это методе удали из списков ufos, rockets, bombs все мертвые объекты (isAlive() == false)



Задание 16
Надо еще закончить класс Space

Напиши метод getAllItems
Метод должен возвращать один общий список всех объектов типа BaseObject

Напиши метод moveAllItems
Метод должен двигать все объекты по одному разу.
Надо:
а) получить список всех объектов типа BaseObject
б) вызвать у каждого из них метод move()



Задание 15
Теперь напиши класс Ufo.
Он чуть сложнее класса Bomb и проще SpaceShip.
Тебе понадобятся методы draw(), move(), fire()

Метод  draw() сделай по аналогии с SpaceShip.
И добавь матрицу, по аналогии с SpaceShip.

Метод move() надо сделать так:
а) корабль перемещается по случайной траектории
Подсказка:
          double dx = Math.random() * 2 - 1;  //-1..1
          double dy = Math.random() * 2 - 1;  //-1..1
б) корабль не опускается в нижнюю половину экрана
y <= height/2
в) Один раз за 10 ходов корабль должен стрелять - вызывать метод fire

Метод fire()
Корабль сбрасывает одну бомбу по середине.
Сделать аналогично классу SpaceShip

Также не забудь о конструкторе. Типы параметров double, а радиус ufo будет равен 3.


Задание 14
Теперь перейдем к методам draw, move
В методе move() надо:
а) увеличить x на dx
б) проверить, не вылез ли корабль за границы космоса [0, Space.game.getWidth()]
Учти, что ширина корабля равна двум его радиусам.

Метод draw я напишу сам - просто объяви пустой метод.

Еще нам понадобится метод fire(), ведь корабль умеет стрелять.
Этот метод вызывается, когда надо произвести выстрел.
В этом методе надо
а) создать две ракеты
б) установить им координаты левого края корабля и правого края корабля (пушки корабля находятся по краям)
в) добавить эти ракеты в список ракет объекта game.

Его можно получить так:
Space.game.getRockets()



Задание 13
Теперь займемся кораблем.
Для сложности сделаем так: если пользователь нажал кнопку влево, то корабль начинает все время двигаться влево.
Если нажал кнопку вправо - все время в право до упора.
Поэтому заведем специальную переменную dx, которая будет хранить направление движения корабля.
если dx = 1, корабль каждый ход идет на 1 вправо
если dx = -1, корабль каждый ход идет на 1 влево
Надо:
а) добавь в класс SpaceShip переменную dx (double, по умолчанию равна 0)
б) метод moveLeft(), устанавливает dx равной -1
в) метод moveRight(), устанавливает dx равной 1
г) добавь конструктор, можно такой:
Радиус корабля будет равен 3. Корабль большой - это вам не ракета и не бомба.
public SpaceShip(int x, int y)
{
    super(x, y, 3);
}



Задание 12
Теперь напишем класс Rocket.
Практически совпадает с классом Bomb.
Только
а) Ракета летит вверх (т.е. y уменьшается на 1)
б) Рисуем не букву "B", а букву "R"



Задание 11
Теперь напишем класс Bomb. Тут все просто.
Bomb унаследован от BaseObject.
Надо:
а) написать конструктор
Конструктор Bomb должен выглядеть примерно так:
public Bomb(double x, double y)
{
    super(x, y, 1);
}
x и y переданные в конструктор Bomb мы передаем дальше в конструктор BaseObject с помощью super
Где так же указываем радиус "бомбы" равный 1.

б) написать метод move()
тут все просто - бомба падает вниз  - просто увеличиваем y на 1

в) метод draw(Canvas canvas)
тут тоже не очень сложная логика
Давай просто ставить точку с координатами (x,y) и "цветом" c
canvas.setPoint(x,y,'B');

г) Создай в классе Space нашу игру public static Space game;


Задание 10
Еще Canvas понадобится два метода, напиши их.
а) метод clear()
Этот метод будет очищать матрицу, чтобы на ней снова можно было рисовать.
Например заменить все символы матрицы на пробелы.

б) метод print()
Этот метод отрисовывает матрицу на экран.
Тут уже ты должен сам разобраться: вывести набор символов не так уж и сложно.
Не забудь добавить пару пустых строк в конце, чтобы матрицы выведенные в разное время не слипались.



Задание 9
Что мы будем делать с Canvas?
Мы будем рисовать на нем (в его матрице).
Поэтому нам понадобятся два метода
public void setPoint(double x, double y, char c)
public void drawMatrix(double x, double y, int[][] matrix, char c)

Первый метод - setPoint будет "ставить точку в координатах x,y цветом c".
В методе надо:
а) округлить x и y до целых чисел
б) занести в matrix[y][x] значение с
в) ничего не делать, если x<0 или y<0 или y>matrix.length или x>matrix[0].length

Второй метод - drawMatrix копирует переданную ему картинку (матрицу) в матрицу Canvas.
И не просто копирует, а начиная с координат x, y
В методе надо:
а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки
б) если значение ячейки matrix[i][j] не равно 0, то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:
 setPoint(x+j, y+i, c)



Задание 8
Теперь займемся классом Canvas.
Он у нас будет содержать матрицу, куда мы будем рисовать.
У матрицы есть ширина и высота.
А еще будем в ней хранить не числа(int), а символы (char).
Надо:
а) Добавить в класс две переменные width и height
б) Добавить в класс переменную matrix (char[][])
в) Добавь геттеры для них
г) В конструкторе проинициализируй матрицу



Задание 7
Но и это еще не все.
Классу BaseObject нужны еще методы.
Пока это будут пустые методы draw() и move().
Классы-наследники должны будут переопределить их у себя и реализовать необходимую функциональность.

Еще добавь метод die() - объект умирает (isAlive=false)

А еще нам нужно будет определять попала бомба в корабль или ракета в НЛО.
Это будем делать так:
Создадим специальный метод: public boolean isIntersec(BaseObject o)
Он будет определять - "пересеклись" объекты или нет. Если пересеклись - возвращать true, если нет - false.

Т.к. объекты мы условно считаем кругами, то предлагаю такую формулу взаимодействия
Если центр круга одного объекта попал в круг другого, то будем считать, что они столкнулись.
Или еще проще:
дистанция_между_объектами < max (радиус_первого_объекта, радиус_второго_объекта)



Задание 6
Теперь перейдем к классу BaseObject.
Я хочу сделать несколько предложений.

Во-первых. Для простоты, считать все объекты у нас в космосе круглыми.
Нет, отрисовывать их мы будем фигурными, как и раньше.
А вот при расчетах из взаимодействия исходить из того, что они круглые.
Так - гораздо проще.

Во-вторых. Пусть координаты объектов и радиус будут вещественными числами.
Это придаст плавность движениям и точность всем вычислениям.
А при отрисовке мы будем их округлять

Надо:
а) Добавь в класс BaseObject  переменные x(double), y (double), radius (double), геттеры и сеттеры для них.
б) Добавить логическую переменную isAlive (жив объект или уже нет)
в) Добавить геттеры (isAlive()-метод для isAlive-переменной)
г) Добавить конструктор BaseObject(double x, double y, double radius)
д) Проследить, чтобы в конструкторе isAlive устанавливался в true (мертворожденные нам ни к чему)
е) Надо пройтись по всем классам-наследникам и поправить у них конструкторы
Если вы пользуйтесь Intellij IDEA - Alt+Insert вам в помощь



Задание 5
Чего не хватает классу Space?
Правильно - методов run() и draw().
run управляет всей логикой игры, если ты помнишь.
А draw отвечает за отрисовку очередного "кадра".

А еще нам пригодится метод sleep(int ms)
Создай их.



Задание 4
Для чего нам нужен класс Space?
Чтобы хранить в себе все объекты и управлять их взаимодействием.
А какие параметры должны у него быть?
width (ширина), height (высота).
А еще?
а) ship (космический корабль),
б) список для хранения всех НЛО -  ufos (ArrayList<Ufo>)
в) список для хранения всех ракет -  rockets (ArrayList<Rocket>)
г) список для хранения всех бомб -  bombs (ArrayList<Bomb>)

Задание:
Добавь все эти переменные к классу Space.
Инициализируй коллекции.
И не забудь добавить переменным getter'ы, а для ship еще и setter!

А что должен содержать конструктор?
Достаточно будет width и height



Задание 3
У нас будут бомбы и ракеты.
Значит нам нужны классы Bomb(бомба) и Rocket(ракета).
Создай их.

У наших объектов будет много общего.
Они будут перемещаться по космосу и отрисовываться.
Значит у них у всех будут координаты и размер.
А еще методы move() - для перемещения и draw() для отрисовки.

Есть интересное предложение: давай введем один базовый класс для всех объектов.
Пусть это будет класс BaseObject.
А классы Ufo, SpaceShip, Rocket, Bomb от него наследуются.
Создай класс BaseObject и добавь его родителем к классам Ufo,SpaceShip, Rocket, Bomb

Еще нам понадобится класс Canvas
Он будет ответственным за "отрисовку" объектов.
С его помощью они будут отрисовывать себя.
Вернее даже на нем.
Создай и этот класс.



Задание 2
Так. Чего на не хватает?
Метода main, конечно.
Вот с него и начнем.
Добавь метод main в класс Space



Задание 1
Давай напишем новую компьютерную игрушку.
У нас будет космический корабль, который стреляет ракетами в НЛО.
А НЛО в свою очередь сбрасывает на корабль бомбы.
Ну и, конечно, всё дело происходит в космосе.

Нам понадобятся классы: Space(космос), SpaceShip(космический корабль) и Ufo(НЛО)
Создай классы: Space, SpaceShip, Ufo


package com.javarush.test.level26.lesson02.task01;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        return array;
    }
}


package com.javarush.test.level26.lesson02.task02;

import java.util.Set;
import java.util.TreeSet;

/* Был бы ум - будет и успех.
Солдаты всегда строились, строятся и будут строиться по убыванию роста.
Отсортируйте солдат, предварительно подумав, что лучше использовать при таких условиях - Comparable или Comparator.
*/
public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier{
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}


package com.javarush.test.level26.lesson02.task03;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {
}


package com.javarush.test.level26.lesson05.task01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Для того, чтобы усовершенствовать ум, надо больше размышлять, чем заучивать.
Расставьте volatile там, где необходимо
*/
public class Solution extends Thread {
    public static final String DEFAULT_JAVARUSH_THREAD_NAME = "JavaRushThread";

    private static final AtomicInteger createdThreadIndex = new AtomicInteger();
    private static final AtomicInteger aliveThreadIndex = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    private static boolean debugLifecycle = false;

    public Solution(Runnable runnable) {
        this(runnable, DEFAULT_JAVARUSH_THREAD_NAME);
    }

    public Solution(Runnable runnable, String name) {
        super(runnable, name + "-" + createdThreadIndex.incrementAndGet());

        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                log.log(Level.SEVERE, "An error occurred in thread " + t.getName(), e);
            }
        });
    }

    public static void main(String[] args) {
        new Solution(new Runnable() {
            @Override
            public void run() {
                System.out.println("test JavaRush Runnable for Solution class");
            }
        }).start();


        new Solution(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Oops");
            }
        }).start();
    }

    public void run() {
        boolean debug = debugLifecycle;
        if (debug) {
            log.log(Level.FINE, "Created " + getName());
        }
        try {
            aliveThreadIndex.incrementAndGet();
            super.run();
        } finally {
            aliveThreadIndex.decrementAndGet();
            if (debug) {
                log.log(Level.FINE, "Exiting " + getName());
            }
        }
    }
}

package com.javarush.test.level26.lesson05.task02;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* Трудолюбие - душа всякого дела и залог благосостояния.
Расставьте volatile там, где необходимо
*/
public class Solution {
    private static ScheduledExecutorService interruptScheduledExecutor;
    private static Thread taskThread;
    private static RethrowableTask task;

    public static void main(String[] args) throws Exception {
        runTaskBySchedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
                throw new RuntimeException("it's test");
            }
        }, 1_000, TimeUnit.MILLISECONDS
        );

        interruptScheduledExecutor.shutdown();
    }

    public static void runTaskBySchedule(final Runnable runnable, long timeout, TimeUnit unit) throws Exception {
        task = new RethrowableTask(runnable);
        taskThread = new Thread(task);
        taskThread.start();

        interruptScheduledExecutor = Executors.newScheduledThreadPool(1);
        interruptScheduledExecutor.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        try {
            task.rethrow();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    public static class RethrowableTask implements Runnable {
        private Throwable throwable;
        private Runnable runnable;

        public RethrowableTask(Runnable runnable) {
            this.runnable = runnable;
        }

        public void run() {
            try {
                runnable.run();
            } catch (Throwable throwable) {
                this.throwable = throwable;
            }
        }

        public void rethrow() throws Exception {
            if (throwable != null) {
                System.out.println("B");
                throw new Exception(throwable);
            }
        }
    }
}


package com.javarush.test.level26.lesson05.task03;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* Тот, кто любит труд, не нуждается в развлечениях.
Расставьте volatile там, где необходимо
*/
public class Solution {
    private final URL javarushUrl;
    private final URL javarushUrl1Child;
    private final URL javarushVkGroupUrl;
    private final URL javarushVkGroupUrl1Child;
    private final URL javarushVkGroupUrl2Child;
    private final URL javarushVkGroupUrl3Child;

    private ExecutorService executorService;
    private final Set<URL> urlsForProcessing = new HashSet();

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Solution solution = new Solution();
        solution.start();
        Thread.sleep(1000);
        solution.stop();
    }

    public Solution() throws MalformedURLException {
        javarushUrl = new URL("http://javarush.ru/");
        javarushVkGroupUrl = new URL("http://vk.com/javarush");
        javarushUrl1Child = new URL("http://info.javarush.ru/page/FAQ/");
        javarushVkGroupUrl1Child = new URL("https://plus.google.com/114772402300089087607/about");
        javarushVkGroupUrl2Child = new URL("https://www.facebook.com/pages/Javarush/524321077686033");
        javarushVkGroupUrl3Child = new URL("https://twitter.com/javarush_ru");

        urlsForProcessing.add(javarushUrl);
        urlsForProcessing.add(javarushVkGroupUrl);
    }

    public synchronized void start() {
        executorService = Executors.newCachedThreadPool();
        for (URL url : urlsForProcessing) {
            submitUrlTask(url);
        }
        urlsForProcessing.clear();
    }

    public synchronized void stop() throws InterruptedException {
        try {
            saveUnprocessedUrls(executorService.shutdownNow());
            if (executorService.awaitTermination(1_000, TimeUnit.MILLISECONDS)) {
                saveUnprocessedUrls(getCancelledTasksFromExecutor());
            }
        } finally {
            executorService = null;
        }
    }

    private List<Runnable> getCancelledTasksFromExecutor() {
        return Collections.EMPTY_LIST;
    }

    protected List<URL> processPage(URL url) {
        System.out.println(url + " will be processed");
        return getChildUrlByParent(url);
    }

    private List<URL> getChildUrlByParent(URL url) {
        List<URL> result = new ArrayList<>();

        if (javarushUrl.equals(url)) {
            result.add(javarushUrl1Child);
        } else if (javarushVkGroupUrl.equals(url)) {
            result.add(javarushVkGroupUrl1Child);
            result.add(javarushVkGroupUrl2Child);
            result.add(javarushVkGroupUrl3Child);
        }
        return result;
    }

    private void saveUnprocessedUrls(List<Runnable> unprocessed) {
        for (Runnable task : unprocessed) {
            urlsForProcessing.add(((UrlTask) task).getPage());
        }
    }

    private void submitUrlTask(URL url) {
        executorService.execute(new UrlTask(url));
    }

    public class UrlTask implements Runnable {
        private final URL url;

        private UrlTask(URL url) {
            this.url = url;
        }

        public void run() {
            for (URL link : processPage(url)) {
                if (Thread.currentThread().isInterrupted()) return;
                submitUrlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }
}

package com.javarush.test.level26.lesson08.task01;

/* Вежливость - это искусственно созданное хорошее настроение.
В классе Solution создайте public static класс IntegerHolder.
IntegerHolder должен быть для типа int, быть нитебезопасным и изменяемым.
В этом классе должны быть два public метода get и set
*/
public class Solution {
    public static void main(String[] args) {
    }
}

package com.javarush.test.level26.lesson08.task02;

/* Мудрый человек думает раз, прежде чем два раза сказать.
Все методы класса Solution должны быть потоково-безопасными.
Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными трэдами.
synchronized(this) для этого не подходит, используйте другой объект для лока.
*/
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        return var1 + var2;
    }

    public int getSumOfVar3AndVar4() {
        return var3 + var4;
    }
}

package com.javarush.test.level26.lesson08.task03;

/* Распределение элементов по корзинам с собственным локом.
В синхронизированных блоках используйте нужный лок.
*/
public class Solution {
    private static final int NUMBER_LOCKS = 12;
    private final Node[] buckets;
    private final Object[] locks;

    private static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public Solution(int numberBuckets) {
        buckets = new Node[numberBuckets];
        locks = new Object[NUMBER_LOCKS];
        for (int i = 0; i < NUMBER_LOCKS; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (this) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (this) {
                buckets[i] = null;
            }
        }
    }
}

package com.javarush.test.level26.lesson10.task01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* Весь мир играет комедию.
Почитать про java.util.concurrent.locks.Lock на http://docs.oracle.com/  (там все есть в джавадоках!)
Написать реализацию метода someMethod:
1. попытаться захватить лок
1.1. если лок занят, то вызвать метод ifLockIsBusy
1.2. если лок свободен, то:
1.2.1 вызвать метод ifLockIsFree
1.2.2 отпустить лок при любых условиях, даже если ifLockIsFree будет кидать исключение
*/
public class Solution {
    protected Lock lock = new ReentrantLock();

    public void someMethod() {
        //implement logic here, use the lock field
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}

package com.javarush.test.level26.lesson10.home01;

/* Мир скучен для скучных людей.
Разберитесь с BlockingQueue
По образу и подобию класса Producer создайте класс Consumer, который будет выводить данные из BlockingQueue в консоль
*/
public class Solution {

    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(32);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();

    }
}

package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    protected BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            int i = 0;
            while (true) {
                queue.put(String.valueOf(i++));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}


package com.javarush.test.level26.lesson10.home02;

import com.javarush.test.level26.lesson10.home02.Producer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* Мир не меняется, меняемся мы.
Разберитесь с ConcurrentHashMap
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды выводить на консоль с новой строки начиная с 1 фразу [Some text for i] , пример "Some text for 1"
2. при возникновении исключения выводить в консоль [[TREAD_NAME] thread was terminated], пример "[thread-1] thread was terminated"
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        Producer producer = new Producer(map);
        Consumer consumer = new Consumer(map);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();
        //finally 5 lines have to be printed
    }
}

package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Consumer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Consumer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            if (!map.isEmpty()) {
                for (String key : map.keySet()) {
                    System.out.println(map.remove(key));
                }
            }
        }
    }
}

****************************************************************
Задание 15
1. В CashMachine создай константу - путь к ресурсам.
public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
Отрефактори загрузку всех ResourceBundle с учетом RESOURCE_PATH.

2. В классе CashMachine не должно быть инициализации ResourceBundle.
Вынеси из CashMachine сообщение о выходе в ConsoleHelper, назови метод printExitMessage.

3. Это всё! Красоту можешь наводить самостоятельно. Тестов на этот пункт не будет.
Например:
3.1. Исправить выводимые тексты
3.2. Добавить ресурсы для нескольких локалей. Например, еще и для русской.
3.3. Добавить валидацию вводимых номиналов.

Твои достижения:
1. разобрался с паттерном Command
2. подружился с Жадным алгоритмом
3. познакомился с локализацией
4. стал больше знать и уметь
5. увидел, как раскладывать задачу на подзадачи
6. продвинулся на шаг ближе к работе джава программистом
7. решил одно из тестовых заданий, которое дают на собеседовании. Только тсссс, никому об этом не говори :)
Если когда-то тебе дадут такое задание, то не копируй это решение, а сделай свое по аналогии.

Поздравляю!


****************************************************************
Задание 14
1. Для каждого нового ресурса замени все строки в соответствующей команде.

2. Для ресурса common_en.properties замени все строки в ConsoleHelper.


****************************************************************
Задание 13
Ты уже разобрался с ResourceBundle - это круто.
Теперь мы сможем прикрутить локализацию, т.е. поддержку нескольких языков

1. В каждую команду добавь поле private ResourceBundle res, которое инициализируй соответствующим ресурсом

2. Для каждого нового ресурса замени все строки в соответствующей команде.


****************************************************************
Задание 12
В задании 11 мы захардкодили номер кредитной карточки с пином, с которыми разрешим работать нашему банкомату.
Но юзеров может быть много. Не будем же мы их всех хардкодить! Если понадобится добавить еще одного пользователя,
то придется передеплоить наше приложение. Есть решение этой проблемы.

Смотри, добавился новый пакет resources, в котором мы будем хранить наши ресурсные файлы.
В этом пакете есть файл verifiedCards.properties, в котором заданы карточки с пинами.

1. В LoginCommand добавь поле private ResourceBundle validCreditCards.
При объявлении инициализируй это поле данными из файла verifiedCards.properties.
Почитай в инете, как это делается для ResourceBundle.

2. Замени хардкоженные данные кредитной карточки и пина на проверку наличия данных в ресурсе verifiedCards.properties.

3. Добавь обработку команды LoginCommand в начало нашего main внутрь блока try-catch


****************************************************************
Задание 11
Поздравляю, ты реализовал WithdrawCommand! Основной функционал завершен. Дальше можно допиливать и наводить красоту.
Реализуем одну плюшку. Можно и без нее, но с ней - красивее.
Это верификация кредитной карты пользователя. Нет, никакого API сторонних либ не будет. Только консольная обработка.

Итак, назовем эту операцию LOGIN и сделаем для нее команду.
1. Добавить в операции LOGIN с ординал=0
2. Запретим пользователю выбирать эту операцию из списка.
В единственном методе для поиска операций запретим доступ по ординал - бросим IllegalArgumentException.
3. Создадим LoginCommand по аналогии с другими командами, в котором захардкодим номер карточки с пином
123456789012 и 1234 соответственно.
4. Реализуйте следующую логику для команды LoginCommand:
4.1. Пока пользователь не введет валидные номер карты и пин - выполнять следующие действия
4.2. Запросить у пользователя 2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр
4.3. Вывести юзеру сообщение о невалидных данных, если они такими являются.
4.4. Если данные валидны, то проверить их на соответствие захардкоженным (123456789012 и 1234).
4.5. Если данные в п. 4.4. идентифицированы, то сообщить, что верификация прошла успешно.
4.6. Если данные в п. 4.4. НЕ идентифицированы, то вернуться к п.4.1.


****************************************************************
Задание 10
Сегодня мы займемся командой WithdrawCommand - это самая сложная операция.

1. Реализуйте следующий алгоритм для команды WithdrawCommand:
1.1. Считать код валюты (метод уже есть)
1.2. Получить манипулятор для этой валюты.
1.3. Пока пользователь не введет корректные данные выполнять:
1.3.1. Попросить ввести сумму
1.3.2. Если введены некорректные данные, то сообщить об этом пользователю и вернуться к п. 1.3.
1.3.3. Проверить, достаточно ли средств на счету.
Для этого в манипуляторе создайте метод boolean isAmountAvailable(int expectedAmount), который вернет true, если денег достаточно для выдачи.
Если недостаточно, то вернуться к п. 1.3.
1.3.4. Списать деньги со счета. Для этого в манируляторе создайте метод
Map<Integer, Integer> withdrawAmount(int expectedAmount), который вернет карту Map<номинал, количество>.
Подробно логику этого метода смотрите в п.2.
1.3.5. Вывести пользователю результат из п. 1.3.4. в следующем виде:
<табуляция>номинал - количество
Сортировка - от большего номинала к меньшему.
Вывести сообщение об успешной транзакции.
1.3.6. Перехватить исключение NotEnoughMoneyException, уведомить юзера о нехватке банкнот и вернуться к п. 1.3.

2. Логика основного метода withdrawAmount:
2.1. Внимание!!! Метод withdrawAmount должен возвращать минимальное количество банкнот, которыми набирается запрашиваемая сумма.
Используйте Жадный алгоритм (use google).
Если есть несколько вариантов, то использовать тот, в котором максимальное количество банкнот высшего номинала.
Если для суммы 600 результат - три банкноты: 500 + 50 + 50 = 200 + 200 + 200, то выдать первый вариант.
Пример, надо выдать 600
В манипуляторе есть следующие банкноты:
500 - 2
200 - 3
100 - 1
50 - 12
Результат должен быть таким:
500 - 1
100 - 1
т.е. всего две банкноты (это минимальное количество банкнот) номиналом 500 и 100.

2.2. Мы же не можем одни и те же банкноты выдавать несколько раз, поэтому
если мы нашли вариант выдачи денег (п.2.1. успешен), то вычесть все эти банкноты из карты в манипуляторе.

2.3. метод withdrawAmount должен кидать NotEnoughMoneyException, если купюрами невозможно выдать запрашиваемую сумму.
Пример, надо выдать 600
В манипуляторе есть следующие банкноты:
500 - 2
200 - 2
Результат - данными банкнотами невозможно выдать запрашиваемую сумму. Кинуть исключение.
Не забудьте, что в некоторых случаях картой кидается ConcurrentModificationException.


****************************************************************
Задание 9
Сегодня мы займемся командой ExitCommand.
1. Реализуйте следующую логику в команде ExitCommand:
1.1. Спросить, действительно ли пользователь хочет выйти - варианты <y,n>.
1.2. Если пользователь подтвердит свои намерения, то попрощаться с ним.

Это всё хорошо, но бывают случаи, когда срочно нужно прервать операцию, например, если пользователь ошибся с выбором операции.
Для этого у нас есть InterruptOperationException.
2.Реализуйте следующую логику:
2.1. Если пользователь в любом месте ввел текст 'EXIT' любым регистром, то выбросить InterruptOperationException.
2.2. Найдите единственное место, куда нужно вставить эту логику. Реализуйте функционал в этом единственном методе.

3. Заверните тело метода main в try-catch и обработайте исключение InterruptOperationException.
Попрощайтесь с пользователем в блоке catch используя ConsoleHelper.


****************************************************************
Задание 8
Пора привести в порядок наш main, уж очень там всего много, чего не должно быть.

1. Перенесите логику из main в DepositCommand и InfoCommand
Проверим, что там стало с main? Цикл, в котором спрашиваем операцию у пользователя, а потом вызываем метод у CommandExecutor.
И так до бесконечности... надо бы придумать условие выхода из цикла.
Исправь цикл, чтоб он стал do-while. Условие выхода - операция EXIT.

2. Давайте запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
Ничего не понятно, т.к. создались 2 манипулятора: первый для EUR, второй для USD.
Давайте улучшим логику InfoCommand. Надо вывести баланс по каждому манипулятору.

2.1. В классе CurrencyManipulatorFactory создайте статический метод getAllCurrencyManipulators(), который вернет Collection всех манипуляторов.
У вас все манипуляторы хранятся в карте, не так ли? Если нет, то рефакторьте.
2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
Все работает правильно?
 EUR - 200
 USD - 120
Отлично!

3. Запустим прогу и сразу первой операцией попросим INFO. Ничего не вывело? Непорядок.
Добавьте в манипулятор метод boolean hasMoney(), который будет показывать, добавлены ли какие-то банкноты или нет.

4. В InfoCommand используйте метод п.3. и выведите фразу "No money available.", если нет денег в банкомате.


****************************************************************
Задание 7
Возвращаемся к паттерну Command.

1. Создадим пакет command, в нем будут все классы, относящиеся к этой логике.
Подумайте над модификатором доступа для всех классов в этом пакете.

2. Создадим интерфейс Command с методом void execute().

3. Для каждой операции создадим класс-команду, удовлетворяющую паттерну Command.
Имена классов DepositCommand, InfoCommand, WithdrawCommand, ExitCommand

4. Создадим public класс CommandExecutor, через который можно будет взаимодействовать со всеми командами.
Создадим ему статическую карту Map<Operation, Command>, которую проинициализируем всеми известными нам операциями и командами.

4.1 Создадим метод public static final void execute(Operation operation), который будет дергать метод execute у нужной команды.
Реализуйте эту логику.
4.2. Расставьте правильно модификаторы доступа учитывая, что единственная точка входа - это метод execute.

Проверяем, чтоб структура соответствовала тестам на сервере.
Логику будем переносить в следующем таске.


****************************************************************
Задание 6
Чтобы отрефакторить код в соответствии с паттерном Command, нужно выделить в коде несколько логических блоков кода.
У нас пока два таких блока: 1) код операции DEPOSIT, 2) код операции INFO.
Они захардкожены в методе main. Нужно от этого избавиться.
Нужно сделать так, чтобы пользователь сам выбирал, какую операцию на данный момент нужно выполнять.

1. В энум Operation добавьте статический метод Operation getAllowableOperationByOrdinal(Integer i)
Должен возвращать элемент энума: для 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
На некорректные данные бросать IllegalArgumentException

2. В классе ConsoleHelper реализуйте логику статического метода Operation askOperation()
Спросить у пользователя операцию.
Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
Используйте метод, описанный в п.1.
Обработай исключение - запроси данные об операции повторно.


****************************************************************
Задание 5
1.В предыдущем таске мы реализовали основную логику операции DEPOSIT.
Но посмотреть результат так и не удалось.
Поэтому создадим в манипуляторе метод int getTotalAmount(), который посчитает общую сумму денег для выбранной валюты.

2. Добавим вызов метода getTotalAmount() в метод main.
Всё работает верно? Тогда движемся дальше.
Видно, что метод getTotalAmount() считает то, что нам необходимо для операции INFO.
Поэтому пришло время небольшого рефакторинга.
!!Читайте паттерн Command.
Однако, перед рефакторингом нужно еще разобраться в одном вопросе. Но об этом не сейчас.


****************************************************************
Задание 4
1. Выберем операцию, с которой мы сможем начать.
Подумаем. В банкомате еще денег нет, поэтому INFO и WITHDRAW протестить не получится.
Начнем с операции DEPOSIT - поместить деньги.
Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.

2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Если данные валидны, то перевести код в верхний регистр и вернуть.

3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
Этот метод должен предлагать пользователю ввести два целых положительных числа.
Первое число - номинал, второе - количество банкнот.
Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Пример вводимых данных:
200 5

4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
который добавит введенные номинал и количество банкнот

5. Пора уже увидеть приложение в действии.
В методе main захардкодь логику пункта 1.
Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой строчкой Locale.setDefault(Locale.ENGLISH);
Запускаем, дебажим, смотрим.


****************************************************************
Задание 3
1. Создадим класс CurrencyManipulator, который будет хранить всю информацию про выбранную валюту.
String currencyCode - код валюты, например, USD. Состоит из трех букв
Map<Integer, Integer> denominations - это Map<номинал, количество>
Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode
Очевидно, что манипулятор никак не может функционировать без названия валюты,
поэтому добавим конструктор с этим параметром и проинициализируем currencyCode

2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
Создадим класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
Подумайте, где лучше хранить все манипуляторы.
Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса


****************************************************************
Задание 2
1. Создадим в ConsoleHelper два статических метода:
1.1 writeMessage(String message), который будет писать в консоль наше сообщение
1.2 String readString(), который будет считывать с консоли строку и возвращать ее.
Если возникнет какое-то исключение при работе с консолью, то перехватим его и не будем обрабатывать.
Кстати, создадим только один экземпляр BufferedReader-а

2. Создадим пакет exception, в который поместим два checked исключения:
2.1 InterruptOperationException будем кидать, когда нужно прервать текущую операцию и выйти из приложения
2.2 NotEnoughMoneyException будем кидать, когда не сможем выдать запрашиваемую сумму


****************************************************************
Задание 1

Давай напишем эмулятор работы банкомата.
Операции, которые будем поддерживать, следующие:
поместить деньги, снять деньги, показать состояние банкомата.
Также будем поддерживать мультивалютность.
Купюрами будем оперировать теми, которые поместим в банкомат.
Если для снятия требуемой суммы будет недостаточно банкнот, то сообщим юзеру об этом.
Понятно, что всё должно быть user friendly, поэтому придется наводить рюшечки.

Итак..
1. Создайте класс CashMachine с методом main.
2. Наши операции зададим в энуме Operation: INFO, DEPOSIT, WITHDRAW
Т.к. всё должно быть user friendly, то на выход из приложения надо попрощаться с юзером.
Поэтому добавим еще операцию EXIT
3. Т.к мы будем активно общаться с юзером, то будет много выводимого текста.
Чтобы работу с консолью сосредоточить в одном месте, создадим класс ConsoleHelper


package com.javarush.test.level27.lesson02.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Рефакторинг
Перепишите код без использования меток, сохранив при этом логику.
Не оставляйте закомментированный код.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        int a;
        int sum = 0;
        first:
        do {
            a = Integer.parseInt(bis.readLine());
            second:
            sum += a;
        } while (isContinueWhile(sum));
        System.out.println(sum);
    }

    private static boolean isContinueWhile(int sum) {
        second:
        for (int k = 0; k < 100; k += 20)
            if (sum < 100 && k <= 20) {
                System.out.println(k < 2 ? k : sum % k);
            } else {
                break second;
            }

        return false;
    }
}

package com.javarush.test.level27.lesson02.task02;

/* Нужный оператор
Вставьте в код единственную строчку - оператор (не break), чтобы выводился треугольник из букв S
*/
public class Solution {
    public static void main(String args[]) {
        label:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                }
                System.out.print("S");
            }
        }
    }
}

package com.javarush.test.level27.lesson04.task01;

/* Создаем дедлок
Расставьте модификаторы так, чтобы при работе с этим кодом появился дедлок
Метод main порождает deadLock, поэтому не участвует в тестировании
*/
public class Solution {
    private final String field;

    public Solution(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void sout(Solution solution) {
        System.out.format("111:  %s: %s %n", this.field, solution.getField());
        solution.sout2(this);
    }

    public void sout2(Solution solution) {
        System.out.format("222:  %s: %s %n", this.field, solution.getField());
        solution.sout(this);
    }

    public static void main(String[] args) {
        final Solution solution = new Solution("first");
        final Solution solution2 = new Solution("second");
        new Thread(new Runnable() {
            public void run() {
                solution.sout(solution2);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                solution2.sout(solution);
            }
        }).start();
    }
}

package com.javarush.test.level27.lesson04.task02;

/* Второй вариант дедлока
В методе secondMethod в синхронизированных блоках расставьте локи так,
чтобы при использовании класса Solution нитями образовывался дедлок
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        doSomething();
    }

    private void doSomething() {
    }
}

package com.javarush.test.level27.lesson04.home01;

/* Модификаторы и дедлоки
Расставьте модификаторы так, чтобы при работе с этим кодом появился дедлок
*/
public class Solution {
    public Object getData() {
        return new ThreadDeadlock().getData();
    }
}
package com.javarush.test.level27.lesson04.home01;

public class ThreadDeadlock {
    Object data;
    public Object getData() {
        return data;
    }
}


package com.javarush.test.level27.lesson06.task01;

/* Убираем deadLock
Используя стратегию избегания deadLock-а сделайте так, чтобы он не возник.
Метод main не участвует в тестировании.
Действуйте аналогично примеру из лекций.
Изменения вносите только в safeMethod.
*/
public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        synchronized (obj1) {
            longTimeMethod();
            synchronized (obj2) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread(){
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}

package com.javarush.test.level27.lesson06.task02;

/* Определяем порядок захвата монитора. Сложная.
Реализуйте логику метода isNormalLockOrder, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks - порядку
передаваемых в него аргументов. Должно выполняться условие:
для разных объектов o1 и o2 isNormalLockOrder(o1, o2) != isNormalLockOrder(o2, o1), для одинаковых объектов одинаковый результат
Метод main не участвует в тестировании.
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        //следующие 4 строки в тестах имеют другую реализацию
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;

        synchronized (firstLock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }

            synchronized (secondLock) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o1, o2); //expected boolean b
                } catch (Exception ignored) {
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o2, o1); //expected boolean !b
                } catch (Exception ignored) {
                }
            }
        }.start();
    }
}

package com.javarush.test.level27.lesson06.home01;

import java.util.Set;

/* Убираем deadLock используя Открытые вызовы
Синхронизированные методы, которые вызывают внутри себя синхронизированные методы других классов, приводят к dead-lock-у.
1. Перенесите синхронизацию с метода в синхронизированный блок, куда поместите лишь необходимые части кода.
2. Уберите избыточную синхронизацию методов.
3. В стеке вызова методов не должно быть перекрестной синхронизации,
т.е. такого synchronizedMethodAClass().synchronizedMethodBClass().synchronizedMethodAClass()

Этот способ избавления от дэдлока называется Открытые вызовы, о нем читайте в дополнительном материале к лекции.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        final long deadLineTime = System.currentTimeMillis() + 5000; //waiting for 5 sec

        final RealEstate realEstate = new RealEstate();
        Set<Apartment> allApartments = realEstate.getAllApartments();

        final Apartment[] apartments = allApartments.toArray(new Apartment[allApartments.size()]);

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        realEstate.revalidate();
                    }
                }
            }, "RealEstateThread" + i).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < apartments.length; i++) {
                        apartments[i].revalidate(true);
                    }
                }
            }, "ApartmentThread" + i).start();
        }

        Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (System.currentTimeMillis() < deadLineTime)
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ignored) {
                    }
                System.out.println("The dead lock occurred");
            }
        });
        deamonThread.setDaemon(true);
        deamonThread.start();
    }
}

package com.javarush.test.level27.lesson06.home01;

public class Apartment {
    private String location;
    private final RealEstate realEstate;

    public Apartment(RealEstate realEstate) {
        this.realEstate = realEstate;
        setLocation(String.valueOf(Math.random() * 10));
    }

    public synchronized String getLocation() {
        return location;
    }

    public synchronized void setLocation(String location) {
        this.location = location;
    }

    public synchronized void revalidate(boolean isEmpty) {
        if (isEmpty)
            realEstate.up(this);
    }
}
package com.javarush.test.level27.lesson06.home01;

import java.util.HashSet;
import java.util.Set;

public class RealEstate {

    private final Set<Apartment> allApartments;
    private final Set<Apartment> activeApartments;

    public RealEstate() {
        allApartments = new HashSet();
        activeApartments = new HashSet();

        //add some data
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
    }

    public Set<Apartment> getAllApartments() {
        return allApartments;
    }

    public synchronized void up(Apartment apartment) {
        activeApartments.add(apartment);
    }

    public synchronized void revalidate() {
        activeApartments.clear();
        for (Apartment apartment : allApartments) {
            boolean randomValue = Math.random() * 2 % 2 == 0;
            apartment.revalidate(randomValue);
        }
    }
}


package com.javarush.test.level27.lesson09.task01;

import java.util.concurrent.CountDownLatch;

/* CountDownLatch
Дана стандартная реализация методологии wait-notify.
Почитайте про CountDownLatch и перепишите тело метода someMethod используя поле latch.
Весь лишний код удалите из класса.
*/
public abstract class Solution {
    private final Object lock = new Object();
    private volatile boolean isWaitingForValue = true;

    private final CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        synchronized (lock) {
            while (isWaitingForValue) {
                lock.wait();
            }
        }

        retrieveValue();

        isWaitingForValue = false;
        lock.notify();
    }

    abstract void retrieveValue();
}


package com.javarush.test.level27.lesson09.home01;

/* Producer–consumer
В классе TransferObject расставьте вызов методов wait/notify/notifyAll,
чтобы обеспечить последовательное создание и получение объекта.
Ожидаемый вывод:
...
Put: M
Got: M
Put: N
Got: N
Put: K
Got: K
...
где M, N, K - числа
Метод main не участвует в тестировании
PS: всегда старайтесь использовать любой concurrent список вместо реализации wait/notify/notifyAll.
Однако понимать основные методы необходимо
*/
public class Solution {
    public static void main(String args[]) throws InterruptedException {
        TransferObject transferObject = new TransferObject();
        ProducerTask producerTask = new ProducerTask(transferObject);
        ConsumerTask consumerTask = new ConsumerTask(transferObject);

        Thread.sleep(50);
        producerTask.stop();
        consumerTask.stop();
    }
}


package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        this.value = value;
        System.out.println("Put: " + value);
    }
}
package com.javarush.test.level27.lesson09.home01;

public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
        while (!stopped) {
            transferObject.get();
        }
    }

    public void stop() {
        stopped = true;
    }
}
package com.javarush.test.level27.lesson09.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;
    static volatile AtomicInteger i = new AtomicInteger(0);

    public ProducerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ProducerTask").start();
    }

    public void run() {
        while (!stopped) {
            transferObject.put(i.incrementAndGet());
        }
    }

    public void stop() {
        stopped = true;
    }
}


package com.javarush.test.level27.lesson09.home02;

/* Расставьте wait-notify.
Расставьте wait-notify.
Пример вывода:
Thread-0 MailServer has got: [Person [Thread-1] has written an email 'AAA'] in 1001 ms after start
*/
public class Solution {
    public static void main(String[] args) {
        Mail mail = new Mail();
        Thread server = new Thread(new MailServer(mail));
        Thread amigo = new Thread(new Person(mail));

        server.start();
        amigo.start();
    }
}


package com.javarush.test.level27.lesson09.home02;

public class Mail {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
package com.javarush.test.level27.lesson09.home02;

public class MailServer implements Runnable
{
    private Mail mail;

    public MailServer(Mail mail)
    {
        this.mail = mail;
    }

    @Override
    public void run()
    {
        long beforeTime = System.currentTimeMillis();
        //сделайте что-то тут - do something here
        String name = Thread.currentThread().getName();
        long afterTime = System.currentTimeMillis();
        System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
    }
}
package com.javarush.test.level27.lesson09.home02;

public class Person implements Runnable
{
    private final Mail mail;

    public Person(Mail mail)
    {
        this.mail = mail;
    }

    @Override
    public void run()
    {
        String name = Thread.currentThread().getName();
        try
        {
            Thread.sleep(1000);
            //сделайте что-то тут - do something here
			mail.setText("Person [" + name + "] has written an email 'AAA'");
            //сделайте что-то тут - do something here
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

package com.javarush.test.level28.lesson02.task01;

/* Осваиваем switch
Реализуйте логику метода switchTest:
1. Не используйте условные операторы
2. Используйте 1 switch, у которого 2 case и 1 default
3. Ожидаемый вывод:
Вывод для E1.A - "it's E1.A"
Вывод для E1.B - "it's E1.B"
Вывод для E1.C - "it's E1.C"
Вывод для E1.Y - "it's E1.Y"
Вывод для E2.D - "it's E2.D"
Вывод для E2.E - "it's E2.E"
Вывод для E2.F - "it's E2.F"
Вывод для всех других значений - "undefined"
*/
public class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* output
        it's E1.C
        undefined
        it's E2.D
         */
    }

    public static void switchTest(Enum obj) {
        //add your code here
    }
}

package com.javarush.test.level28.lesson04.task02;

import java.util.concurrent.ThreadLocalRandom;

/* ThreadLocalRandom
Класс Solution будет использоваться трэдами.
Реализуйте логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to
getRandomDouble должен возвращать случайный double
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return 0;
    }

    public static double getRandomDouble() {
        return 0;
    }

    public static long getRandomLongBetween0AndN(long n) {
        return 0;
    }
}

package com.javarush.test.level28.lesson06.task01;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/* Magic class
В пакете java.util.concurrent найдите такую реализацию List, у которой
1. итератор не содержит какие-либо данные, вставленные в список после создания итератора
2. внутри данные хранятся в виде массива
3. итератор гарантированно не бросает ConcurrentModificationException
4. допускаются все элементы включая null
5. Исправьте строку List<String> list = null ... в методе main
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        List<String> list = null/* create object of this magic class here*/;

        solution.startUpdatingThread(list);
        solution.copyOnWriteSolution(list);
        solution.stopUpdatingThread();

        /* The output example
size = 0
Element :s781859336
Element :s1453499757
Element :s911312405
Element :s-877520242
Element :s-1636258097
size = 5

Element2 :s781859336
Element2 :s1453499757
Element2 :s911312405
Element2 :s-877520242
Element2 :s-1636258097
Element2 :s-1739827856
Element2 :s-938954654
Element2 :s925086217
size = 8
         */
    }

    public void copyOnWriteSolution(List<String> list) throws InterruptedException {
        System.out.println("size = " + list.size());
        System.out.println();
        Thread.sleep(20);
        for (String element : list) {   //создает новую копию на момент создания итератора
            System.out.println("Element :" + element);
        }
        System.out.println("size = " + list.size());
        System.out.println();
        Thread.sleep(20);

        for (String element : list) {  //создает новую копию на момент создания итератора
            System.out.println("Element2 :" + element);
        }
        System.out.println("size = " + list.size());
        stopUpdatingThread();
    }

    public void stopUpdatingThread() throws InterruptedException {
        t.stop();
        t.join();
    }

    private Thread t;

    private void startUpdatingThread(final List<String> list) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    list.add("s" + ThreadLocalRandom.current().nextInt());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        t.start();
    }
}

package com.javarush.test.level28.lesson08.task01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* Знакомство с Executors
1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
2. В цикле отправь на исполнение в пул 10 тасок Runnable.
3. У каждой таски в методе run вызови метод doExpensiveOperation с порядковым номером таски начиная с 1, см. пример вывода
4. Запрети добавление новых тасок на исполнение в пул (метод shutdown)
5. Дай экзэкьютору 5 секунд на завершение всех тасок (метод awaitTermination и параметр TimeUnit.SECONDS)
Не должно быть комментариев кроме приведенного output example
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}

package com.javarush.test.level28.lesson10.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/* Осваиваем Callable
Реализуйте логику метода getTask, который должен возвращать объект Callable.
Объект Callable должен вычислять сумму всех чисел от 1 до переданного числа i включая его, и возвращать его в виде строки
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1000; i <= 1010; i++) {
            futures.add(executor.submit(getTask(i)));
        }

        futures.add(executor.submit(getTask(10000000)));

        for(Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

/* output
500500
501501
502503
503506
504510
505515
506521
507528
508536
509545
510555
50000005000000
*/
    }

    public static Callable<String> getTask(final int i) {
        return null;
    }
}

package com.javarush.test.level28.lesson10.home01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/* Plants vs Zombies
1. Почитайте про java.util.concurrent.Phaser
2. Расставь методы в нужных местах
-arriveAndDeregister() - начинает запускать методы run у тасок
-arriveAndAwaitAdvance() - ждет, когда все трэды будут созданы

Пример вывода см. в output.txt
Логика:
Сначала все персонажи присоединяются к игре.
После того, как все персонажи присоединятся к игре и готовы играть, выводится фраза "Игра началась!".
После этого персонажи вступают в игру, после чего умирают.
Не должно быть закоментированного кода
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());

        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " присоединился к игре");
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + " готовится играть");
                    if (!isEveryoneReady) {
                        isEveryoneReady = true;
                        System.out.println("Игра началась!");
                    }
                    character.run();
                }
            }.start();
        }
    }
}

package com.javarush.test.level28.lesson10.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class Zombie extends Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}

package com.javarush.test.level28.lesson10.home01;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Character implements Runnable {
    protected abstract int getId();

    public void run() {
        System.out.println(toString() + " вступил в игру");
        doSomething();
        System.out.println(toString() + " умер");
    }

    private void doSomething() {
        try {
            Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(10, 100));
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " #" + getId();
    }

}
output.txt

Plant #1 присоединился к игре
Plant #2 присоединился к игре
Plant #1 готовится играть
Zombie #1 присоединился к игре
Zombie #2 присоединился к игре
Zombie #3 присоединился к игре
Plant #2 готовится играть
Zombie #2 готовится играть
Zombie #1 готовится играть
Zombie #3 готовится играть
Игра началась!
Zombie #1 вступил в игру
Zombie #3 вступил в игру
Plant #1 вступил в игру
Zombie #2 вступил в игру
Plant #2 вступил в игру
Zombie #2 умер
Plant #2 умер
Plant #1 умер
Zombie #3 умер
Zombie #1 умер

package com.javarush.test.level28.lesson10.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class Plant extends Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}package com.javarush.test.level28.lesson10.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class Plant extends Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}