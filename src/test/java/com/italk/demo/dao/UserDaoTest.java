package com.italk.demo.dao;

import com.italk.demo.entity.User;
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
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryUsers() {
        List<User> users = userDao.queryUsers();
        assertEquals(2, users.size());
    }

    @Test
    public void queryUser() {
        User assumeUser = new User();
        assumeUser.setUserName("Ender");
        assumeUser.setUserNumber("1");
        User user = userDao.queryUser(assumeUser);
        assertEquals("Ender", user.getUserName());
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUserNumber("2");
        user.setUserName("Alice");
        user.setUserAddress("Chengdu");
        user.setUserGender("女");
        user.setUserJob("Student");
        user.setIdNumber("514544578458");
        user.setPasswd("aiihhbfcsy123!@#");
        int number = userDao.addUser(user);
        assertEquals(1, number);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserNumber("2");
        user.setUserJob("Student");
        user.setUserGender("Male");
        user.setUserAddress("Heibei");
        user.setUserName("adafd");
        int number = userDao.updateUser(user);
        assertEquals(1, number);
    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setUserNumber("2");
        int number = userDao.deleteUser(user);
        assertEquals(1, number);
    }
}