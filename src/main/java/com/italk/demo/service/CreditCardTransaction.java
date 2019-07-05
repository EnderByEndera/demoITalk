package com.italk.demo.service;

import com.italk.demo.dao.CreditCardDao;
import com.italk.demo.entity.CreditCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public class CreditCardTransaction {

    @Autowired
    private CreditCardDao creditCardDao;

    public List<CreditCard> getCreditCards() {
        List<CreditCard> creditCardList = creditCardDao.queryCreditCards();
        if (creditCardList == null) {
            throw new RuntimeException("Credit Card List is empty");
        }
        return creditCardList;
    }

    public CreditCard getCreditCardByID(String cardNumber) {
        CreditCard creditCard = creditCardDao.queryCreditCardByID(cardNumber);
        if (creditCard == null) {
            throw new RuntimeException("Credit card is empty");
        } else if (creditCard.getCardNumber() == null) {
            throw new RuntimeException("Credit card ID is empty");
        }
        return creditCard;
    }

    public int addCreditCard(CreditCard creditCard) {
        int equalNum = creditCardDao.addCard(creditCard);
        if (equalNum == 0) {
            throw new RuntimeException("Card add failure");
        } else if (equalNum == 1) {
            return equalNum;
        } else {
            throw new RuntimeException("Unexpected failure happened");
        }
    }

    public int updateCreditCard(CreditCard creditCard) {
        int equalNum = creditCardDao.updateCard(creditCard);
        if (equalNum == 0) {
            throw new RuntimeException("Card update failure");
        } else if (equalNum == 1) {
            return equalNum;
        } else {
            throw new RuntimeException("Unexpected failure happened");
        }
    }

    public int deleteCard(String cardNumber) {
        CreditCard creditCard = new CreditCard();
        int equalNum;
        creditCard = creditCardDao.queryCreditCardByID(cardNumber);
        if (creditCard == null) {
            throw new RuntimeException("Card not exist");
        } else {
            equalNum = creditCardDao.deleteCard(cardNumber);
        }
        if (equalNum == 1) {
            return equalNum;
        } else if (equalNum == 0) {
            throw new RuntimeException("Delete card failure");
        } else {
            throw new RuntimeException("Unexpected failure happened");
        }
    }
}
