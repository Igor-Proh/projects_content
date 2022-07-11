package com.prokhnov.projectcontent.validator;

import com.prokhnov.projectcontent.model.Project;
import com.prokhnov.projectcontent.service.ProjectService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProjectValidator implements Validator {

    private final ProjectService projectService;

    public ProjectValidator(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Project.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Project project = (Project) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectName", "", "*This field is required.");

        if (project.getProjectName().length() < 4 || project.getProjectName().length() > 32) {
            errors.rejectValue("projectName"
                    , ""
                    ,"*Please use between 4 and 32 characters.");
        }
        if (projectService.findProjectByName(project.getProjectName()) != null) {
            errors.rejectValue("projectName"
                    , ""
                    ,"*Someone already has that username.");
        }
    }
}
