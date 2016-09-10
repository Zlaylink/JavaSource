package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (params == null || params.isEmpty()) return sb;
        for (Map.Entry<String, String> pair : params.entrySet()){
            if (pair.getValue() != null){
                if (sb.toString().isEmpty())
                    sb.append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
                else
                    sb.append(" and ").append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
            }
        }
        return sb;
    }
    /*public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", "Moscow");
        map.put("age", null);
        map.put(null, null);
        System.out.println(getCondition(map));
    }*/
}
