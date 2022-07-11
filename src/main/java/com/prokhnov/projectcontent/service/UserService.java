package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);

    public User findByUserName(String userName);

    public List<User> findAllUsers();

    public User getUserById(long id);

    public void deleteUserById(long id);

}
