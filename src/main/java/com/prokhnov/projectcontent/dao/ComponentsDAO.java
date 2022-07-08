package com.prokhnov.projectcontent.dao;

import com.prokhnov.projectcontent.entity.Components;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentsDAO extends JpaRepository<Components, Long> {
}
