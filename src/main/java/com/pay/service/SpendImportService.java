package com.pay.service;

import com.google.inject.Inject;
import com.pay.model.Bill;
import com.pay.model.Message;
import com.pay.model.Spend;

import java.util.LinkedList;
import java.util.List;

public class SpendImportService {
    private List<Spend> spendList;
    private SmsParser parser;

    @Inject
    public SpendImportService(SmsParser parser) {
        this.parser = parser;
        this.spendList = new LinkedList<>();
    }

    public void add(Message message) {
        spendList.add(parser.getSpend(message.getContent()));
    }

    public Bill getTotal() {
        double total = 0;
        for (Spend spend : spendList) {
            total += spend.getAmount();
        }
        return new Bill(total);
    }
}
