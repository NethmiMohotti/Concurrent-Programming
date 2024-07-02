package PhilosophersForks;

public class Philosopher extends Thread{
    private final Object leftFork;
    private final Object rightFork;



    public Philosopher(int id, Object leftFork, Object rightFork) {
        // Set the name of the thread for easier identification
        super("Philosopher " + id);
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }



    @Override
    public void run() {
        while (true) {
            think();
            eat();
        }
    }



    private void think() {
        System.out.println(getName() + " is thinking.");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



    private void eat() {
        System.out.println(getName() + " is hungry and trying to pick up forks.");
        synchronized (leftFork) {
            System.out.println(getName() + " picked up the left fork.");
            synchronized (rightFork) {
                System.out.println(getName() + " picked up the right fork and is now eating.");
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(getName() + " finished eating and put down the right fork.");
            }
            System.out.println(getName() + " put down the left fork.");
        }
    }
}
