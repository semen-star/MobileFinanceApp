package com.example.myapplication.MoneyTransactionSerices.Models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ExpenseModel {

    public  ExpenseModel(){}
    public ExpenseModel(BigDecimal value, String purchaseName, String categoryName) {
        this.value=value;
        this.purchaseName=purchaseName;
        this.categoryName=categoryName;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }
    public BigDecimal value;
    public String purchaseName;
    public String categoryName;
    public Timestamp createTime;
}
