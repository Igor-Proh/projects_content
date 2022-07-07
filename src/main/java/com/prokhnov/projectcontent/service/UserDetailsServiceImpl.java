package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.dao.UserDAO;
import com.prokhnov.projectcontent.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDAO.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new UserDetailsImpl(user);
    }
}
