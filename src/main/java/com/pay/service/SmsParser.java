package com.pay.service;

import com.pay.model.Spend;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class SmsParser {
    public Spend getSpend(String content) {
        double amount = Double.parseDouble(content.split(" ")[0].replace(",", "").substring(3));
        String card = content.split(" ")[5];
        Date date = getDate(content.split(" ")[7]);
        return new Spend(card, amount, getReason(content), date);
    }

    private String getReason(String data) {
        String str = data.split("Info:")[1];
        return str.substring(0, str.indexOf('.'));
    }


    private Date getDate(String data) {
        int last = data.indexOf(".");
        String date = data.substring(0, last);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            log.error("Failed to parse", e);
            throw new IllegalArgumentException("Failed to parse", e);
        }
    }
}
