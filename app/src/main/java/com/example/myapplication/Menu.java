package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.MoneyTransactionSerices.Models.ExpenseModel;
import com.example.myapplication.MoneyTransactionSerices.Models.IncomeModel;
import com.example.myapplication.MoneyTransactionSerices.TransactionManager;

import java.math.BigDecimal;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button expenditure = (Button)findViewById(R.id.expenditure);
        Button income = (Button)findViewById(R.id.income);
        Button operations = (Button)findViewById(R.id.operations);
        TextView balance = (TextView)findViewById(R.id.balance);

        balance.setText(GetCurrentBalance().toString());

        expenditure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, com.example.myapplication.expenditure.class));
            }
        });
        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, com.example.myapplication.income.class));
            }
        });
        operations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Operations.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView balance = (TextView)findViewById(R.id.balance);
        balance.setText(GetCurrentBalance().toString());
    }

    protected BigDecimal GetCurrentBalance(){
        TransactionManager transactionManager = new TransactionManager(Menu.this);
        //balance = AllIncomes-AllExpenses
        ExpenseModel[] AllExpenses = transactionManager.GetAllExpenses().toArray(new ExpenseModel[0]);
        IncomeModel[] AllIncomes = transactionManager.GetAllIncomes().toArray(new IncomeModel[0]);

        BigDecimal balance = new BigDecimal(0);
        for (ExpenseModel expense: AllExpenses) {
            balance = balance.subtract(expense.value);
        }

        for (IncomeModel incomes: AllIncomes) {
            balance = balance.add(incomes.value);
        }

        return balance;
    }
}