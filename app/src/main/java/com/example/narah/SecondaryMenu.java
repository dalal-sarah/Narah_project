package com.example.narah;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.narah.Model.Meal;

import java.util.ArrayList;
import java.util.List;

public class SecondaryMenu extends AppCompatActivity {

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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        String s=getIntent().getStringExtra("type");
        List list=new ArrayList();

        addComponentsToSecondaryMenu(lyroot,list,getIntent().getStringExtra("type"));
    }

    public void addComponentsToSecondaryMenu(LinearLayout ly, List meals,String s){
        for(int i=0;i<10;i++) {
            LinearLayout ly1 = new LinearLayout(new ContextThemeWrapper(this,R.style.SecondaryMenuComponents));

            ly1.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout ly2 = new LinearLayout(this);
            ly2.setOrientation(LinearLayout.VERTICAL);
            TextView txname = new TextView(this);
            txname.setText(s);
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
            imgview.setImageResource(R.drawable.dessert);
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
}
