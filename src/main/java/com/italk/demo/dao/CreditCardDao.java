package com.italk.demo.dao;

import com.italk.demo.entity.CreditCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CreditCardDao {

    /**
     * Get all the credit cards in the database
     *
     * @return list of credit cards
     */
    List<CreditCard> queryCreditCards();

    /**
     * Get one credit card by using card ID
     *
     * @param cardNumber Credit card's ID
     * @return One credit card info
     */
    CreditCard queryCreditCardByID(String cardNumber);

    /**
     * Add one credit card to database
     *
     * @param creditCard one credit card's info
     * @return status code
     */
    int addCard(CreditCard creditCard);

    /**
     * Update one credit card by searching ID
     *
     * @param creditCard one credit card's info
     * @return status code
     */
    int updateCard(CreditCard creditCard);

    /**
     * Delete one credit card from database
     *
     * @param cardNumber one credit card's ID
     * @return status code
     */
    int deleteCard(String cardNumber);
}
