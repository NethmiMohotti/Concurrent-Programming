package com.company;

public class Child implements Runnable{
    Plate plate;

    public Child(Plate plate) {
        this.plate = plate;
    }

    public void run() {
        for (int i = 0; i<5; i++) {
            plate.consumeFood(new Food("Rice"));
        }
    }
}
