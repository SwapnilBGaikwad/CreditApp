package com.pay.service;

import com.pay.model.Spend;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class SmsParserTest {
    @Test
    public void test() {
        SmsParser parser = new SmsParser();
        String content = "INR244.00 debited on Credit Card XX8002 on 30-Nov-19.Info:AJFAN DATES AND." +
                "Avbl Lmt:INR1,52,929.00.Call 18002662 for dispute or SMS BLOCK 8002 to 9215676766";
        Spend spend = parser.getSpend(content);
        assertEquals(244, spend.getAmount().intValue());
        assertEquals("XX8002", spend.getCardNumber());
        assertEquals("30-Nov-19", getDate(spend.getDate()));
        assertEquals("AJFAN DATES AND", spend.getReason());
    }

    private String getDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
        return format.format(date);
    }
}