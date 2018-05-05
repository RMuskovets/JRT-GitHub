package com.javarush.task.task25.task2502;

import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public  enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<String> wheels;

        public Car() {
            String y[] = loadWheelNamesFromDB();
            if (y.length == 0) throw new IllegalArgumentException();
            for (String s : y) {
                wheels.add(s);
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
