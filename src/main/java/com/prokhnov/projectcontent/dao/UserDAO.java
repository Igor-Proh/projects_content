package com.prokhnov.projectcontent.dao;

import com.prokhnov.projectcontent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User findByUserName (String userName);
}
