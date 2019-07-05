package com.italk.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

@ApiModel(value = "信用卡类", description = "包含信用卡的各类信息")
public class CreditCard {

    @ApiModelProperty(name = "cardNumber", value = "信用卡编号", dataType = "String", required = true)
    private String cardNumber;

    @ApiModelProperty(name = "cardType", value = "信用卡类型", dataType = "String", required = true, allowableValues = "金卡 or 银卡 or 普通卡")
    private String cardType;

    @ApiModelProperty(name = "cardPasswd", value = "信用卡密码", dataType = "String", required = true, allowableValues = "最大长度6位")
    private String cardPasswd;

    @ApiModelProperty(name = "cardLevel", value = "信用卡等级", dataType = "String", required = true, allowableValues = "1 or 2 or 3 or 4")
    private String cardLevel;

    @ApiModelProperty(name = "createTime", value = "信用卡创建时间", dataType = "java.util.Date")
    private Date createTime;

    @ApiModelProperty(name = "totalRange", value = "信用卡总额度", dataType = "int", required = true)
    private int totalRange;

    @ApiModelProperty(name = "avaiRange", value = "信用卡可用额度", dataType = "int", required = true)
    private int avaiRange;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardPasswd() {
        return cardPasswd;
    }

    public void setCardPasswd(String cardPasswd) {
        this.cardPasswd = cardPasswd;
    }

    public String getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(String cardLevel) {
        this.cardLevel = cardLevel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTotalRange() {
        return totalRange;
    }

    public void setTotalRange(int totalRange) {
        this.totalRange = totalRange;
    }

    public int getAvaiRange() {
        return avaiRange;
    }

    public void setAvaiRange(int avaiRange) {
        this.avaiRange = avaiRange;
    }
}
