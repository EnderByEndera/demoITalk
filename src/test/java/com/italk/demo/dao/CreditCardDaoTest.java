package com.italk.demo.dao;

import com.italk.demo.entity.CreditCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditCardDaoTest {

    @Autowired
    private CreditCardDao creditCardDao;
    private CreditCard creditCard;

    @Before
    public void before() {
        creditCard = new CreditCard();
        creditCard.setCardNumber("2");
        creditCard.setCardType("金卡");
        creditCard.setCardPasswd("132456");
        creditCard.setCardLevel("2");
        creditCard.setTotalRange(10000);
        creditCard.setAvaiRange(10000);
    }

    @Test
    public void queryCreditCards() {
        List<CreditCard> creditCards = creditCardDao.queryCreditCards();
        assertEquals(2, creditCards.size());
    }

    @Test
    public void queryCreditCardByID() {
        CreditCard creditCard = creditCardDao.queryCreditCardByID("1");
        assertEquals("3", creditCard.getCardLevel());
    }

    @Test
    public void addCard() {
        int equalNum = creditCardDao.addCard(creditCard);
        assertEquals(1, equalNum);
    }

    @Test
    public void updateCard() {
        int equalNum = creditCardDao.updateCard(creditCard);
        assertEquals(1, equalNum);
    }

    @Test
    public void updateCardFail() {
        creditCard.setCardNumber("4");
        int equalNum = creditCardDao.updateCard(creditCard);
        assertNotEquals(1, equalNum);
        creditCard.setCardNumber("2");
    }

    @Test
    public void deleteCard() {
        int equalNum = creditCardDao.deleteCard("2");
        assertEquals(1, equalNum);
    }
}