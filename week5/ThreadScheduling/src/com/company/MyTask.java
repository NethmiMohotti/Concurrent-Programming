package com.company;
//https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
class MyTask implements Runnable {

    private static int sharedCounter = 0;

    @Override
    public void run() {
        // two thread groups will be cfreated . cuz t1s run and t3s run is the same as they have the same body
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup2");
        System.out.println("Thread group 2 name: "+ myThreadGroup.getName());
        System.out.println("Thread group 2 parent: "+ myThreadGroup.getParent().getName());
        for (int i = 0; i < 5; i++) {
            synchronized (MyTask.class) {
                sharedCounter++;
                System.out.println(Thread.currentThread().getName() + " - Counter: " + sharedCounter);
            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

    }

    }

}