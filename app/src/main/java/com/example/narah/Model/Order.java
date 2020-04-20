package com.example.narah.Model;

import java.util.HashMap;

public class Order {
    private int id=0;
    private double totalPrice=0;
    private Personal customer=new Personal();
    private HashMap<Meal,Integer> list=new HashMap<>();

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

    public HashMap< Meal ,Integer> getList() {
        return list;
    }

    public void setList(HashMap< Meal ,Integer> list) {
        this.list = list;
    }

    public void addMeal(Meal meal){
        list.put(meal,1);
    }
}
