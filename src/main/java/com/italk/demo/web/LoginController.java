package com.italk.demo.web;

import com.italk.demo.entity.User;
import com.italk.demo.service.UserTransaction;
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

@Api(value = "登录控制类")
@RestController
public class LoginController {

    @Autowired
    private UserTransaction userTransaction;

    @ApiOperation(value = "登录", notes = "进行登录验证")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> modelMap = new HashMap<>();
        int returnCode = userTransaction.login(user.getUserName(), user.getPasswd());
        if (returnCode == 1) {
            modelMap.put("Meg", "Login Successful");
            modelMap.put("success", true);
        } else if (returnCode == 0) {
            modelMap.put("Meg", "UserName or Password not correct");
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @ApiOperation(value = "测试", notes = "进行JSON数据测试")
    @ApiResponse(code = 200, message = "Hello, World")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map<String, String> helloWorld() {
        Map<String, String> modelMap = new HashMap<>();
        modelMap.put("Hello", "World");
        return modelMap;
    }
}
