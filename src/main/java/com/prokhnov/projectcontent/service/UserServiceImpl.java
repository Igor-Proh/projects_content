package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.dao.RoleDAO;
import com.prokhnov.projectcontent.dao.UserDAO;
import com.prokhnov.projectcontent.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void saveUser(User user) {
//        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
//        user.setRoles(new HashSet<>(roleDAO.findAll()));
        userDAO.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User getUserById(long id) {

        if (userDAO.findById(id).isPresent()) {
            return userDAO.findById(id).get();
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteUserById(long id) {
        userDAO.deleteById(id);
    }

}
