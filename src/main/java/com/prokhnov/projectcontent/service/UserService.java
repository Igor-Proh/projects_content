package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.entity.User;

public interface UserService {
    void saveUser(User user);
    User findByUserName(String userName);
}
