package com.prokhnov.projectcontent.repository;

import com.prokhnov.projectcontent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   public User findByUserName(String userName);
}
