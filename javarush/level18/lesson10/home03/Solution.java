package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
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
        reader.close();
        FileInputStream fileInputStream0 = new FileInputStream(file2);
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        FileInputStream fileInputStream1 = new FileInputStream(file3);

        while (fileInputStream0.available() > 0){
            int i = fileInputStream0.read();
            fileOutputStream.write(i);
        }
        while(fileInputStream1.available() > 0){
            int i = fileInputStream1.read();
            fileOutputStream.write(i);
        }
        fileInputStream0.close();
        fileInputStream1.close();
        fileOutputStream.close();
    }
}
