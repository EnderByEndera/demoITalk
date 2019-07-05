package com.italk.demo.dao;

import com.italk.demo.entity.Bill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillDaoTest {

    @Autowired
    private BillDao billDao;

    @Test
    public void queryBillByID() {
        Bill testBill = new Bill();
        testBill.setBillNumber("1");
        testBill.setBillAmount(1500.00);
        testBill.setBillType("取款");
        Bill bill = billDao.queryBillByID("1");
        assertEquals(bill.getBillNumber(), testBill.getBillNumber());
        assertEquals(bill.getBillType(), testBill.getBillType());
    }

    @Test
    public void queryBills() {
        List<Bill> bills = billDao.queryBills("1");
        assertEquals(3, bills.size());
    }

    @Test
    public void addBills() {
        Bill bill = new Bill();
        bill.setBillNumber("2");
        bill.setBillAmount(1500.00);
        bill.setBillType("还款");
        bill.setCreditCardNumber("1");
        bill.setUserNumber("1");
        int equalNum = billDao.addBill(bill);
        assertEquals(1, equalNum);
    }

    @Test
    public void updateBill() {
        Bill bill = new Bill();
        bill.setBillNumber("2");
        bill.setBillAmount(1500.00);
        bill.setBillType("还款");
        bill.setCreditCardNumber("1");
        bill.setUserNumber("1");
        int equalNum = billDao.updateBill(bill);
        assertEquals(1, equalNum);
    }

    @Test
    public void deleteBill() {
        String billNumber = "2";
        int equalNum = billDao.deleteBill("2");
        assertEquals(1, equalNum);

    }
}