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

import com.example.narah.Model.Narah;
import com.google.gson.Gson;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
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
        return super.onOptionsItemSelected(item);
    }

    public void txv_pizaaList(View view) {
        Intent intent=new Intent(MainMenu.this,SecondaryMenu.class);
        intent.putExtra("type","Pizza");
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
}
