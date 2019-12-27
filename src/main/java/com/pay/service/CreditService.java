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
        return new Bill(creditList.stream().mapToDouble(Credit::getAmount).sum());
    }
}
