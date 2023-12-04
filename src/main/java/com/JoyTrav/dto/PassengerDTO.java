package com.JoyTrav.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class PassengerDTO {
    private String groupAge;
    private String fullName;
    private String gender;

    private String dob;

    public PassengerDTO() {
    }

    public String getGroupAge() {
        return groupAge;
    }

    public void setGroupAge(String groupAge) {
        this.groupAge = groupAge;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
