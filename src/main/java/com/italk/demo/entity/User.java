package com.italk.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户类", description = "用户的各类信息")
public class User {

    @ApiModelProperty(name = "userNumber", value = "用户编号", dataType = "String", required = true)
    private String userNumber;

    @ApiModelProperty(value = "用户昵称", dataType = "String", name = "userName", required = true)
    private String userName;

    @ApiModelProperty(value = "用户性别", dataType = "String", allowableValues = "male, female", name = "userGender", required = true)
    private String userGender;

    @ApiModelProperty(value = "用户地址", dataType = "String", name = "userAddress", required = true)
    private String userAddress;

    @ApiModelProperty(value = "用户工作", dataType = "String", name = "userJob", required = true)
    private String userJob;

    @ApiModelProperty(value = "用户身份证号", dataType = "String", name = "idNumber", required = true)
    private String idNumber;

    @ApiModelProperty(value = "用户密码", name = "password", dataType = "String", required = true)
    private String passwd;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
