package com.example.narah.Model;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.narah.SecondaryMenu;

public class Meal extends AppCompatActivity {
    private String name="";
    private String branch="";
    private double  price=0;
    int id=0;
//    private ImageView img=new ImageView(this);
//    private Button button;

    public Meal() {
     //   button.setText("add to cart");
        id++;
    }

    public Meal(String name, String branch, double price) {
        this.name = name;
        this.branch = branch;
        this.price = price;
        id++;
       // button.setText("add to cart");

//        button.setOnClickListener(new View.OnClickListener() {
//            int counter=0;
//            Order order;
//            public void onClick(View v) {
//                // Do something in response to button click
//                counter++;
//                if(counter==1){
//                  order  =new Order();
//                }else{
//                    order.addMeal(Meal.this);
//                }
//
//            }
//        });


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getPrice() {
        return price;
    }

//    public ImageView getImg() {
//        return img;
//    }

//    public Button getButton() {
//        return button;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public void setImg(ImageView img) {
//        this.img = img;
//    }

//    public void setButton(Button button) {
//        this.button = button;
//    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", price=" + price +
                '}';
    }
}
