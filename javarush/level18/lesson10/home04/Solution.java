package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);

        byte[] file1Data = new byte[fileInputStream1.available()];
        byte[] file2Data = new byte[fileInputStream2.available()];

        fileInputStream1.read(file1Data);
        fileInputStream2.read(file2Data);

        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1, false);
        fileOutputStream1.write(file2Data);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName1, true);
        fileOutputStream2.write(file1Data);

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream1.close();
        fileOutputStream2.close();

    }
}
