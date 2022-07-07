package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User findByUserName(String userName);
    List<User> findAllUsers();
    User getUserById(long id);
    void deleteUserById(long id);
}
