package PhilosophersForks;

public class Philosopher1 extends Thread {
    private int id;
    //private int numMeals;
    Fork leftFork, rightFork;

    public Philosopher1(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;

    }

    public void think() {
        //implement think behavior
        System.out.println("Philosopher " + id + " is thinking");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void eat() {
        //implement eat behavior
        System.out.println("Philosopher " + id + " is eating");
        //numMeals++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //return numMeals;
    }

    @Override
    public void run() {
        while (true) {
            think();
            //DiningMonitor.pickUpForks(id);
            eat();
            //DiningMonitor.putDownForks(id);
        }
    }
}
