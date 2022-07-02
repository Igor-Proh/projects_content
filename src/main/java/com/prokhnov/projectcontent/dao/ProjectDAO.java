package com.prokhnov.projectcontent.dao;

import com.prokhnov.projectcontent.entity.Project;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//public interface ProjectDAO {
@Repository
public interface ProjectDAO extends JpaRepository<Project, Long> {


}
