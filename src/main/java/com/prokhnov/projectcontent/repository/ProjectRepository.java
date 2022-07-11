package com.prokhnov.projectcontent.repository;

import com.prokhnov.projectcontent.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    public Project findByProjectName(String projectName);
}
