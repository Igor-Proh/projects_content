package com.prokhnov.projectcontent.validator;

import com.prokhnov.projectcontent.entity.User;
import com.prokhnov.projectcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty", "*This field is required.");

        if (user.getUserName().length() < 3 || user.getUserName().length() > 32) {
            errors.rejectValue("userName"
                    , "Size.userForm.userName"
                    ,"*Please use between 4 and 32 characters.");
        }

        if (userService.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("userName"
                    , "Duplicate.userForm.userName"
                    ,"*Someone already has that username.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "NotEmpty", "*This field is required.");
        if (user.getUserPassword().length() < 4 || user.getUserPassword().length() > 32) {
            errors.rejectValue("userPassword"
                    , "Size.userForm.userPassword"
                    ,"*Try one with at least 4 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userConfirmPassword", "NotEmpty", "*This field is required.");
        if (!user.getUserConfirmPassword().equals(user.getUserPassword())) {
            errors.rejectValue("userConfirmPassword"
                    , "Diff.userForm.userConfirmPassword"
                    ,"*These passwords don't match.");
        }
    }
}
