package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Zlayl on 13.08.2016.
 */
public class Horse
{
    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void move(){
        distance += speed*Math.random();
    }

    public void print(){
        for (int road = 0; road < (int)distance; road++){
            System.out.print(".");
        }
        System.out.println(name);
    }

    String name;
    double speed;
    double distance;
}
