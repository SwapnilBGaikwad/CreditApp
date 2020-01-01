package com.pay.service;

import com.pay.model.Bill;
import com.pay.model.Spend;

import java.util.LinkedList;
import java.util.List;

public class SpendImportService {
    private List<Spend> spendList;

    public SpendImportService() {
        this.spendList = new LinkedList<>();
    }

    public void add(Spend spendRecord) {
        spendList.add(spendRecord);
    }

    public Bill getTotal() {
        double total = 0;
        for (Spend spend : spendList) {
            total += spend.getAmount();
        }
        return new Bill(total);
    }
}
