package com.italk.demo.service;

import com.italk.demo.dao.BillDao;
import com.italk.demo.entity.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public class BillTransaction {

    @Autowired
    private BillDao billDao;

    public List<Bill> getBills(String userNumber) {
        return billDao.queryBills(userNumber);
    }

    public Bill getBillByID(String billNumber) {
        return billDao.queryBillByID(billNumber);
    }

    public int addBill(Bill bill) {
        int equalNum = billDao.addBill(bill);
        if (equalNum == 0) {
            throw new RuntimeException("Adding Bill failure");
        }
        return equalNum;
    }

    public int updateBill(Bill bill) {
        int equalNum = billDao.updateBill(bill);
        if (equalNum == 0) {
            throw new RuntimeException("Updating Bill failure");
        }
        return equalNum;
    }

    public int deleteBill(String billNumber) {
        int equalNum = billDao.deleteBill(billNumber);
        if (equalNum == 0) {
            throw new RuntimeException("Delete Bill failure");
        }
        return equalNum;
    }
}
