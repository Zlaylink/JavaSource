package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg = new Zerg();
        zerg.name = "Zerg";
        Zerg zerg1 = new Zerg();
        zerg1.name = "Zerg1";
        Zerg zerg2 = new Zerg();
        zerg.name = "Zerg2";
        Zerg zerg3 = new Zerg();
        zerg1.name = "Zerg3";
        Zerg zerg4 = new Zerg();
        zerg.name = "Zerg4";
        Zerg zerg5 = new Zerg();
        zerg1.name = "Zerg5";
        Zerg zer6 = new Zerg();
        zerg.name = "Zerg6";
        Zerg zerg7 = new Zerg();
        zerg1.name = "Zerg7";
        Zerg zerg8 = new Zerg();
        zerg.name = "Zerg8";
        Zerg zerg9 = new Zerg();
        zerg1.name = "Zerg9";


        Protos protos = new Protos();
        protos.name = "Protos";
        Protos protos1 = new Protos();
        protos1.name = "Protos1";
        Protos protos2 = new Protos();
        protos2.name = "Protos2";
        Protos protos3 = new Protos();
        protos3.name = "Protos3";
        Protos protos4 = new Protos();
        protos4.name = "Protos4";

        Terran terran = new Terran();
        terran.name = "Terran";
        Terran terran1 = new Terran();
        terran1.name = "Terran1";
        Terran terran2 = new Terran();
        terran2.name = "Terran2";
        Terran terran3 = new Terran();
        terran3.name = "Terran3";
        Terran terran4 = new Terran();
        terran4.name = "Terran4";
        Terran terran5 = new Terran();
        terran5.name = "Terran5";
        Terran terran6 = new Terran();
        terran6.name = "Terran6";
        Terran terran7 = new Terran();
        terran7.name = "Terran7";
        Terran terran8 = new Terran();
        terran8.name = "Terran8";
        Terran terran9 = new Terran();
        terran9.name = "Terran9";
        Terran terran10 = new Terran();
        terran10.name = "Terran10";
        Terran terran11 = new Terran();
        terran11.name = "Terran11";

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}