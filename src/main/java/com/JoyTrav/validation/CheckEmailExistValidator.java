package com.JoyTrav.validation;

import com.JoyTrav.dto.SignUpForm;
import com.JoyTrav.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CheckEmailExistValidator implements Validator {

    @Autowired
    private AccountService accountService;

    @Override
    public boolean supports(Class<?> clazz) {
        return SignUpForm.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        SignUpForm signupForm =  (SignUpForm) object;

        if(accountService.findAccountByEmail(signupForm.getEmail()).isPresent()) {
            errors.rejectValue("email", "email","Email is exists !");
        }

    }
}
