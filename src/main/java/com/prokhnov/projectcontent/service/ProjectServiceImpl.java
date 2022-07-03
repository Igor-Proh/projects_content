package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.dao.ProjectDAO;
import com.prokhnov.projectcontent.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectDAO projectDAO;

    public ProjectServiceImpl() {
    }

    @Autowired
    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDAO.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectDAO.save(project);

    }

    @Override
    public Project getProjectById(long id) {
        return projectDAO.getById(id);
    }

    @Override
    public void deleteProjectById(long id) {
        projectDAO.deleteById(id);
    }
}
