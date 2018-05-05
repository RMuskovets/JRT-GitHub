package com.javarush.task.task29.task2909.car;

public class Truck extends Car {

    public Truck(int nop) {
        super(TRUCK, nop);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
