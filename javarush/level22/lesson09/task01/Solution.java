package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        while (reader.ready()){
            sb.append((char)reader.read());
        }
        reader.close();
        String[] buffer = sb.toString().replaceAll("\\n", " ").split(" ");
        for (int i = 0; i < buffer.length; i++){
            for (int j = i + 1; j < buffer.length - 1; j++){
                if (buffer[i].equals(buffer[j]) || buffer[i].equals(reverse(buffer[j]))){
                    Pair pair = new Pair();
                    pair.first = buffer[i];
                    pair.second = buffer[j];
                    result.add(pair);
                }
            }
        }
        for (Pair pair : result)
            System.out.println(String.format("%s %s", pair.first, pair.second));
    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
