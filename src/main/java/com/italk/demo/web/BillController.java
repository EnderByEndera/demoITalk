package com.italk.demo.web;

import com.italk.demo.entity.Bill;
import com.italk.demo.service.BillTransaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "订单管理控制类")
@RestController
public class BillController {

    @Autowired
    private BillTransaction billTransaction;


    @ApiOperation(value = "获得订单", notes = "获得指定用户的所有订单")
    @RequestMapping(value = "/getbills", method = RequestMethod.POST)
    public Map<String, Object> getBills(@RequestBody String userNumber) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("bill", billTransaction.getBills(userNumber));
        return modelMap;
    }

    @ApiOperation(value = "获得一个订单", notes = "通过订单ID获得一个订单")
    @RequestMapping(value = "/getbillbyid", method = RequestMethod.POST)
    public Map<String, Object> getBillByID(@RequestBody String billNumber) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("bill", billTransaction.getBillByID(billNumber));
        return modelMap;
    }


    @ApiOperation(value = "添加订单", notes = "添加一个新订单")
    @ApiResponse(code = 200, message = "添加成功")
    @RequestMapping(value = "/addbill", method = RequestMethod.POST)
    public Map<String, Object> addBill(@RequestBody Bill bill) {
        Map<String, Object> modelMap = new HashMap<>();
        int equalNum = billTransaction.addBill(bill);
        if (equalNum == 1) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        modelMap.put("bill", bill);
        return modelMap;
    }

    @ApiOperation(value = "更新订单", notes = "通过获取订单编号更新订单")
    @RequestMapping(value = "/updatebill", method = RequestMethod.POST)
    public Map<String, Object> updateBill(@RequestBody Bill bill) {
        Map<String, Object> modelMap = new HashMap<>();
        int equalNum = billTransaction.updateBill(bill);
        if (equalNum == 1) {
            modelMap.put("success", true);
        } else {
            modelMap.put("sucess", false);
        }
        modelMap.put("bill", bill);
        return modelMap;
    }

    @ApiOperation(value = "删除订单", notes = "根据订单编号删除指定订单")
    @RequestMapping(value = "/deletebill", method = RequestMethod.POST)
    public Map<String, Object> deleteBill(@RequestBody String billNumber) {
        Map<String, Object> modelMap = new HashMap<>();
        int equalNum = billTransaction.deleteBill(billNumber);
        if (equalNum == 1) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }
}
