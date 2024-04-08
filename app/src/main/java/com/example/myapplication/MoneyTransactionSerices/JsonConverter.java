package com.example.myapplication.MoneyTransactionSerices;

import com.example.myapplication.MoneyTransactionSerices.Models.ExpenseModel;
import com.example.myapplication.MoneyTransactionSerices.Models.IncomeModel;
import com.google.gson.GsonBuilder;

public class JsonConverter {

    public static String ConvertIncome(IncomeModel income) {
        return new GsonBuilder().create().toJson( income, IncomeModel.class);
    }

    public static String ConvertExpense(ExpenseModel expense) {
        return new GsonBuilder().create().toJson( expense, ExpenseModel.class);
    }

    public static IncomeModel ExtractIncome(String jsonIncome) {
        return new GsonBuilder().create().fromJson(jsonIncome, IncomeModel.class);
    }
    public static ExpenseModel ExtractExpense(String jsonExpense) {
        return new GsonBuilder().create().fromJson(jsonExpense, ExpenseModel.class);
    }


}
