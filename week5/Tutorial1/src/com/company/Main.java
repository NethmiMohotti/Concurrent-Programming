package com.company;

public class Main {

    public static void main(String[] args)  {
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup");
        Thread thread1 = new Thread(myThreadGroup, new MyTask(), "Thread1");
        Thread thread2 = new Thread(myThreadGroup, new MyTask(), "Thread2");
        Thread thread3 = new Thread(myThreadGroup, new MyTask(), "Thread3");
        Thread thread4 = new Thread(myThreadGroup, new MyTask(), "Thread4");
        Thread thread5 = new Thread(myThreadGroup, new MyTask(), "Thread5");
        Thread threadMain = new Thread(new MyTask(), "Thread");
        // Create more threads and assign different priorities.
        thread3.setPriority(6);
        thread1.setPriority(5); // Set thread1's priority to 5.
        thread2.setPriority(3);
        thread3.setPriority(2);
        thread4.setPriority(7);
        thread5.setPriority(9);
        // Set priorities for other threads.


        threadMain.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        // Start other threads.
        // Observe thread scheduling behavior here.
    }
}