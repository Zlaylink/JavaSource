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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        TreeMap<Byte, Integer> data = new TreeMap<>();

        while (fileInputStream.available() > 0){
            byte i = (byte) fileInputStream.read();
            if(!data.containsKey(i)){
                data.put(i, 1);
            }
            else data.put(i, data.get(i) + 1);
        }
        for(Map.Entry<Byte, Integer> pair : data.entrySet()){
            System.out.println((char)(byte)pair.getKey() + " " + pair.getValue());
        }
        fileInputStream.close();
    }
}
