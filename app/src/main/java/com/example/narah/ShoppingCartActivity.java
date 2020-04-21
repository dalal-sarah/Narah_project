package com.example.narah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
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

    TableLayout tbShoppingCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        tbShoppingCart=findViewById( R.id.tbShoppingCart );
    }


    Order order = MainActivity.order;
    Button buttonOrder;
    @Override
    protected void onStart() {
        super.onStart();
        LinearLayout lyrootcart = findViewById(R.id.lyrootcart);
        tbShoppingCart=findViewById( R.id.tbShoppingCart );
        addComponentsToShoppingCart(tbShoppingCart);
    }
    public void addComponentsToShoppingCart(TableLayout tbShoppingCart){
        tbShoppingCart.removeAllViews();
        int size = order.getList().size();
        Button [] buttons=new Button[size];
        for (int i = 0; i < size; i++) {
            buttons[i]=new Button(this);
            buttons[i].setText("delete");
            buttons[i].setOnClickListener(this);
            buttons[i].setId(order.getList().get(i).getId());
            TableRow tbr=new TableRow(this);
            Meal meal = order.getList().get(i).getMeal();
            Log.println(Log.INFO,"",meal.getName());
            String mealname = meal.getName();
            double mealprice = meal.getPrice();
            int nummeal = order.getList().get(i).getCounter();
            if(nummeal>0) {
                TextView txname = new TextView(this);
                txname.setText(mealname);
                TextView txprice = new TextView(this);
                txprice.setText("    " + mealprice);
                TextView txnum = new TextView(this);
                txnum.setText("    " + nummeal + "    ");
                TextView txtotal = new TextView(this);
                txtotal.setText("    ||    " + nummeal*mealprice + "    ");
                tbr.addView(txname, new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tbr.addView(txprice);
                tbr.addView(txnum);
                tbr.addView(txtotal);
                tbr.addView(buttons[i]);
                tbr.setPadding(0, 15, 0, 15);
                tbShoppingCart.addView(tbr);
            }
        }
        buttonOrder =new Button(this);
        buttonOrder.setId(R.id.OrderButton);
        EditText editText=new EditText(this);
        editText.setText(""+calculatePrice(order));
        TextView tx=new TextView(this);
        tx.setText("Total Price");
        buttonOrder.setText("place Order");
        tbShoppingCart.addView(tx);
        tbShoppingCart.addView(editText);
        tbShoppingCart.addView(buttonOrder);
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
        if(v.getId()==R.id.OrderButton){
        Intent intent=new Intent(ShoppingCartActivity.this,personal_information.class);
        intent.putExtra("OrderId",order.getId());
        startActivity(intent);
        }else{
            Log.println(Log.INFO,"s",""+v.getId());
            int s=order.getList().size();
            for(int i=0;i<s;i++){
                Log.println(Log.INFO,"",""+order.getList().get(i));
                OrderMap om=order.getList().get(i);
                 if(v.getId()==om.getId()) {
                     if(om.getCounter()>0) {
                         om.setCounter(om.getCounter() - 1);
                         addComponentsToShoppingCart(tbShoppingCart);
                     }
                     Log.println(Log.INFO,"if",""+om.getMeal().getName()+" id : "+om.getId());
                    // om.setCounter(0);
                }

             }
        }
    }
}
//}
