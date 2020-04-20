package com.example.narah.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private int id=0;
    private double totalPrice=0;
    private Personal customer=new Personal();
    private ArrayList<OrderMap> list=new ArrayList<>();

    public Order(){
        id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Personal getCustomer() {
        return customer;
    }

    public void setCustomer(Personal customer) {
        this.customer = customer;
    }

//    public HashMap< Meal ,Integer> getList() {
//        return list;
//    }
//
//    public void setList(HashMap< Meal ,Integer> list) {
//        this.list = list;
//    }



    public void addMeal(Meal meal){
        for(int i=0;i<list.size();i++){
            Meal listmeal=list.get(i).getMeal();
            if(listmeal.getName().equals(meal.getName())){
                list.get(i).IncreaseNumberOfMeals();
                return;
            }
        }
        list.add(new OrderMap(meal,1));
    }

    public ArrayList<OrderMap> getList() {
        return list;
    }

    public void setList(ArrayList<OrderMap> list) {
        this.list = list;
    }
//    public void addMealAgain(Meal meal){
//        int n=list.get(meal);
//        list.put(meal,++n);
//    }
}
