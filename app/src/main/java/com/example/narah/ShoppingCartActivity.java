package com.example.narah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.narah.Model.Meal;
import com.example.narah.Model.Order;
import com.example.narah.Model.OrderMap;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener{

    //
//    LinearLayout lyitems=findViewById(R.id.lyitems);
//    LinearLayout lytotal=findViewById(R.id.lytotal);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
    }


    Order order = MainActivity.order;

    @Override
    protected void onStart() {
        super.onStart();
        LinearLayout lyrootcart = findViewById(R.id.lyrootcart);
        TableLayout tbShoppingCart=findViewById( R.id.tbShoppingCart );


        int size = order.getList().size();
        Button [] buttons=new Button[size];

        for (int i = 0; i < size; i++) {
            buttons[i]=new Button(this);
            buttons[i].setText("delete");
            TableRow tbr=new TableRow(this);
            LinearLayout lyitem = new LinearLayout(this);
            lyitem.setOrientation(LinearLayout.HORIZONTAL);
            Meal meal = order.getList().get(i).getMeal();
            Log.println(Log.INFO,"",meal.getName());
            String mealname = meal.getName();
            double mealprice = meal.getPrice();
            int nummeal = order.getList().get(i).getCounter();
            TextView txname = new TextView(this);
            txname.setText(mealname);
            TextView txprice = new TextView(this);
            txprice.setText("    " + mealprice);
            TextView txnum = new TextView(this);
            txnum.setText("    " + nummeal+"    ");
            tbr.addView(txname,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tbr.addView(txprice);
            tbr.addView(txnum);
            tbr.addView(buttons[i]);
            tbr.setPadding(0,15,0,15);
            tbShoppingCart.addView(tbr);

        }
        EditText editText=findViewById(R.id.edt_totalPrice);
        editText.setText(""+calculatePrice(order));
        Button buttonOrder=new Button(this);
        buttonOrder.setText("place Order");
        lyrootcart.addView(buttonOrder);
        buttonOrder.setOnClickListener(this);



    }
    public Double calculatePrice(Order order){
        double totalPrice=0;
        int s=order.getList().size();
        for(int i=0;i<s;i++){
            OrderMap om=order.getList().get(i);
            int num=om.getCounter();
            Meal meal = om.getMeal();
            totalPrice+=(num*meal.getPrice());
        }
        return  totalPrice;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(ShoppingCartActivity.this,personal_information.class);
        intent.putExtra("OrderId",order.getId());
        startActivity(intent);
    }
}
//}
