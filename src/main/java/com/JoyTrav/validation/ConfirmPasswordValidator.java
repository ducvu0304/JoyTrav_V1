package com.JoyTrav.validation;

import com.JoyTrav.dto.SignUpForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ConfirmPasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SignUpForm.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        SignUpForm signupForm = (SignUpForm) object;

        if(!signupForm.getRePassword().equals(signupForm.getPassword())) {
            errors.rejectValue("rePassword", "rePassword" ,"Confirm password do not match !");
        }
    }
}
