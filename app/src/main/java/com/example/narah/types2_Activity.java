package com.example.narah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class types2_Activity extends AppCompatActivity {

    ScrollView scrollview=new ScrollView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types2_);
        LinearLayout ly1=new LinearLayout(this);
        ly1.setOrientation(LinearLayout.VERTICAL);
        TextView tx=new TextView(this);
        tx.setText("tx v 1");
        ly1.addView(tx);
        TextView tx2=new TextView(this);
        tx2.setText("tx v 2");
        ly1.addView(tx2);
        scrollview.addView(ly1);
        this.setContentView(scrollview);
    }
}
