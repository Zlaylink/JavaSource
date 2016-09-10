package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")){
            new ReadThread(fileName).start();
        }
        System.out.println(resultMap);
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run(){
            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileName);

                int[] repeats = new int[255];
                int maxByte = Byte.MIN_VALUE;
                int max = Byte.MIN_VALUE;

                while (fileInputStream.available() > 0){
                    repeats[fileInputStream.read()]++;
                }

                for (int i = 0; i < repeats.length; i++){
                    if (repeats[i] > maxByte){
                        maxByte = repeats[i];
                        max = i;
                    }
                }
                synchronized (resultMap)
                {
                    resultMap.put(fileName, max);
                }
                fileInputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
