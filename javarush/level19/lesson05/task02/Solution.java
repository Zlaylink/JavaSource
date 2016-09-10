package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        int count = 0;

        while (fileReader.ready()){
            String[] buffer = fileReader.readLine().split("[., !?;:-]");
            for (String lines : buffer){
                if (lines.equals("world"))
                    count++;
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}
