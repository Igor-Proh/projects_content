package com.prokhnov.projectcontent.service;

import com.prokhnov.projectcontent.repository.ProjectRepository;
import com.prokhnov.projectcontent.model.Components;
import com.prokhnov.projectcontent.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    public ProjectServiceImpl() {
    }

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project getProjectById(long id) {
        return projectRepository.getById(id);
    }

    @Override
    public void deleteProjectById(long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> getAllProjectsAndSortBy(String sortBy) {
        List<Project> list = projectRepository.findAll();

        switch (sortBy) {
            case "id lowest first":
                return list.stream().sorted(Comparator.comparing(Project::getProjectId)).collect(Collectors.toList());
            case "id highest first":
                return list.stream().sorted(Comparator.comparing(Project::getProjectId).reversed()).collect(Collectors.toList());
            case "name a-z":
                return list.stream().sorted(Comparator.comparing(Project::getProjectName)).collect(Collectors.toList());
            case "name z-a":
                return list.stream().sorted(Comparator.comparing(Project::getProjectName).reversed()).collect(Collectors.toList());
            case "description a-z":
                return list.stream().sorted(Comparator.comparing(Project::getProjectDescription)).collect(Collectors.toList());
            case "description z-a":
                return list.stream().sorted(Comparator.comparing(Project::getProjectDescription).reversed()).collect(Collectors.toList());
            case "date lowest first":
                return list.stream().sorted(Comparator.comparing(Project::getProjectDateOfCreate)).collect(Collectors.toList());
            case "date highest first":
                return list.stream().sorted(Comparator.comparing(Project::getProjectDateOfCreate).reversed()).collect(Collectors.toList());
            default:
                return list;
        }
    }

    @Override
    public List<Components> getAllComponentsAndSortBy(long id, String sortBy) {
        List<Components> list = projectRepository.getById(id).getProjectComponent();
        switch (sortBy) {
            case "name a-z":
                return list.stream().sorted(Comparator.comparing(Components::getComponentName)).collect(Collectors.toList());
            case "name z-a":
                return list.stream().sorted(Comparator.comparing(Components::getComponentName).reversed()).collect(Collectors.toList());
            case "quantity 0-9":
                return list.stream().sorted(Comparator.comparing(Components::getComponentQuantity)).collect(Collectors.toList());
            case "quantity 9-0":
                return list.stream().sorted(Comparator.comparing(Components::getComponentQuantity).reversed()).collect(Collectors.toList());
            case "description a-z":
                return list.stream().sorted(Comparator.comparing(Components::getComponentDescription)).collect(Collectors.toList());
            case "description z-a":
                return list.stream().sorted(Comparator.comparing(Components::getComponentDescription).reversed()).collect(Collectors.toList());
            case "date lowest first":
                return list.stream().sorted(Comparator.comparing(Components::getComponentDateOfCreate)).collect(Collectors.toList());
            case "date highest first":
                return list.stream().sorted(Comparator.comparing(Components::getComponentDateOfCreate).reversed()).collect(Collectors.toList());
            default:
                return list;
        }
    }

    @Override
    public Project findProjectByName(String projectName) {
        return projectRepository.findByProjectName(projectName);
    }
}
