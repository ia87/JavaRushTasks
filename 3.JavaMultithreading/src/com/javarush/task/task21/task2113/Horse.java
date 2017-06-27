package com.javarush.task.task21.task2113;

/**
 * Created by ac on 27.06.2017.
 */
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }
    public void move(){
        distance+= Math.random()*speed;
    }
    public void print(){
        for (int i = 0; i < (int) distance; i++) {
            System.out.print(".");
        }

        System.out.println(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
