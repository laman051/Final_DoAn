package com.example.dacs3.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dacs3.R;

public class PizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewholder_category);
        Intent intent = getIntent();
        int id_cate = intent.getIntExtra("id_cate",0);
        String name_cate = intent.getStringExtra("name_cate");
        Toast.makeText(this,id_cate +"-"+ name_cate,Toast.LENGTH_LONG).show();
    }
}