package com.prokhnov.projectcontent.repository;

import com.prokhnov.projectcontent.model.Components;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentsRepository extends JpaRepository<Components, Long> {
}
