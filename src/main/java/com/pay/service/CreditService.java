package com.pay.service;

import com.pay.model.Bill;
import com.pay.model.Credit;

import java.util.LinkedList;
import java.util.List;

public class CreditService {
    private List<Credit> creditList;

    public CreditService() {
        this.creditList = new LinkedList<>();
    }

    public void add(Credit creditRecord) {
        creditList.add(creditRecord);
    }

    public Bill getTotal() {
        double total = 0;
        for (Credit credit : creditList) {
            total += credit.getAmount();
        }
        return new Bill(total);
    }
}
