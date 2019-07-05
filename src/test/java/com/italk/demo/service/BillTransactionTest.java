package com.italk.demo.service;

import com.italk.demo.entity.Bill;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillTransactionTest {

    @Autowired
    private BillTransaction billTransaction;

    @Before
    public void setUp() throws Exception {

        Bill bill = new Bill();
        bill.setUserNumber("1");
        bill.setBillNumber("2");
        bill.setCreditCardNumber("1");
        bill.setBillType("还款");
        bill.setBillAmount(5422.01);
    }

    @Test
    public void getBills() {
        List<Bill> billList = billTransaction.getBills("1");
        assertEquals(2, billList.size());
    }

    @Test
    public void getBillByID() {
        Bill bill = billTransaction.getBillByID("3");
        assertEquals(1544.1, bill.getBillAmount(), 112.0);
    }

    @Test
    public void addBill() {
    }

    @Test
    public void updateBill() {
    }

    @Test
    public void deleteBill() {
    }
}