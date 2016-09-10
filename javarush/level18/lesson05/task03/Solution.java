package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);

        int fileByteCount = fileInputStream.available() / 2;

        while (fileInputStream.available() > fileByteCount) {
            fileOutputStream1.write(fileInputStream.read());
        }
        while (fileInputStream.available() > 0) {
            fileOutputStream2.write(fileInputStream.read());
        }

        fileOutputStream1.close();
        fileOutputStream2.close();
        fileInputStream.close();
        reader.close();
    }
}

