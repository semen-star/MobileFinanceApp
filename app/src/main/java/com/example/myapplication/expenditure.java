package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.MoneyTransactionSerices.Models.ExpenseModel;
import com.example.myapplication.MoneyTransactionSerices.Models.IncomeModel;
import com.example.myapplication.MoneyTransactionSerices.TransactionManager;

import java.math.BigDecimal;

public class expenditure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expenditure);

        findViewById(R.id.Write1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransactionManager transactionManager = new TransactionManager(expenditure.this);
                ExpenseModel expenseModel = new ExpenseModel(
                        new BigDecimal(Double.parseDouble(((EditText)findViewById(R.id.SummEx)).getText().toString())),
                        ((EditText)findViewById(R.id.NameEx)).getText().toString(),
                        ((EditText)findViewById(R.id.CategoryEx)).getText().toString()
                );
                transactionManager.AddExpense(expenseModel);
                startActivity(new Intent(expenditure.this, Menu.class));
            }
        });
    }
}