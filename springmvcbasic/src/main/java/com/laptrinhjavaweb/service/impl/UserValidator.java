package com.laptrinhjavaweb.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.laptrinhjavaweb.dto.UserDTO;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "notEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.user.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passWord", "NotEmpty");
        if (user.getPassWord().length() < 6 || user.getPassWord().length() > 32) {
            errors.rejectValue("passWord", "Size.user.passWord");
        }
        if (!user.getPassWordConfirm().equals(user.getPassWord())) {
            errors.rejectValue("passWordConfirm", "Diff.user.passWordConfirm");
        }
    }

}
