package com.prokhnov.projectcontent.dao;

import com.prokhnov.projectcontent.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersDAO extends JpaRepository<Users, Long> {
}
