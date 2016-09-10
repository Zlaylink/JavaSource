package com.javarush.test.level26.lesson08.task01;

/* Вежливость - это искусственно созданное хорошее настроение.
В классе Solution создайте public static класс IntegerHolder.
IntegerHolder должен быть для типа int, быть нитебезопасным и изменяемым.
В этом классе должны быть два public метода get и set
*/
public class Solution {

    public static class IntegerHolder{
        private int i;

        synchronized public int get()
        {
            return i;
        }

        synchronized public void set(int i)
        {
            this.i = i;
        }
    }

    public static void main(String[] args) {
    }
}
