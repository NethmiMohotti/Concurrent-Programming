package com.company;

public class Numbers implements Runnable {
    private String name;

    public Numbers(String name) {
        this.name = name;
        //creating a new thread that is where it comes into NEW state
        Thread thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(name + " thread is now in state: " + Thread.currentThread().getState());

        // NEW to RUNNABLE
        System.out.println(name + " thread is now in state: " + Thread.currentThread().getState());
        // RUNNABLE to BLOCKED and vice versa
        synchronized (this) {
            try {
                System.out.println(name + " thread is now in state: " + Thread.currentThread().getState());
                wait(1000);
                System.out.println(name + " thread is now in state: " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*@Override
    public void run() {
        System.out.println(name + " thread is now in state: " + Thread.currentThread().getState());

        // NEW to RUNNABLE
        System.out.println(name + " thread is now in state: " + Thread.currentThread().getState());
        // RUNNABLE to BLOCKED and vice versa
        synchronized (this) {
            try {
                System.out.println(name + " thread is now in state: " + Thread.currentThread().getState());
                wait(1000);
                System.out.println(name + " thread is now in state: " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // RUNNABLE to WAITING and vice versa
        synchronized (this) {
            try {
                System.out.println(name + " is now in state: " + Thread.currentThread().getState());
                wait();
                System.out.println(name + " is now in state: " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // RUNNABLE to TIMED_WAITING and vice versa
        synchronized (this) {
            try {
                System.out.println(name + " is now in state: " + Thread.currentThread().getState());
                wait(1000);
                System.out.println(name + " is now in state: " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Interrupt a thread using interrupt()
        synchronized (this) {
            try {
                System.out.println(name + " is now in state: " + Thread.currentThread().getState());
                wait(1000);
                System.out.println(name + " is now in state: " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
}
