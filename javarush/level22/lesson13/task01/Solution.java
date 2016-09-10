package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

     public static void main(String[] args){
        String[] result = getTokens("level22.lesson13.task01", ".");
        for (String s : result)
            System.out.println(s);
    }

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> buffer = new ArrayList<>();
        while(tokenizer.hasMoreTokens()){
            buffer.add(tokenizer.nextToken());
        }
        return buffer.toArray(new String[buffer.size()]);
    }
}
