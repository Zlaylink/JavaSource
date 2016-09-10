package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        List<String> fileLines1 = new ArrayList<String>();
        List<String> fileLines2 = new ArrayList<String>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        while (readerFile1.ready())
        {
            fileLines1.add(readerFile1.readLine());
        }
        readerFile1.close();
        while (readerFile2.ready())
        {
            fileLines2.add(readerFile2.readLine());
        }
        readerFile2.close();

        boolean check = true;

        while (fileLines1.size() > 0 && fileLines2.size() > 0)
        {
            if (check)
            {
                if (fileLines1.get(0).equals(fileLines2.get(0)))
                {
                    lines.add(new LineItem(Type.SAME, fileLines1.get(0)));
                    fileLines1.remove(0);
                    fileLines2.remove(0);
                } else if (fileLines1.get(0).equals(fileLines2.get(1)))
                {
                    lines.add(new LineItem(Type.ADDED, fileLines2.get(0)));
                    fileLines2.remove(0);
                    check = !check;
                } else
                {
                    lines.add(new LineItem(Type.REMOVED, fileLines2.get(0)));
                    fileLines1.remove(0);
                }
            } else if (fileLines2.get(0).equals(fileLines1.get(0)))
            {
                lines.add(new LineItem(Type.SAME, fileLines1.get(0)));
                fileLines1.remove(0);
                fileLines2.remove(0);
            } else if (fileLines2.get(0).equals(fileLines1.get(1)))
            {
                lines.add(new LineItem(Type.REMOVED, fileLines1.get(0)));
                fileLines1.remove(0);
                check = !check;
            } else
            {
                lines.add(new LineItem(Type.ADDED, fileLines2.get(0)));
                fileLines2.remove(0);
            }
        }

        if (fileLines1.size() > 0)
        {
            lines.add(new LineItem(Type.REMOVED, fileLines1.get(0)));
        } else if (fileLines2.size() > 0)
        {
            lines.add(new LineItem(Type.ADDED, fileLines2.get(0)));
        }

        for (LineItem item : lines)
        {
            System.out.println(item.type + " " + item.line);
        }
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
