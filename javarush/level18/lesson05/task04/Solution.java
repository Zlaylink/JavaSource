package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(new File(reader.readLine()));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(reader.readLine()));

        byte[] result = new byte[fileInputStream.available()];
        fileInputStream.read(result);

        for(int i = result.length - 1; i >= 0; i--)
            fileOutputStream.write(result[i]);
        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
