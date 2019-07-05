package com.italk.demo.web;

import com.italk.demo.entity.CreditCard;
import com.italk.demo.service.CreditCardTransaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "信用卡管理类")
@RestController
public class CreditCardController {

    @Autowired
    private CreditCardTransaction creditCardTransaction;

    @ApiOperation(value = "获得所有信用卡", notes = "GET方法，管理员可获得数据库中已保存的所有信用卡")
    @RequestMapping(value = "/getcreditcards", method = RequestMethod.GET)
    public Map<String, Object> getCreditCards() {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("credit cards", creditCardTransaction.getCreditCards());
        return modelMap;
    }

    @ApiOperation(value = "获得单个信用卡", notes = "通过信用卡编号获得单个信用卡")
    @RequestMapping(value = "/getcreditcardbyid", method = RequestMethod.POST)
    public Map<String, Object> getCreditCardByID(@RequestBody String cardNumber) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("credit card", creditCardTransaction.getCreditCardByID(cardNumber));
        return modelMap;
    }

    @ApiOperation(value = "添加信用卡", notes = "通过输入信用卡信息添加新信用卡")
    @RequestMapping(value = "/addcreditcard", method = RequestMethod.POST)
    public Map<String, Object> addCreditCard(@RequestBody CreditCard creditCard) {
        Map<String, Object> modelMap = new HashMap<>();
        creditCardTransaction.addCreditCard(creditCard);
        modelMap.put("success", true);
        return modelMap;
    }

    @ApiOperation(value = "更新信用卡", notes = "通过输入信用卡新信息更新信用卡")
    @RequestMapping(value = "/updatecreditcard", method = RequestMethod.POST)
    public Map<String, Object> updateCreditCard(@RequestBody CreditCard creditCard) {
        Map<String, Object> modelMap = new HashMap<>();
        creditCardTransaction.updateCreditCard(creditCard);
        modelMap.put("success", true);
        return modelMap;
    }

    @ApiOperation(value = "删除信用卡", notes = "删除指定信用卡信息")
    @RequestMapping(value = "/deletecreditcard", method = RequestMethod.POST)
    public Map<String, Object> deleteCreditCard(@RequestBody String cardNumber) {
        Map<String, Object> modelMap = new HashMap<>();
        creditCardTransaction.deleteCard(cardNumber);
        modelMap.put("success", true);
        return modelMap;
    }
}
