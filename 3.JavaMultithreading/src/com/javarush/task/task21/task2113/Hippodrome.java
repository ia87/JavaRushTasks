package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ac on 27.06.2017.
 */
public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException{
        for (int i = 1; i <= 100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    };
    public void move(){
        horses.forEach(Horse::move);
    }
    public void print(){
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse horse = null;
        double maxDistance = 0;
        for (Horse h : horses) {
            if( h.getDistance() > maxDistance) {
                maxDistance = h.getDistance();
                horse = h;
            }
        }
        return horse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Horse1", 3, 0));
        game.getHorses().add(new Horse("Horse2", 3, 0));
        game.getHorses().add(new Horse("Horse3", 3, 0));
        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        game.printWinner();
    }
}
