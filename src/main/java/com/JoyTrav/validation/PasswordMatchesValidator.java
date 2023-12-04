package com.JoyTrav.validation;

import com.JoyTrav.dto.SignUpForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        SignUpForm user = (SignUpForm) obj;
        return user.getPassword().equals(user.getRePassword());
    }
}


