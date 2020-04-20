package com.example.narah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.narah.Model.Meal;
import com.example.narah.Model.Order;
import com.example.narah.Model.Type;
import com.example.narah.personal_information;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//this is from saja
    private Button btg_onclick ;
    public static int counter=0;
    public static Order order=new Order();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btg_onclick=findViewById(R.id.btg_onclick);

    }


    public void btg(View view) {
        Intent intent= new Intent(MainActivity.this,MainMenu.class);
          startActivity(intent);

    }

}
