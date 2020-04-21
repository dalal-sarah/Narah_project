package com.example.narah.Model;

public class OrderMap {
    Meal meal;
    int counter=0;
    int id=0;
    static int num=0;

    public OrderMap() {
        id++;
    }


    public OrderMap(Meal meal, int counter ) {
        this.meal = meal;
        this.counter = counter;
        this.id=num;
        num++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
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
    public boolean DecreaseNumberOfMeals(){
        counter--;
        if(counter<=0){
            return false;
        }else{
            return true;
        }
    }
}
