package com.italk.demo.dao;

import com.italk.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * Query all users
     *
     * @return All users' information
     */
    List<User> queryUsers();

    /**
     * Query one user
     *
     * @return one user's information
     */
    User queryUser(User user);


    /**
     * Query one user by ID
     *
     * @return one user's information through ID
     */
    User queryUserByID(String userID);

    /**
     * Add one user to db
     *
     * @return verification message
     */
    int addUser(User user);

    /**
     * Update one user' information
     *
     * @return verification message
     */
    int updateUser(User user);

    /**
     * Delete one user
     *
     * @return verification message
     */
    int deleteUser(User user);
}
