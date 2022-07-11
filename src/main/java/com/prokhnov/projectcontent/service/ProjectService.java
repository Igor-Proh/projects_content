package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.model.Components;
import com.prokhnov.projectcontent.model.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> getAllProjects();

    public void saveProject(Project project);

    public Project getProjectById(long id);

    public void deleteProjectById(long id);

    public List<Project> getAllProjectsAndSortBy(String s);

    public List<Components> getAllComponentsAndSortBy(long id, String sortBy);

    public Project findProjectByName(String projectName);
}
