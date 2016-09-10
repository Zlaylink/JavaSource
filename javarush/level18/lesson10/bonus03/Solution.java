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

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if ("-u".equals(args[0])){
            String id = String.format("%-8.8s", args[1]);
            String productName = String.format("%-30.30s", args[2]);
            String price = String.format("%-8.8s", args[3]);
            String quantity = String.format("%-4.4s", args[4]);

            List<StringBuilder> list = readFile(fileName);
            for(StringBuilder value : list){
                if (id.equals(value.substring(0, 8))){
                    value.setLength(0); // очистка строки
                    value.append(id + productName + price + quantity);
                    break;
                }
            }
            writeToFile(fileName, list);
        } else if ("-d".equals(args[0])){
            String id = String.format("%-8.8s", args[1]);

            List<StringBuilder> list = readFile(fileName);
            Iterator<StringBuilder> iterator = list.iterator();

            while (iterator.hasNext()){
                if (id.equals(iterator.next().substring(0, 8))){
                    iterator.remove();
                    break;
                }
            }
            writeToFile(fileName, list);
        }
    }

    public static List<StringBuilder> readFile(String fileName) throws IOException
    {
        List<StringBuilder> list = new LinkedList<>();
        BufferedReader bufferedReader  = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = bufferedReader.readLine()) != null){
            list.add(new StringBuilder(s));
        }
        bufferedReader.close();
        return list;
    }

    public static void writeToFile(String fileName, List<StringBuilder> list) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (StringBuilder lines : list){
            bufferedWriter.write(lines.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
