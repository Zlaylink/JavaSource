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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String buffer, nameBuffer = "";
        double value;
        double max = Double.MIN_VALUE;
        TreeMap<String, Double> inf = new TreeMap<>();

        while ((buffer = reader.readLine()) != null)
        {
            String[] lineArray = buffer.split(" ");
            if (inf.containsKey(lineArray[0]))
            {
                value = inf.get(lineArray[0]);
                inf.put(lineArray[0], Double.parseDouble(lineArray[1]) + value);
            } else
            {
                inf.put(lineArray[0], Double.parseDouble(lineArray[1]));
            }
        }


        for (Map.Entry<String, Double> pair : inf.entrySet())
        {
            if (pair.getValue() > max){
                max = pair.getValue();
                nameBuffer = pair.getKey();
            }
        }

        System.out.println(nameBuffer);

        reader.close();
    }
}
