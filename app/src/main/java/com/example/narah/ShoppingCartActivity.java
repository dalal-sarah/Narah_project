package com.example.narah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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
        super.onStart();
        LinearLayout lyroot = findViewById(R.id.lyrootcart);
        TableLayout tbShoppingCart=findViewById( R.id.tbShoppingCart );

        Order order = MainActivity.order;
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
//            lyitem.addView(txname);
//            lyitem.addView(txprice);
//            lyitem.addView(txnum);
            //txname.setWidth();
            tbr.addView(txname,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tbr.addView(txprice);
            tbr.addView(txnum);
            tbr.addView(buttons[i]);
            tbr.setPadding(0,15,0,15);
            //tbr.setMinimumWidth(10);
            tbShoppingCart.addView(tbr);
         //   lyroot.addView(lyitem);
        }

    }
}
//}
