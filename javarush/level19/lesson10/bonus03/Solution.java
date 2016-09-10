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

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bf.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        bf.close();

        String fileLines;
        StringBuilder sb = new StringBuilder();
        while ((fileLines = reader.readLine()) != null){
            sb.append(fileLines);
        }
        String buffer = sb.toString().replaceAll("\r\n", "");
        reader.close();

        ArrayList<String> output = new ArrayList<>();
        ArrayDeque<Integer> start = new ArrayDeque<>();
        TreeMap<Integer, Integer> position = new TreeMap<>();

        Pattern tag = Pattern.compile("(<" + args[0] + ")|(</" + args[0] + ">)");
        Matcher tagMatcher = tag.matcher(buffer);

        while (tagMatcher.find()){
            if (("<" + args[0]).equals(tagMatcher.group())){
                start.push(tagMatcher.start());
            }
            if (("</" + args[0] + ">").equals(tagMatcher.group())){
                position.put(start.pop(), tagMatcher.end());
            }
        }

        for (Map.Entry<Integer, Integer> value : position.entrySet()){
            output.add(buffer.substring(value.getKey(), value.getValue()));
        }

        for (String outputs : output){
            System.out.println(outputs);
        }
    }
}
