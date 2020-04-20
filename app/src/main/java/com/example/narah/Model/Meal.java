package com.example.narah.Model;

import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Meal extends AppCompatActivity {
    private String name="";
    private String branch="";
    private double  price=0;
    private ImageView img=new ImageView(this);
    private Button button=new Button(this);

    public Meal() {
    }

    public Meal(String name, String branch, double price) {
        this.name = name;
        this.branch = branch;
        this.price = price;
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

    public ImageView getImg() {
        return img;
    }

    public Button getButton() {
        return button;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", price=" + price +
                '}';
    }
}
