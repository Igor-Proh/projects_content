package com.prokhnov.projectcontent.validator;

import com.prokhnov.projectcontent.entity.Project;
import com.prokhnov.projectcontent.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProjectValidator implements Validator {

    private ProjectService projectService;

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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectName", "NotEmpty", "*This field is required.");

        if (project.getProjectName().length() < 3 || project.getProjectName().length() > 32) {
            errors.rejectValue("projectName"
                    , ""
                    ,"*Please use between 4 and 32 characters.");
        }
    }
}
