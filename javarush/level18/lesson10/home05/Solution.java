package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        RandomAccessFile randomAccessFile1 = new RandomAccessFile(fileName1, "r");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(fileName2, "rw");

        String tmp;
        while (true){
            if ((tmp = randomAccessFile1.readLine()) == null)
                break;
            String[] split = tmp.split(" ");
            for (String value : split){
                int i = (int) Math.round(Double.parseDouble(value));
                randomAccessFile2.writeBytes(String.valueOf(i) + " ");
            }
        }
        randomAccessFile1.close();
        randomAccessFile2.close();
    }
}
