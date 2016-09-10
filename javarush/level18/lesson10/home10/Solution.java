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

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> parts = new TreeMap<>();
        String fileName, completeFile = "";
        while (!(fileName = reader.readLine()).equals("end")){
            parts.put(Integer.parseInt(fileName.substring(fileName.lastIndexOf("t") + 1)), fileName);
            completeFile = fileName;
        }
        reader.close();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(completeFile.substring(0, completeFile.lastIndexOf("."))));
        for (String part : parts.values()){
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(part));
            byte[] buffer = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(buffer);
            bufferedOutputStream.write(buffer);
            bufferedInputStream.close();
        }
        bufferedOutputStream.close();
    }
}
