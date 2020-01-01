package com.pay.service;

import com.pay.model.Spend;

import java.util.Date;

public class SmsParser {
    public Spend getSpend(String content) {
        return new Spend("XXXX", 100.00d, "Lunch", new Date());
    }
}
