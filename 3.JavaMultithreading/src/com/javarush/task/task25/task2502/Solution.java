package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception{
            //init wheels here
            wheels = new ArrayList<>();
            String[] ww = loadWheelNamesFromDB();
            for (String s : ww) {
                wheels.add(Wheel.valueOf(s));
            }
            if (wheels.size()!=4) throw new Exception();
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT", "123"};
        }
    }

    public static void main(String[] args) {
//        Car car = new Car();
    }
}
