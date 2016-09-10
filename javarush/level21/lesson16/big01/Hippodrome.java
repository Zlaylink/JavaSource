package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Zlayl on 13.08.2016.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("John", 3, 0);
        Horse horse2 = new Horse("Jacy", 3, 0);
        Horse horse3 = new Horse("Bulby", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }

    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void move()
    {
        for (Horse horse : horses)
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : horses)
        {
            horse.print();
        }
        for (int i = 0; i < 3; i++)
        {
            System.out.println();
        }
    }

    public Horse getWinner()
    {
        Horse winner = null;
        double maxDistance = 0;
        for (Horse horse : horses)
        {
            if (horse.getDistance() > 0)
            {
                maxDistance = horse.getDistance();
                winner = horse;
            }

        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
