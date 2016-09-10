package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String fileLines;
        String line = "";
        while ((fileLines = reader.readLine()) != null){
            String[] buffer = fileLines.split(" ");
            for (String words : buffer){
                if (words.length() > 6)
                    line += words + ",";
            }
        }
        writer.write(line.substring(0, line.lastIndexOf(",")));
        reader.close();
        writer.close();
    }
}
