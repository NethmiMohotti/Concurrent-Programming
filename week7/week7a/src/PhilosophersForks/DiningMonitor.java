    package PhilosophersForks;

    public class DiningMonitor { Fork[] forks;



        public DiningMonitor(int numForks) {

            forks = new Fork[numForks];

            for (int i = 0; i < numForks; i++) {

                forks[i] = new Fork(i);

            }

        }



        public synchronized void pickUpForks(int philosopherId) {

            int leftForkIndex = philosopherId;

            int rightForkIndex = (philosopherId + 1) % forks.length;



            while (!tryPickUpFork(leftForkIndex) || !tryPickUpFork(rightForkIndex)) {
                // Wait for forks to be available
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }



        public synchronized void putDownForks(int philosopherId) {
            int leftForkIndex = philosopherId;
            int rightForkIndex = (philosopherId + 1) % forks.length;
            forks[leftForkIndex].id = 0;
            forks[rightForkIndex].id = 0;
            notifyAll();
        }

        private boolean tryPickUpFork(int forkIndex) {
            if (forks[forkIndex].id == 0) {
                forks[forkIndex].id = 1;
                return true;
            } else {
                return false;
            }
        }
    }
