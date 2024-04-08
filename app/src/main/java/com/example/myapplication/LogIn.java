package com.example.myapplication;




import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.MoneyTransactionSerices.Models.IncomeModel;
import com.example.myapplication.MoneyTransactionSerices.TransactionManager;

import java.io.Console;
import java.math.BigDecimal;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
}