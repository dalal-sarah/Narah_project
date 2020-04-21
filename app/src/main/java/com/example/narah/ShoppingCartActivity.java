package com.example.narah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.narah.Model.Meal;
import com.example.narah.Model.Order;

public class ShoppingCartActivity extends AppCompatActivity {

    //
//    LinearLayout lyitems=findViewById(R.id.lyitems);
//    LinearLayout lytotal=findViewById(R.id.lytotal);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
    }


    @Override
    protected void onStart() {
        LinearLayout lyroot = findViewById(R.id.lyrootcart);
        super.onStart();
        Order order = MainActivity.order;
        int size = order.getList().size();
        for (int i = 0; i < size; i++) {
            LinearLayout lyitem = new LinearLayout(this);
            lyitem.setOrientation(LinearLayout.VERTICAL);
            Meal meal = order.getList().get(i).getMeal();
            Log.println(Log.INFO,"",meal.getName());
            String mealname = meal.getName();
            double mealprice = meal.getPrice();
            int nummeal = order.getList().get(i).getCounter();
            TextView txname = new TextView(this);
            txname.setText(mealname);
            TextView txprice = new TextView(this);
            txprice.setText("" + mealprice);
            TextView txnum = new TextView(this);
            txnum.setText("" + nummeal);
            lyitem.addView(txname);
            lyitem.addView(txprice);
            lyitem.addView(txnum);
            lyroot.addView(lyitem);
        }

    }
}
//}
