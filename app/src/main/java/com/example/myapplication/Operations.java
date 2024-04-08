package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Operations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operations);
        RecyclerView rView = (RecyclerView) findViewById(R.id.incomes);
        RecyclerView rView2 = (RecyclerView) findViewById(R.id.expenses);
        CustomAdapter adapter = new CustomAdapter(Operations.this);
        CustomAdapterForExpenditure adapter2 = new CustomAdapterForExpenditure(Operations.this);

        rView.setLayoutManager(new LinearLayoutManager(this));
        rView2.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(adapter);
        rView2.setAdapter(adapter2);
    }



}