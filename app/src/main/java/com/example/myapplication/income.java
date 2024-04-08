package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.MoneyTransactionSerices.Models.IncomeModel;
import com.example.myapplication.MoneyTransactionSerices.TransactionManager;

import java.math.BigDecimal;

public class income extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income);

        findViewById(R.id.Write2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransactionManager transactionManager = new TransactionManager(income.this);
                IncomeModel incomeModel = new IncomeModel(
                        new BigDecimal(Double.parseDouble(((EditText)findViewById(R.id.SummInc)).getText().toString())),
                        ((EditText)findViewById(R.id.AccInc)).getText().toString()

                );
                transactionManager.AddIncome(incomeModel);
                startActivity(new Intent(income.this, Menu.class));
            }
        });
    }
}