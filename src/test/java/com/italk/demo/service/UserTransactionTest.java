package com.italk.demo.service;

import com.italk.demo.entity.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class UserTransactionTest {

    @Autowired
    private UserTransaction userTransaction;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUserJob("Worker");
        user.setUserGender("女");
        user.setUserNumber("2");
        user.setUserName("Alice");
        user.setPasswd("aiihhbfcsy");
        user.setIdNumber("51012119980826031");
        user.setUserAddress("Chengdu");
    }

    @Test
    public void queryUsers() {
        List<User> users = userTransaction.queryUsers();
        assertEquals(2, users.size());
    }

    @Test
    public void queryUser() {
        User user = new User();
        user.setUserName("Ender");
        User auser = userTransaction.queryUser(user);
        assertEquals("1", auser.getUserNumber());
    }

    @Test
    public void addUser() {
        String message = userTransaction.addUser(user);
        assertEquals("User register successful", message);
    }

    @Test
    public void updateUser() {
        String message = userTransaction.updateUser(user);
        assertEquals("User update successful", message);
    }

    @Test
    public void deleteUser() {
        String message = userTransaction.deleteUser(user);
        assertEquals("User delete successful", message);
    }

    @Test
    public void login() {
        int returnNum = userTransaction.login("Ender", "aiihhbfcsy123!@#");
        assertEquals(1, returnNum);
    }
}