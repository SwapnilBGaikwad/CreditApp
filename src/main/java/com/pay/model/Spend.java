package com.pay.model;

import lombok.Data;

import java.util.Date;

@Data
public class Spend {
    private String cardNumber;
    private Double amount;
    private String reason;
    private Date date;

    public Spend(String cardNumber, Double amount, String reason, Date date) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.reason = reason;
        this.date = date;
    }
}
