package com.example.narah.Model;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Type extends AppCompatActivity {
    String name="";
//    ImageView imgv=new ImageView(this);
    List<Meal> meals =new ArrayList<>();

    public Type() {
    }

    public Type(String name, List<Meal> meals) {
        this.name = name;
        this.meals = meals;
    }

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ImageView getImgv() {
//        return imgv;
//    }
//
//    public void setImgv(ImageView imgv) {
//        this.imgv = imgv;
//    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public void addMeal(Meal meal){
        meals.add(meal);

    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                ", meals=" + meals +
                '}';
    }
}
