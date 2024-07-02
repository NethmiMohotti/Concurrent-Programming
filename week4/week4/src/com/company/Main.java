package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Plate plate = new Plate();
        Child child = new Child(plate);
        Mother1 m1 = new Mother1(plate);
        Mother2 m2 = new Mother2(plate);

        Thread motherThread = new Thread(m1);
        Thread childThread = new Thread(child);
        Thread motherThread2 = new Thread(m2);

        motherThread.start();
        childThread.start();
        motherThread2.start();
    }
}
