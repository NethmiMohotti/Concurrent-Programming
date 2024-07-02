package com.company;

public class Mother2 implements Runnable{
    Plate plate;

    public Mother2(Plate plate) {
        this.plate = plate;
    }

    public void run() {
        for (int i=0; i<10; i++) {
            plate.serveFood(String.valueOf(new Food("Rice")));
        }

    }
}
