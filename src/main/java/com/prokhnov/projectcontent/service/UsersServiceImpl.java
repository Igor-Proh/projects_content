package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.dao.UsersDAO;
import com.prokhnov.projectcontent.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersDAO usersDAO;

    public UsersServiceImpl() {
    }

    @Autowired
    public UsersServiceImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDAO.findAll();
    }

    @Override
    public void saveUser(Users user) {
        usersDAO.save(user);
    }

    @Override
    public Users getUserById(long id) {
        return usersDAO.getById(id);
    }

    @Override
    public void deleteUserById(long id) {
        usersDAO.deleteById(id);
    }
}
