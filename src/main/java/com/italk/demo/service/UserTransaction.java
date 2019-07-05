package com.italk.demo.service;

import com.italk.demo.dao.UserDao;
import com.italk.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public class UserTransaction {

    private final UserDao userDao;

    public UserTransaction(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> queryUsers() {
        List<User> users;
        users = userDao.queryUsers();
        if (users.isEmpty()) {
            throw new RuntimeException("No user found");
        } else return users;
    }

    public User queryUser(User user) {
        User retUser = userDao.queryUser(user);
        if (retUser == null) {
            throw new RuntimeException("No user found");
        } else if (retUser.getUserName() == null) {
            throw new RuntimeException("User name cannot be null");
        } else {
            return retUser;
        }
    }

    public String addUser(User user) {
        if (userDao.queryUserByID(user.getUserNumber()) != null) {
            throw new RuntimeException("User register");
        }
        int number = userDao.addUser(user);
        if (number == 0) {
            throw new RuntimeException("User Register failed");
        } else if (number == 1) {
            return "User register successful";
        } else {
            throw new RuntimeException("Return code error");
        }
    }

    public String updateUser(User user) {
        if (userDao.queryUser(user) == null) {
            throw new RuntimeException("User not found");
        }
        int number = userDao.updateUser(user);
        if (number == 0) {
            throw new RuntimeException("User update failed");
        } else if (number == 1) {
            return "User update successful";
        } else {
            throw new RuntimeException("Return code error");
        }
    }

    public String deleteUser(User user) {
        int number = userDao.deleteUser(user);
        if (number == 0) {
            throw new RuntimeException("User delete failed");
        } else if (number == 1) {
            return "User delete successful";
        } else {
            throw new RuntimeException("Return code error");
        }
    }

    public int login(String userName, String passwd) {
        User user = new User();
        user.setUserName(userName);
        User returnUser = userDao.queryUser(user);
        if (returnUser == null) {
            throw new RuntimeException("User not found");
        } else if (returnUser.getPasswd() == null) {
            throw new RuntimeException("User Password not found");
        } else if (returnUser.getPasswd().equals(passwd)) {
            return 1;
        } else {
            return 0;
        }
    }

    public int register(User user) {
        return userDao.addUser(user);
    }
}
