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
        String content = "INR1,951.00 debited on Credit Card XX8002 on 25-Dec-19.Info:BARBEQUE NATION." +
                "Avbl Lmt:INR1,52,090.30.Call 18002662 for dispute or SMS BLOCK 8002 to 9215676766";
        Spend spend = parser.getSpend(content);
        assertEquals(1951, spend.getAmount().intValue());
        assertEquals("XX8002", spend.getCardNumber());
        assertEquals("25-Dec-19", getDate(spend.getDate()));
        assertEquals("BARBEQUE NATION", spend.getReason());
    }

    private String getDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
        return format.format(date);
    }
}