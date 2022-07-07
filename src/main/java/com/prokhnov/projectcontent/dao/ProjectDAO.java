package com.prokhnov.projectcontent.dao;

import com.prokhnov.projectcontent.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectDAO extends JpaRepository<Project, Long> {

}
