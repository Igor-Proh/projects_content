package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(long id);

    public void deleteUserById(long id);
}
