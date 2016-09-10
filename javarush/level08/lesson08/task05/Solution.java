package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Denis");
        map.put("2", "Dima");
        map.put("3", "Vasya");
        map.put("4", "Denis");
        map.put("5", "Dima");
        map.put("6", "Den");
        map.put("7", "Kolya");
        map.put("8", "Vlya");
        map.put("9", "Nikita");
        map.put("10", "Venya");
        return (HashMap<String, String>)map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        ArrayList<String> values = new ArrayList<String>(map.values());
        for(String a: values){
            int count = 0;
            for(int i =0; i < values.size(); i++){
                if(a.equals(values.get(i))){
                    count++;
                }
                if(count>1){
                    removeItemFromMapByValue(map,a);
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
