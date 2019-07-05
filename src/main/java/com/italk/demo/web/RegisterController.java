package com.italk.demo.web;

import com.italk.demo.entity.User;
import com.italk.demo.service.UserTransaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "注册类")
@RestController
public class RegisterController {

    @Autowired
    private UserTransaction userTransaction;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册", notes = "进行注册验证")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> modelMap = new HashMap<>();
        int code = userTransaction.register(user); // Return a number showing the database transaction successful or not
        if (code == 1) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }
}
