package com.example.narah;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.narah.Model.Meal;
import com.example.narah.Model.Order;
import com.example.narah.Model.Type;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SecondaryMenu extends AppCompatActivity implements View.OnClickListener {

    ScrollView scrollview;
    LinearLayout lyroot;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_menu);
        scrollview=findViewById(R.id.ScrollView);
        lyroot=findViewById(R.id.lyroot);
        lyroot.setOrientation(LinearLayout.VERTICAL);
        List list=new ArrayList();
        //addComponentsToSecondaryMenu(lyroot,list);

//        scrollview.addView(lyroot);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        String msg="";
        if(id == R.id.shoppingCartIcon){

            Intent intent=new Intent(SecondaryMenu.this,ShoppingCartActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    List<Meal> list=new ArrayList();
    @Override
    protected void onStart() {
        super.onStart();
        String s=getIntent().getStringExtra("type");



        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson=new Gson();
        String menustring=prefs.getString("MenuData","");
        Type[] types=gson.fromJson(menustring, Type[].class);

        for(int i=0;i<types.length;i++){
            Type type=types[i];
            Log.println(Log.INFO,"",type.getName());
            if(type.getName().equals(s)){
                addComponentsToSecondaryMenu(lyroot,type.getMeals());
            }
        }

        if(s.equals("Pizza")){

        }else if(s.equals("Pastries")){

        }else if(s.equals("Calzone")){

        }else if(s.equals("Egg Pastries")){

        }else if(s.equals("Extras")){

        }else if(s.equals("Dessert")){

        }

    }



    public void addComponentsToSecondaryMenu(LinearLayout ly, List<Meal> meals){


        Button [] buttons=new Button[meals.size()];
        for (int i=0;i<buttons.length;i++){
            buttons[i]=new Button(this);
            buttons[i].setOnClickListener(this);
            buttons[i].setId(i);
        }
        for(int i=0;i<meals.size();i++) {
            Meal meal=(Meal)meals.get(i);
            list.add(meal);
            //meal.setButton(buttons[i]);
            LinearLayout ly1 = new LinearLayout(new ContextThemeWrapper(this,R.style.SecondaryMenuComponents));
            ly1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout ly2 = new LinearLayout(this);
            ly2.setOrientation(LinearLayout.VERTICAL);
            TextView txname = new TextView(this);
            txname.setText(meal.getName());
            ly2.addView(txname);
            TextView txprice = new TextView(this);
            txprice.setText(meal.getPrice()+" $");
            ly2.addView(txprice);
            TextView txbranch = new TextView(this);
            txbranch.setText(meal.getBranch());
            ly2.addView(txbranch);
            Button add = buttons[i];
            add.setText("add to cart");
            ly2.addView(add);

            ly1.addView(ly2);

            ImageView imgview = new ImageView(this);
            imgview.setImageResource(R.drawable.eggandhotdogpastriess);
            //imgview.setMaxWidth(110dp);
            ly1.addView(imgview);
            ly.addView(ly1);
        }


    }

    public void addComponentToSecondaryMenu(){
        LinearLayout ly1 = new LinearLayout(this);
        ly1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5,5,5,5);
        ly1.setBackgroundColor(Color.BLUE);
        LinearLayout ly2 = new LinearLayout(this);
        ly2.setOrientation(LinearLayout.VERTICAL);
        TextView txname = new TextView(this);
        txname.setText("name");
        ly2.addView(txname);
        TextView txprice = new TextView(this);
        txprice.setText("price");
        ly2.addView(txprice);
        TextView txbranch = new TextView(this);
        txbranch.setText("branch");
        ly2.addView(txbranch);
        Button add = new Button(this);
        add.setText("add to chart");
        ly2.addView(add);

        ly1.addView(ly2);
        ImageView imgview = new ImageView(this);
        imgview.setImageResource(R.drawable.calzone);
        ly1.addView(imgview);
    }

    @Override
    public void onClick(View v) {
        MainActivity.counter++;
        int counter=MainActivity.counter;
        Order order=MainActivity.order;
            order.addMeal(list.get(v.getId()));
        Log.println(Log.INFO,"","button clicked");
    }
}
