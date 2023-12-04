package com.JoyTrav.dto;

import com.JoyTrav.validation.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class SignUpForm {
    @NotBlank(message = "First name must be not null !")
    private String firstName;

    @NotBlank(message = "Last name must be not null !")
    private String lastName;

    @Size(min = 6,  message = "Password must be at least 6 character !")
    @NotBlank(message = "Password must be not null !")
    private String password;


    @NotBlank(message = "Confirm password  must be not null !")
    private String rePassword;

    @ValidEmail
    @NotBlank(message = "Email must be not null !")
    private String email;
    public SignUpForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
