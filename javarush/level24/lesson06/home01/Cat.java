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
    public Sayable toSayable(final int i)
    {
        class CatPet implements Sayable{
            private String count = "";
            @Override
            public String say()
            {
                int ii = i;
                if (ii <= 0)
                    return String.format("%s спит.", name);
                else
                {
                    for (int j = 0; j < ii; j++)
                        count +="я";
                    return String.format("%s говорит м%sу!", name, count);
                }
            }
        }
        return new CatPet();
    }
}