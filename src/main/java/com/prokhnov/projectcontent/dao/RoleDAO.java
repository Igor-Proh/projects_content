package com.prokhnov.projectcontent.dao;

import com.prokhnov.projectcontent.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {
}
