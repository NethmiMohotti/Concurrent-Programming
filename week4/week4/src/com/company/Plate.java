package com.company;

public class Plate {

    public boolean foodAvailable = false;
    public Food food;

    //serve food
    public synchronized void serveFood(String serveFood){
        while(foodAvailable) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //if the tread is coming here that means the food is not available
        System.out.println("Serving: " + food.getFoodItem());
        setFoodAvailable(true);
        System.out.println(Thread.currentThread().getName()+" produced "+food);
        notifyAll();
    }

    //consume food
    public synchronized void consumeFood(Food food) {
        while (!foodAvailable) {
            try {
                System.out.println("Food is available, Son: waiting...");
                wait();
                System.out.println("Food is consumed,Son: Out of waiting...");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Consuming: " + food.getFoodItem());
        setFoodAvailable(false);
        notifyAll();
    }

    public boolean isFoodAvailable() {
        return foodAvailable;
    }

    public Food getFood() {
        return food;
    }

    public void setFoodAvailable(boolean foodAvailable) {
        this.foodAvailable = foodAvailable;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
