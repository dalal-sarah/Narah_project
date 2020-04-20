package com.example.narah.Model;

public class OrderMap {
    Meal meal;
    int counter=0;

    public OrderMap() {
    }

    public OrderMap(Meal meal, int counter) {
        this.meal = meal;
        this.counter = counter;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
    public void IncreaseNumberOfMeals(){
        counter++;
    }
}
