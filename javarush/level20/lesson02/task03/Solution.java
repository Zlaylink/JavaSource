package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties properties1 = new Properties();

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        load(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for (Map.Entry<String, String> pair : properties.entrySet()){
            properties1.put(pair.getKey(), pair.getValue());
        }
        properties1.store(outputStream, null);
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        properties1.load(inputStream);
        for (String name : properties1.stringPropertyNames()){
            properties.put(name, properties1.getProperty(name));
        }
    }
}
