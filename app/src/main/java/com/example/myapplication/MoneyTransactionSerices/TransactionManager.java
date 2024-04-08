package com.example.myapplication.MoneyTransactionSerices;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.MoneyTransactionSerices.Models.ExpenseModel;
import com.example.myapplication.MoneyTransactionSerices.Models.IncomeModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TransactionManager {
    private final Context context;

    public TransactionManager(Context context) {
        this.context = context;
    }
    public ArrayList<IncomeModel> GetAllIncomes() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "SHARED_PREFS", Context.MODE_PRIVATE);
        ArrayList<String> temp = new ArrayList<String>();
        temp.addAll(sharedPref.getStringSet("INCOMES", new HashSet<>()));
        ArrayList<IncomeModel> returnValue = new ArrayList<>();
        for (String incomeString: temp) {
            returnValue.add(JsonConverter.ExtractIncome(incomeString));
        }
        Collections.sort(returnValue, new Comparator<IncomeModel>() {
            @Override
            public int compare(IncomeModel a, IncomeModel b) {
                if(a.createTime.after(b.createTime)) {
                    return 1;
                }
                else if(b.createTime.after(a.createTime)) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        return returnValue;
    }

    public void RemoveIncome(IncomeModel income) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "SHARED_PREFS", Context.MODE_PRIVATE);

        Set<String> tempSet = sharedPref.getStringSet("INCOMES", new HashSet<>());
        tempSet.remove(JsonConverter.ConvertIncome(income));

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet("INCOMES", tempSet);
        editor.apply();
    }

    public void AddIncome(IncomeModel income) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "SHARED_PREFS", Context.MODE_PRIVATE);

        Set<String> tempSet = sharedPref.getStringSet("INCOMES", new HashSet<>());

        tempSet.add(JsonConverter.ConvertIncome(income));

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet("INCOMES", tempSet);
        editor.apply();
    }












    public ArrayList<ExpenseModel> GetAllExpenses() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "SHARED_PREFS", Context.MODE_PRIVATE);
        ArrayList<String> temp = new ArrayList<String>();
        temp.addAll(sharedPref.getStringSet("EXPENSES", new HashSet<>()));
        ArrayList<ExpenseModel> returnValue = new ArrayList<>();
        for (String expenseString: temp) {
            returnValue.add(JsonConverter.ExtractExpense(expenseString));
        }
        Collections.sort(returnValue, new Comparator<ExpenseModel>() {
            @Override
            public int compare(ExpenseModel a, ExpenseModel b) {
                if(a.createTime.after(b.createTime)) {
                    return 1;
                }
                else if(b.createTime.after(a.createTime)) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        return returnValue;
    }

    public void RemoveExpense(ExpenseModel expense) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "SHARED_PREFS", Context.MODE_PRIVATE);

        Set<String> tempSet = sharedPref.getStringSet("EXPENSES", new HashSet<>());
        tempSet.remove(JsonConverter.ConvertExpense(expense));

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet("EXPENSES", tempSet);
        editor.apply();
    }

    public void AddExpense(ExpenseModel expense) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "SHARED_PREFS", Context.MODE_PRIVATE);

        Set<String> tempSet = sharedPref.getStringSet("EXPENSES", new HashSet<>());

        tempSet.add(JsonConverter.ConvertExpense(expense));

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet("EXPENSES", tempSet);
        editor.apply();
    }

}
