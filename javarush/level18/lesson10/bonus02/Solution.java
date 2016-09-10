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

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String productName = String.format("%-30.30s", args[1]);
        String price = String.format("%-8.8s", args[2]);
        String quantity = String.format("%-4.4s", args[3]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String id = String.format("%-8.8s", String.valueOf(getMaxId(fileName)+1));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
        bufferedWriter.write(id + productName + price + quantity);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
    private static long getMaxId(String fileName) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        long maxId = 0;
        long currentId;
        String currentLine;
        while ((currentLine = reader.readLine()) != null){
            currentId = Integer.parseInt(currentLine.substring(0, 8).trim());
            if (currentId > maxId)
                maxId = currentId;
        }
        reader.close();
        return maxId;
    }
}
