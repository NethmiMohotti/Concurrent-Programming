package com.company;

public class Mother1 implements Runnable{
    Plate plate;

    public Mother1(Plate plate) {
        this.plate = plate;
    }

    public void run() {
        for (int i=0; i<10; i++) {
            plate.serveFood(String.valueOf(new Food("Rice")));
        }

    }
}
