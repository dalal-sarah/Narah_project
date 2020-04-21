package com.example.narah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.narah.Model.Meal;
import com.example.narah.Model.Narah;
import com.example.narah.Model.Type;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        MenuData();
    }

    public void btnSave_onClick(View view) {
        Narah[] narah = new Narah[20];

        narah[0]= new Narah("Pizza","small");
        narah[1]= new Narah("Pizza","medium");
        narah[2]= new Narah("Pizza","Large");
        narah[3]= new Narah("Pizza","Stuffed Crust");
        narah[4]= new Narah("Egg Pastries","Plain Eggs");
        narah[5]= new Narah("Egg Pastries","Eggs and Cheese");
        narah[6]= new Narah("Egg Pastries","Eggs and Sausage");
        narah[7]= new Narah("Egg Pastries","Eggs and Hotdogs");
        narah[8]= new Narah("Calzone","chicken and Vegetables");
        narah[9]= new Narah("Calzone"," Spicy chicken ");
        narah[10]= new Narah("Pastries","Meshulash");
        narah[11]= new Narah("Pastries","Cheese and Olive");
        narah[12]= new Narah("Pastries","Bulgarian");
        narah[13]= new Narah("Pastries","Za`atar Manakish");
        narah[14]= new Narah("Pastries","All type of Cheese");
        narah[15]= new Narah("Pastries","Rayaneh");
        narah[16]= new Narah("Dessert","Baked Nutella");
        narah[17]= new Narah("Dessert","Baked Lotus");
        narah[18]= new Narah("Dessert","Apple Pie");
        narah[19]= new Narah("Extras","Fries");

        ///
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefs.edit();
        Gson gson = new Gson();
        String narahString = gson.toJson(narah);
        editor.putString("123",narahString);
        editor.commit();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        String msg="";
        if(id == R.id.shoppingCartIcon){
            Intent intent=new Intent(MainMenu.this,ShoppingCartActivity.class);
            startActivity(intent);
        }
        return true;
    }

    public void txv_pizaaList(View view) {
        Intent intent=new Intent(MainMenu.this,SecondaryMenu.class);
        intent.putExtra("type","pizza");
        startActivity(intent);

    }

    public void txv_pastriesList(View view) {
        Intent intent=new Intent(MainMenu.this,SecondaryMenu.class);
        intent.putExtra("type","Pastries");
        startActivity(intent);
    }

    public void txv_calzoneList(View view) {
        Intent intent=new Intent(MainMenu.this,SecondaryMenu.class);
        intent.putExtra("type","Calzone");
        startActivity(intent);
    }

    public void txv_eggList(View view) {
        Intent intent=new Intent(MainMenu.this,SecondaryMenu.class);
        intent.putExtra("type","Egg Pastries");
        startActivity(intent);
    }

    public void txt_friesList(View view) {
        Intent intent=new Intent(MainMenu.this,SecondaryMenu.class);
        intent.putExtra("type","Extras");
        startActivity(intent);
    }

    public void txv_dessertList(View view) {
        Intent intent=new Intent(MainMenu.this,SecondaryMenu.class);
        intent.putExtra("type","Dessert");
        startActivity(intent);
    }
    public void MenuData() {
        ArrayList<Meal> meals = new ArrayList<>();
        Meal meal1 = new Meal("small", "WADI AL JOZ , Biet Sfafa", 13);
        meal1.setImgId(R.drawable.pizza);
        Meal meal2 = new Meal("meduim", "WADI AL JOZ , Biet Sfafa", 35);
        meal2.setImgId(R.drawable.pizza);
        Meal meal3 = new Meal("large", "WADI AL JOZ , Biet Sfafa", 60);
        meal3.setImgId(R.drawable.pizza);
        Meal meal4 = new Meal("Stuffed Crust", "WADI AL JOZ , Biet Sfafa", 50);
        meal4.setImgId(R.drawable.pizzastuffedcrust);
        Meal meal5 = new Meal(" Plain Eggs", "WADI AL JOZ , Biet Sfafa", 13);
        meal5.setImgId(R.drawable.plainegg);
        Meal meal7 = new Meal("Eggs and Sausage", " Biet Sfafa", 13);
        meal7.setImgId(R.drawable.eggsandsausage);
        Meal meal8 = new Meal("Eggs and Hotdoogs", " Biet Sfafa", 13);
        meal8.setImgId(R.drawable.eggandhotdogpastriess);
        Meal meal9 = new Meal("Chicken and Vegetables", " Biet Sfafa", 15);
        meal9.setImgId(R.drawable.calzonechickenandvegetable);
        Meal meal10 = new Meal("spicy Chicken", " Biet Sfafa", 20);
        meal10.setImgId(R.drawable.calzonespicychicken);
        Meal meal11 = new Meal("Meshulash", " Biet Sfafa", 12);
        meal11.setImgId(R.drawable.meshulash);
        Meal meal12 = new Meal("Cheese and Olive", "WADI AL JOZ", 10);
        meal12.setImgId(R.drawable.eggsandcheese);
        Meal meal13 = new Meal("Bulgarian", "WADI AL JOZ", 11);
        meal13.setImgId(R.drawable.bulgarian);
        Meal meal14 = new Meal("All Type OF Cheese", "WADI AL JOZ", 13);
        meal14.setImgId(R.drawable.alltypeofcheese);
        Meal meal15 = new Meal("Za`atar Manakishb", "WADI AL JOZ , Biet Sfafa", 5);
        meal15.setImgId(R.drawable.zaatarman);
        Meal meal16 = new Meal("Rayaneh", "WADI AL JOZ , Biet Sfafa", 15);
        meal16.setImgId(R.drawable.rayaneh);
        Meal meal17 = new Meal("Nutella", "WADI AL JOZ , Biet Sfafa", 25);
        meal17.setImgId(R.drawable.dessert);
        Meal meal18 = new Meal("Lotus", "WADI AL JOZ , Biet Sfafa", 25);
        meal18.setImgId(R.drawable.lotus);
        Meal meal19 = new Meal("Apple Pie", "WADI AL JOZ , Biet Sfafa", 25);
        meal19.setImgId(R.drawable.applepie);
        Meal meal20 = new Meal("Fries", "WADI AL JOZ , Biet Sfafa", 8);
        meal20.setImgId(R.drawable.extra);
        Type type1 = new Type("pizza");
        type1.addMeal(meal1);
        type1.addMeal(meal2);
        type1.addMeal(meal3);
        type1.addMeal(meal4);
        Type type2 = new Type("Egg Pastries");
        type2.addMeal(meal5);
        type2.addMeal(meal7);
        type2.addMeal(meal8);
        Type type3=new Type("Calzone");
        type3.addMeal(meal9);
        type3.addMeal(meal10);
        Type type4=new Type("Pastries");
        type4.addMeal(meal11);
        type4.addMeal(meal12);
        type4.addMeal(meal13);
        type4.addMeal(meal14);
        type4.addMeal(meal15);
        type4.addMeal(meal16);
        Type type5=new Type("Dessert");
        type5.addMeal(meal17);
        type5.addMeal(meal18);
        type5.addMeal(meal19);
        Type type6=new Type("Extras");
        type6.addMeal(meal20);
        Type [] types=new Type[6];
        types[0]=type1;
        types[1]=type2;
        types[2]=type3;
        types[3]=type4;
        types[4]=type5;
        types[5]=type6;


                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor=prefs.edit();
                Gson gson = new Gson();
                String narahString = gson.toJson(types);
                editor.putString("MenuData",narahString);
                editor.commit();
    }
}
