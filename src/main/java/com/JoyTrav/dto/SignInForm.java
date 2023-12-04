package com.JoyTrav.dto;

import jakarta.validation.constraints.NotBlank;

public class SignInForm {
    @NotBlank(message = "Please enter email !")
    private String email;

    @NotBlank(message = "Please enter email !")
    private String password;

    public SignInForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
