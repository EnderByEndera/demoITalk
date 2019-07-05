package com.italk.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "订单类", description = "描述订单内容的类，包含订单各类信息")
public class Bill {

    @ApiModelProperty(name = "billNumber", value = "订单编号", dataType = "String", required = true)
    private String billNumber;

    @ApiModelProperty(name = "userNumber", value = "用户编号", dataType = "String", required = true)
    private String userNumber;

    @ApiModelProperty(name = "creditCardNumber", value = "信用卡编号", dataType = "String", required = true)
    private String creditCardNumber;

    @ApiModelProperty(name = "billType", value = "订单类型", dataType = "String", allowableValues = "存款 or 取款", required = true)
    private String billType;

    @ApiModelProperty(name = "billAmount", value = "订单交易款", dataType = "double", example = "1645.12", required = true)
    private double billAmount;

    @ApiModelProperty(name = "billCreateTime", value = "订单生成时间", dataType = "java.util.Date")
    private Date billCreateTime;

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Date getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(Date billCreateTime) {
        this.billCreateTime = billCreateTime;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
