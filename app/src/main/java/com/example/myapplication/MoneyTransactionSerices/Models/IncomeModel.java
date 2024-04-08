package com.example.myapplication.MoneyTransactionSerices.Models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class IncomeModel {
    public IncomeModel() {}
    public IncomeModel(BigDecimal value, String source) {
        this.value = value;
        this.source = source;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public BigDecimal value;
    public String source;
    public Timestamp createTime;
}
