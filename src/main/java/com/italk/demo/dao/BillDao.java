package com.italk.demo.dao;

import com.italk.demo.entity.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillDao {

    /**
     * query all the bills from one person
     *
     * @param userNumber user ID
     * @return all the bills
     */
    List<Bill> queryBills(String userNumber);

    /**
     * query bill by billNumber
     *
     * @param billNumber ID of bill
     * @return one bill
     */
    Bill queryBillByID(String billNumber);

    /**
     * Add a bill to database
     *
     * @param bill the adding bill
     * @return Status code
     */
    int addBill(Bill bill);

    /**
     * Update a bill in the database
     *
     * @param bill bill would be updated
     * @return status code
     */
    int updateBill(Bill bill);

    /**
     * Delete bill from the database
     *
     * @param billNumber bill deleted
     * @return status code
     */
    int deleteBill(String billNumber);
}
