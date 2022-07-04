package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.entity.Users;

import java.util.List;

public interface UsersService {
    public List<Users> getAllUsers();

    public void saveUser(Users user);

    public Users getUserById(long id);

    public void deleteUserById(long id);
}
